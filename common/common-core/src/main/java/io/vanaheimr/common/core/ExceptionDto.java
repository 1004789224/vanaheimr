package io.vanaheimr.common.core;

import java.util.Map;

/**
 * 通用异常响应
 *
 * @param code    错误码
 * @param message 错误信息
 * @param module  模块
 * @param path    请求路径
 * @param method  请求方法
 * @param args    请求参数
 * @author Vanaheimr
 */
public record ExceptionDto(
        int code,
        String message,
        String module,
        String path,
        String method,
        Map<String, Object> args
) {
}
