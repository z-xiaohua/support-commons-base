package io.github.xiaohua.support.commons.base.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.xiaohua.support.commons.base.exception.ServerCode;
import java.io.Serializable;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;

/**
 * 公共响应对象
 *
 * @author zhongxiaohua
 * @date 2020/12/22
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResultSet<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 响应编码
     */
    private Integer resultCode;
    /**
     * 响应消息
     */
    private String resultMsg;
    /**
     * 响应数据
     */
    private T resultData;
    /**
     * 链路追踪id
     */
    public String traceId;

    public static <T> ResultSet<T> success(T resultData) {
        return new ResultSet<>(ServerCode.SUCCESS.getCode(), ServerCode.SUCCESS.getDesc(), resultData, null);
    }

    public static <T> ResultSet<T> fail() {
        return new ResultSet<>(ServerCode.BUSINESS_ERROR.getCode(), ServerCode.BUSINESS_ERROR.getDesc(), null, null);
    }

    public static <T> ResultSet<T> fail(String resultMsg) {
        return new ResultSet<>(ServerCode.BUSINESS_ERROR.getCode(), resultMsg, null, null);
    }

    public static <T> ResultSet<T> build(Integer resultCode, String resultMsg) {
        return new ResultSet<>(resultCode, resultMsg, null, null);
    }

    public static <T> ResultSet<T> build(Integer resultCode, String resultMsg, T resultData) {
        return new ResultSet<>(resultCode, resultMsg, resultData, null);
    }

    public String getTraceId() {
        if (StringUtils.isNotBlank(traceId)) {
            return traceId;
        }
        return MDC.get("traceId");
    }

    @JSONField(serialize = false)
    @JsonIgnore
    public boolean isSuccess() {
        return Objects.equals(resultCode, ServerCode.SUCCESS.getCode());
    }
}
