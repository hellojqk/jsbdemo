package com.hellojqk.jsbdemo.config;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.LayoutBase;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @author wangyang
 * @date 2020/9/4 3:30 下午
 */
public class LogBackLayoutConfig extends LayoutBase<ILoggingEvent> {

    private String group;
    private String project;

    public void setGroup(String group) {
        this.group = group;
    }

    public void setProject(String project) {
        this.project = project;
    }

    @Override
    public String doLayout(ILoggingEvent event) {

        StringBuffer sbuf = new StringBuffer(128);
        sbuf.append(CoreConstants.CURLY_LEFT);
        addFields(sbuf, "group", group);
        addFields(sbuf, "project", project);
        addFields(sbuf, "level", event.getLevel().toString().toLowerCase());
        addFields(sbuf, "title", MDC.get("title"));
        addFields(sbuf, "detail", event.getMessage());
        addFields(sbuf, "timestamp", event.getTimeStamp());
        event.getThrowableProxy();
        event.getCallerData();

        if (event.getCallerData() != null && event.getCallerData().length > 0) {
            StackTraceElement stackTraceElement = event.getCallerData()[0];
            addFields(sbuf, "caller", stackTraceElement.getClassName() + stackTraceElement.getLineNumber());
//            ObjectMapper mapper = new ObjectMapper();
//            try {
//               System.out.println(mapper.writeValueAsString(event.getCallerData()));
//            } catch (JsonProcessingException e) {
//                e.printStackTrace();
//            }
        }


        Map<String, String> contextMap = event.getMDCPropertyMap();
        if (!contextMap.isEmpty()) {
            sbuf.append(CoreConstants.DOUBLE_QUOTE_CHAR);
            sbuf.append("context");
            sbuf.append(CoreConstants.DOUBLE_QUOTE_CHAR);
            sbuf.append(CoreConstants.COLON_CHAR);
            sbuf.append(CoreConstants.CURLY_LEFT);
            for (Map.Entry<String, String> entry : contextMap.entrySet()) {
                addFields(sbuf, entry.getKey(), entry.getValue());
            }
            sbuf.replace(sbuf.length() - 1, sbuf.length(), CoreConstants.EMPTY_STRING);
            sbuf.append(CoreConstants.CURLY_RIGHT);
        } else {
            sbuf.replace(sbuf.length() - 1, sbuf.length(), CoreConstants.EMPTY_STRING);
        }
        sbuf.append(CoreConstants.CURLY_RIGHT);
        sbuf.append(CoreConstants.LINE_SEPARATOR);
        return sbuf.toString();
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
}
