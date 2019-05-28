package cn.itwanli.pojo;

public class Lady {
    private int lid;
    private String lname;
    private String lage;
    private String lheight;
    private String lweight;
    private String lhobby;
    private String lcolor;

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLage() {
        return lage;
    }

    public void setLage(String lage) {
        this.lage = lage;
    }

    public String getLheight() {
        return lheight;
    }

    public void setLheight(String lheight) {
        this.lheight = lheight;
    }

    public String getLweight() {
        return lweight;
    }

    public void setLweight(String lweight) {
        this.lweight = lweight;
    }

    public String getLhobby() {
        return lhobby;
    }

    public void setLhobby(String lhobby) {
        this.lhobby = lhobby;
    }

    public String getLcolor() {
        return lcolor;
    }

    public void setLcolor(String lcolor) {
        this.lcolor = lcolor;
    }

    public Lady() {
    }

    public Lady(String lname, String lage, String lheight, String lweight, String lhobby, String lcolor) {
        this.lname = lname;
        this.lage = lage;
        this.lheight = lheight;
        this.lweight = lweight;
        this.lhobby = lhobby;
        this.lcolor = lcolor;
    }

    public Lady(int lid, String lname, String lage, String lheight, String lweight, String lhobby, String lcolor) {
        this.lid = lid;
        this.lname = lname;
        this.lage = lage;
        this.lheight = lheight;
        this.lweight = lweight;
        this.lhobby = lhobby;
        this.lcolor = lcolor;
    }
}
