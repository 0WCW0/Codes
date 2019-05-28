package com.itwanli.bean;

import com.itwanli.dao.impl.TeacherDaoImpl;

/**
 * Page类 ： 分页辅助类
 */
public class Page {

    private int pageNum;    // 页码数,当前第几页
    private int pageSize = 3;   // 每页显示数量,默认显示3条
    private int pageTitle;  // 总页数
    private int recordsNum; // 总记录数

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(int pageTitle) {
        this.pageTitle = pageTitle;
    }

    public int getRecordsNum() {
        return recordsNum;
    }

    public void setRecordsNum(int recordsNum) {
        this.recordsNum = recordsNum;
    }

    public Page() {
    }

    public Page(int pageNum, int pageSize, int pageTitle, int recordsNum) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.pageTitle = pageTitle;
        this.recordsNum = recordsNum;
    }

}
