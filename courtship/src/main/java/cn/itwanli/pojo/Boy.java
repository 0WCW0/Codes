package cn.itwanli.pojo;

public class Boy {
    private int bid;
    private String bname;
    private String bage;
    private String bheight;
    private String bweight;
    private String bhobby;
    private String bcolor;

    public Boy(int bid, String bname, String bage, String bheight, String bweight, String bhobby, String bcolor) {
        this.bid = bid;
        this.bname = bname;
        this.bage = bage;
        this.bheight = bheight;
        this.bweight = bweight;
        this.bhobby = bhobby;
        this.bcolor = bcolor;
    }

    public Boy(String bname, String bage, String bheight, String bweight, String bhobby, String bcolor) {
        this.bname = bname;
        this.bage = bage;
        this.bheight = bheight;
        this.bweight = bweight;
        this.bhobby = bhobby;
        this.bcolor = bcolor;
    }

    public Boy() {
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBage() {
        return bage;
    }

    public void setBage(String bage) {
        this.bage = bage;
    }

    public String getBheight() {
        return bheight;
    }

    public void setBheight(String bheight) {
        this.bheight = bheight;
    }

    public String getBweight() {
        return bweight;
    }

    public void setBweight(String bweight) {
        this.bweight = bweight;
    }

    public String getBhobby() {
        return bhobby;
    }

    public void setBhobby(String bhobby) {
        this.bhobby = bhobby;
    }

    public String getBcolor() {
        return bcolor;
    }

    public void setBcolor(String bcolor) {
        this.bcolor = bcolor;
    }
}
