package com.hellojqk.jsbdemo.config;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.*;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.LayoutBase;
import com.hellojqk.jsbdemo.constant.LoggerConstants;

import java.util.Map;

/**
 * @author wangyang
 * @date 2020/9/4 3:30 下午
 */
public class JsonLayout extends LayoutBase<ILoggingEvent> {

    private String group;
    private String project;

    /**
     * 接受logback-spring.xml中layout下传入的group
     *
     * @param group
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * 接受logback-spring.xml中layout下传入的project
     *
     * @param project
     */
    public void setProject(String project) {
        this.project = project;
    }

    /**
     * 需要从MDC中提取到日志json第一层的属性
     */
    private String[] extractFields = new String[]{
            LoggerConstants.TITLE,
            LoggerConstants.USER_ID,
            LoggerConstants.SERVER_IP,
            LoggerConstants.CLIENT_IP,
            LoggerConstants.REQUEST_ID
    };

    /**
     * 处理logger信息并返回JSON字符串数据，要求单行
     *
     * @param event
     * @return
     */
    @Override
    public String doLayout(ILoggingEvent event) {
        StringBuffer strBuf = new StringBuffer(128);
        strBuf.append(CoreConstants.CURLY_LEFT);
        addFields(strBuf, LoggerConstants.TIMESTAMP, event.getTimeStamp());
        addFields(strBuf, LoggerConstants.LEVEL, event.getLevel().toString().toLowerCase());
        addFields(strBuf, LoggerConstants.GROUP, group);
        addFields(strBuf, LoggerConstants.PROJECT, project);

        if (event.getLevel() == Level.ERROR) {
            IThrowableProxy iThrowableProxy = event.getThrowableProxy();
            String msg = event.getFormattedMessage() + CoreConstants.LINE_SEPARATOR;
            //确认抛出异常
            if (iThrowableProxy instanceof ThrowableProxy) {
                msg = String.format("%s%s", msg, ThrowableProxyUtil.asString(iThrowableProxy));
            }
            addFields(strBuf, LoggerConstants.DETAIL, replace(msg));
        } else {
            addFields(strBuf, LoggerConstants.DETAIL, replace(event.getFormattedMessage()));
        }


        Map<String, String> contextMap = event.getMDCPropertyMap();
        if (!contextMap.isEmpty()) {
            //需要从MDC中提取到日志json第一层的属性
            for (int i = 0; i < extractFields.length; i++) {
                String currentData = contextMap.get(extractFields[i]);
                if (currentData != null && !currentData.isEmpty()) {
                    addFields(strBuf, extractFields[i], currentData);
                }
            }
        }

        //添加context前半部分
        strBuf.append(CoreConstants.DOUBLE_QUOTE_CHAR);
        strBuf.append(LoggerConstants.CONTEXT);
        strBuf.append(CoreConstants.DOUBLE_QUOTE_CHAR);
        strBuf.append(CoreConstants.COLON_CHAR);
        //context内容左括号
        strBuf.append(CoreConstants.CURLY_LEFT);

        if (event.getCallerData() != null && event.getCallerData().length > 0) {
            StackTraceElement stackTraceElement = event.getCallerData()[0];
            addFields(strBuf, LoggerConstants.CALLER, stackTraceElement.getClassName() + CoreConstants.COLON_CHAR + stackTraceElement.getLineNumber());
        }
        if (!contextMap.isEmpty()) {
            for (Map.Entry<String, String> entry : contextMap.entrySet()) {
                addFields(strBuf, entry.getKey(), entry.getValue());
            }
        }
        //清理addFields函数调用后的最后一位,
        strBuf.replace(strBuf.length() - 1, strBuf.length(), CoreConstants.EMPTY_STRING);

        //context内容右括号
        strBuf.append(CoreConstants.CURLY_RIGHT);

        strBuf.append(CoreConstants.CURLY_RIGHT);
        strBuf.append(CoreConstants.LINE_SEPARATOR);
        return strBuf.toString();
    }

    /**
     * 拼接字符串
     *
     * @param sbuf
     * @param key
     * @param value
     */
    public void addFields(StringBuffer sbuf, String key, Object value) {
        sbuf.append(CoreConstants.DOUBLE_QUOTE_CHAR);
        sbuf.append(key);
        sbuf.append(CoreConstants.DOUBLE_QUOTE_CHAR);
        sbuf.append(CoreConstants.COLON_CHAR);
        sbuf.append(CoreConstants.DOUBLE_QUOTE_CHAR);
        sbuf.append(value);
        sbuf.append(CoreConstants.DOUBLE_QUOTE_CHAR);
        sbuf.append(CoreConstants.COMMA_CHAR);
    }

    /**
     * 踢出换行符和引号
     *
     * @param str
     * @return
     */
    public String replace(String str) {
        return str.replace("\"", "\\\"").
                replace("\r", "\\r").
                replace("\n", "\\n").
                replace("\t", "\\t");
    }
}
