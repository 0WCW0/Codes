package cn.itwanli.pojo;

public class Page{
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
}
