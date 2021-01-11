package io.github.xiaohua.support.commons.base.page;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能：分页参数
 *
 * @Author zhongxiaohua
 * @Date 2018/7/4 16:26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page implements Serializable {

    /**
     * 页码
     */
    private int pageIndex;
    /**
     * 页大小
     */
    private int pageSize;
    /**
     * 总记录数
     */
    private int totalItem;

    public int getPageSize() {
        if (pageSize <= 0) {
            pageSize = 20;
        }
        return pageSize;
    }

    /**
     * 返回页码，当页码为空或者小于等于0时，默认返回1
     */
    public int getPageIndex() {
        if (pageIndex <= 0) {
            pageIndex = 1;
        }
        return pageIndex;
    }

    /**
     * 通过计算得出总页数
     * @return 总页数
     */
    public int getTotalPage() {
        return (totalItem + pageSize - 1) / getPageSize();
    }

}
