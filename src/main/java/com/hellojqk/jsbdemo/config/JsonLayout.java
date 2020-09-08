package com.hellojqk.jsbdemo.config;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.ThrowableProxy;
import ch.qos.logback.classic.spi.ThrowableProxyUtil;
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

    public void setGroup(String group) {
        this.group = group;
    }

    public void setProject(String project) {
        this.project = project;
    }

    private String[] extractFields = new String[]{
            LoggerConstants.Title,
            LoggerConstants.UserId,
            LoggerConstants.ServerIp,
            LoggerConstants.ClientIp,
            LoggerConstants.RequestId};

    @Override
    public String doLayout(ILoggingEvent event) {
        StringBuffer strBuf = new StringBuffer(128);
        strBuf.append(CoreConstants.CURLY_LEFT);
        addFields(strBuf, LoggerConstants.Timestamp, event.getTimeStamp());
        addFields(strBuf, LoggerConstants.Level, event.getLevel().toString().toLowerCase());
        addFields(strBuf, LoggerConstants.Group, group);
        addFields(strBuf, LoggerConstants.Project, project);

        if (event.getCallerData() != null && event.getCallerData().length > 0) {
            StackTraceElement stackTraceElement = event.getCallerData()[0];
            addFields(strBuf, LoggerConstants.Caller, stackTraceElement.getClassName() + stackTraceElement.getLineNumber());
//            ObjectMapper mapper = new ObjectMapper();
//            try {
//               System.out.println(mapper.writeValueAsString(event.getCallerData()));
//            } catch (JsonProcessingException e) {
//                e.printStackTrace();
//            }
        }

        if (event.getLevel() == Level.ERROR) {
            IThrowableProxy iThrowableProxy = event.getThrowableProxy();
            String msg = event.getFormattedMessage() + CoreConstants.LINE_SEPARATOR;
            //确认抛出异常
            if (iThrowableProxy != null && iThrowableProxy instanceof ThrowableProxy) {
                msg = String.format("%s%s", msg, ThrowableProxyUtil.asString(iThrowableProxy));
            }
            addFields(strBuf, LoggerConstants.Detail, replace(msg));
        } else {
            addFields(strBuf, LoggerConstants.Detail, replace(event.getFormattedMessage()));
        }


        Map<String, String> contextMap = event.getMDCPropertyMap();
        if (contextMap != null && !contextMap.isEmpty()) {
            for (int i = 0; i < extractFields.length; i++) {
                String currentData = contextMap.get(extractFields[i]);
                if (currentData != null && !currentData.isEmpty()) {
                    addFields(strBuf, extractFields[i], currentData);
                }
            }
            strBuf.append(CoreConstants.DOUBLE_QUOTE_CHAR);
            strBuf.append(LoggerConstants.Context);
            strBuf.append(CoreConstants.DOUBLE_QUOTE_CHAR);
            strBuf.append(CoreConstants.COLON_CHAR);
            strBuf.append(CoreConstants.CURLY_LEFT);
            for (Map.Entry<String, String> entry : contextMap.entrySet()) {
                addFields(strBuf, entry.getKey(), entry.getValue());
            }
            strBuf.replace(strBuf.length() - 1, strBuf.length(), CoreConstants.EMPTY_STRING);
            strBuf.append(CoreConstants.CURLY_RIGHT);
        } else {
            strBuf.replace(strBuf.length() - 1, strBuf.length(), CoreConstants.EMPTY_STRING);
        }
        strBuf.append(CoreConstants.CURLY_RIGHT);
        strBuf.append(CoreConstants.LINE_SEPARATOR);
        return strBuf.toString();
    }

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

    public String replace(String str) {
//        return str.replace("\"", "\\\"");
        return str.replace("\"", "\\\"").replace("\r", "\\r").replace("\n", "\\n");
    }
}
