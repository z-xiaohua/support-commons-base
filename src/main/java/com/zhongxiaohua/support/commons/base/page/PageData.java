package com.zhongxiaohua.support.commons.base.page;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能：分页数据传输对象
 *
 * @Author zhongxiaohua
 * @Date 2018/6/12 14:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageData<E> implements Serializable{

    private static final long serialVersionUID = 8148912660169002849L;

    /**
     * 结果集
     */
    private List<E> list;

    /**
     * 分页参数
     */
    private Page page;

    
    /**
     * 初始化分页信息
     * @param pageIndex 页码
     * @param pageSize 页大小
     */
    public PageData(int pageIndex, int pageSize) {
        this.page = new Page(pageIndex, pageSize, 0);
        this.list = Collections.emptyList();
    }

    /**
     * 初始化分页信息
     * @param pageRequest 分页请求参数类
     */
    public PageData(PageRequest pageRequest) {
        this.page = new Page(pageRequest.getPageIndex(), pageRequest.getPageSize(), 0);
        this.list = Collections.emptyList();
    }
    
    /**
     * @param list 数据列表
     * @param totalCount 总记录数
     * @param pageRequest 分页请求对象
     */
    public PageData(List<E> list, int totalCount, PageRequest pageRequest){
        this.page = new Page(pageRequest.getPageIndex(), pageRequest.getPageSize(), totalCount);
        this.list = list;
    }


    /**
     * 创建一个空的分页数据对象
     * @return 分页结果对象
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static PageData newEmptyPage(){
        PageData pageData = new PageData();
        pageData.setList(Collections.emptyList());
        pageData.setPage(new Page());
        return pageData;
    }

}
