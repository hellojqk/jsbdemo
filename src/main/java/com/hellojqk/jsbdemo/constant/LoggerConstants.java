package com.hellojqk.jsbdemo.constant;

 /** 日志常量
 * @author wangyang
 * @date 2020/9/7 3:32 下午
 */
public class LoggerConstants {
    /**
     * 所属组
     */
    public static final String GROUP = "group";
    /**
     * 所属项目
     */
    public static final String PROJECT = "project";
    /**
     * 等级
     */
    public static final String LEVEL = "level";
    /**
     * 标题，关键字 使用MDC.put透传
     */
    public static final String TITLE = "title";
    /**
     * 日志明细，对应logger.info(detail)
     */
    public static final String DETAIL = "detail";
    /**
     * 时间戳，毫秒
     */
    public static final String TIMESTAMP = "timestamp";
    /**
     * 上下文关键信息，MDC.put传入
     */
    public static final String CONTEXT = "context";
    /**
     * 用户ID，MDC.put传入
     */
    public static final String USER_ID = "userId";
    /**
     * 输出日志代码类和行号
     */
    public static final String CALLER = "caller";
    /**
     * 服务系统中透传的请求ID，MDC.put传入
     */
    public static final String X_REQUEST_ID = "x-request-id";
    /**
     * 链路跟踪中的ID，MDC.put传入
     */
    public static final String TRACE_ID = "trace_id";
    /**
     * 应用自己生成的请求ID，MDC.put传入
     */
    public static final String REQUEST_ID = "request_id";
    /**
     * 服务端IP,一般不用记，MDC.put传入
     */
    public static final String SERVER_IP = "server_ip";
    /**
     * 客户端IP，MDC.put传入
     */
    public static final String CLIENT_IP = "client_ip";
    /**
     * 网关中的ID，MDC.put传入
     */
    public static final String APP_ID = "app_id";
    /**
     * 请求类型，MDC.put传入
     */
    public static final String TYPE = "type";
    /**
     * 请求类型，http_request，MDC.put传入
     */
    public static final String TYPE_HTTP_REQUEST = "http_request";
}