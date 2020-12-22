package com.zhongxiaohua.support.commons.base.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

/**
 * 业务异常基类
 *
 * @author zhongxiaohua
 */
@Getter
@Setter
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = -7320959498334150097L;

    /***
     * 错误编码
     */
    private Integer errorCode;

    /**
     * 异常信息描述
     */
    private String message;

    public BaseException(ServerCode serverCode) {
        super();
        Assert.notNull(serverCode, "serverCode is null");
        this.errorCode = serverCode.getCode();
        this.message = serverCode.getDesc();
    }

    public BaseException(ServerCode serverCode, String message) {
        super(message);
        Assert.notNull(serverCode, "serverCode is null");
        this.errorCode = serverCode.getCode();
        this.message = (null == message || message.length() == 0) ? serverCode.getDesc() : message;
    }

    public BaseException(String message) {
        super(message);
        this.errorCode = ServerCode.BUSINESS_ERROR.getCode();
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
