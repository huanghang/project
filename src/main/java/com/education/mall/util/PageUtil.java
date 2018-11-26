package com.education.mall.util;

import java.util.List;

/**
 * 分页对象
 */
public class PageUtil {

    /**
     * 页起始位置
     */
    private int start;

    /**
     * 页大小
     */
    private int pageSize;

    /**
     * 当前页
     */
    private int currPage;

    /**
     * 记录总数
     */
    private int total;

    /**
     * 页总数
     */
    private int totalPage;

    /**
     * 页包含的数据对象集合
     */
    private List<?> list;

    /**
     * 上一页
     */
    private int pre;

    /**
     * 下一页
     */
    private int next;


    public PageUtil() {

    }

    /**
     * 构造分页对象(传入未分页的list)
     *
     * @param pageSize 页大小
     * @param page     页数
     * @param list     待分页记录集合
     */
    public PageUtil(int pageSize, int page, List<?> list) {
        this.start = getStart();
        this.pageSize = pageSize;
        this.currPage = page;
        this.total = list.size();
        this.totalPage = getTotalPage();
        this.list = generateList(pageSize, page, list);
        this.pre = getPre();
        this.next = getNext();
    }

    /**
     * 构造分页对象(传入已分页的list)
     *
     * @param pageSize 页大小
     * @param page     页数
     * @param total    总记录数
     * @param list     已分页记录集合
     */
    public PageUtil(int pageSize, int page, int total, List<?> list) {
        this.start = getStart();
        this.pageSize = pageSize;
        this.currPage = page;
        this.total = total;
        this.totalPage = getTotalPage();
        this.list = list;
        this.pre = getPre();
        this.next = getNext();
    }

    /**
     * 根据传入参数构造page的list集合
     */
    private List<?> generateList(int pageSize, int curr, List<?> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        int fromIndex = this.getStart();
        int toIndex = fromIndex + pageSize;
        if (toIndex > list.size()) {
            toIndex = list.size();
        }
        if (fromIndex > toIndex || fromIndex > list.size()) {
            return null;
        }
        return list.subList(fromIndex, toIndex);
    }

    public int getStart() {
        return (this.currPage - 1) * this.pageSize;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPage() {
        return (total % pageSize != 0) ? (total / pageSize) + 1
                : (total / pageSize);
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    public int getPre() {
        return (hasPre()) ? this.currPage - 1 : 1;
    }

    public int getNext() {
        return (hasNext()) ? this.currPage + 1 : this.totalPage;
    }

    public boolean hasPre() {
        return this.currPage > 1;
    }

    public boolean hasNext() {
        return this.currPage < this.totalPage;
    }

    public void setPre(int pre) {
        this.pre = pre;
    }

    public void setNext(int next) {
        this.next = next;
    }

}
