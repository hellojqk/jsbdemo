package com.hellojqk.jsbdemo.config;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.LayoutBase;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.slf4j.MDC;
import reactor.core.CoreSubscriber;

import java.util.Map;

/**
 * @author wangyang
 * @date 2020/9/4 3:30 下午
 */
public class LogBackLayoutConfig extends LayoutBase<ILoggingEvent> {
    @Override
    public String doLayout(ILoggingEvent event) {
        StringBuffer sbuf = new StringBuffer(128);
        sbuf.append(CoreConstants.CURLY_LEFT);
        addFields(sbuf,"timestamp",event.getTimeStamp());
        Map<String, String> contextMap = MDC.getCopyOfContextMap();
        if (!contextMap.isEmpty()) {
            sbuf.append(contextMap);
        }
        sbuf.append(CoreConstants.CURLY_RIGHT);
        sbuf.append(CoreConstants.LINE_SEPARATOR);
        return sbuf.toString();
    }

    public void addFields(StringBuffer sbuf,String key,Object value){
        sbuf.append(CoreConstants.DOUBLE_QUOTE_CHAR);
        sbuf.append(key);
        sbuf.append(CoreConstants.DOUBLE_QUOTE_CHAR);
        sbuf.append(CoreConstants.COLON_CHAR);
        sbuf.append(CoreConstants.DOUBLE_QUOTE_CHAR);
        sbuf.append(value);
        sbuf.append(CoreConstants.DOUBLE_QUOTE_CHAR);
    }
}
