package com.itheima.domain;

import java.util.List;

public class PageBean {
    //页面必须传的属性
    private Integer pageNum; /* 当前页码 */
    private Integer pageSize; /* 每页个数 */
    //后台必须查询的
    private List list; /* 每页的数据 */
    private Long total; /* 总记录数 */
    //可以通过计算得到的属性
    private Integer totalPage; /* 总页数 */
    private Integer prePage; /* 上一页 */
    private Integer nextPage; /* 上一页 */

    //要创建分页对象必须给pageBean传3个属性

    public PageBean(Integer pageNum, Integer pageSize, Long total) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        //在分页对象初始化的时候,确保除了list属性都有值
        Long totalpageLong = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
        this.totalPage = totalpageLong.intValue();
        this.prePage = pageNum == 1 ? 1 : pageNum - 1;
        this.nextPage = prePage == totalPage ? totalPage : pageNum + 1;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public List getList() {
        return list;
    }

    public Long getTotal() {
        return total;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public Integer getPrePage() {
        return prePage;
    }

    public Integer getNextPage() {
        return nextPage;
    }
}
