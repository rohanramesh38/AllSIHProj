package com.example.rohan.bottomnavigationhach;

public class inpatients {

    private String pname;
    private String page;
    private String pdes;
    private String pnum;


    public inpatients() {
    }

    public inpatients(String pname, String page, String pdes, String pnum) {
        this.pname = pname;
        this.page = page;
        this.pdes = pdes;
        this.pnum = pnum;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPdes() {
        return pdes;
    }

    public void setPdes(String pdes) {
        this.pdes = pdes;
    }

    public String getPnum() {
        return pnum;
    }

    public void setPnum(String pnum) {
        this.pnum = pnum;
    }
}
