package io.github.xiaohua.support.commons.base.exception;


import java.util.Objects;
import lombok.Getter;

/**
 * Server服务状态码
 *
 * @author zhongxiaohua
 */
@Getter
public enum ServerCode {

    /**
     * 成功
     */
    SUCCESS(0, "success"),
    /**
     * 系统系统
     */
    ERROR(1000, "系统繁忙，请稍后再试"),
    /**
     * 业务异常
     */
    BUSINESS_ERROR(1002, "系统繁忙，请稍后再试"),
    /**
     * 参数不合法
     */
    INVALID_PARAMS_CONVERSION(1003, "请求参数非法");

    /**
     * 状态码
     */
    private final Integer code;
    /**
     * 描述
     */
    private final String desc;

    ServerCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ServerCode getInstance(Integer code) {
        for (ServerCode entity : ServerCode.values()) {
            if (Objects.equals(entity.getCode(), code)) {
                return entity;
            }
        }
        return null;
    }


}
