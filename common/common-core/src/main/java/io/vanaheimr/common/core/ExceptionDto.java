package io.vanaheimr.common.core;

/**
 * 通用异常响应
 *
 * @param code    错误码
 * @param message 错误信息
 * @param module  模块
 * @author Vanaheimr
 */
public record ExceptionDto(
        int code,
        String message,
        String module,

) {
}
