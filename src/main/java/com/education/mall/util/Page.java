package com.education.mall.util;

import java.util.List;

/**
 * 分页对象
 */
public class Page<T> {

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
    private int pageNum;

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
    private List<T> list;

    /**
     * 上一页
     */
    private int pre;

    /**
     * 下一页
     */
    private int next;


    public Page() {

    }

    /**
     * 构造分页对象(传入未分页的list)
     *
     * @param pageSize 页大小
     * @param pageNum  页数
     * @param list     待分页记录集合
     */
    public Page(int pageSize, int pageNum, List<T> list) {
        this.start = getStart();
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.total = list.size();
        this.totalPage = getTotalPage();
        this.list = generateList(pageSize, pageNum, list);
        this.pre = getPre();
        this.next = getNext();
    }

    /**
     * 构造分页对象(传入已分页的list)
     *
     * @param pageSize 页大小
     * @param pageNum  页数
     * @param total    总记录数
     * @param list     已分页记录集合
     */
    public Page(int pageSize, int pageNum, int total, List<T> list) {
        this.start = getStart();
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.total = total;
        this.totalPage = getTotalPage();
        this.list = list;
        this.pre = getPre();
        this.next = getNext();
    }

    /**
     * 根据传入参数构造page的list集合
     */
    private List<T> generateList(int pageSize, int pageNum, List<T> list) {
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
        return (this.pageNum - 1) * this.pageSize;
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

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
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

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getPre() {
        return (hasPre()) ? this.pageNum - 1 : 1;
    }

    public int getNext() {
        return (hasNext()) ? this.pageNum + 1 : this.totalPage;
    }

    public boolean hasPre() {
        return this.pageNum > 1;
    }

    public boolean hasNext() {
        return this.pageNum < this.totalPage;
    }

    public void setPre(int pre) {
        this.pre = pre;
    }

    public void setNext(int next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Page{" +
                "start=" + start +
                ", pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                ", total=" + total +
                ", totalPage=" + totalPage +
                ", list=" + list +
                ", pre=" + pre +
                ", next=" + next +
                '}';
    }
}
