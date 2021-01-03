package com.rktirtho.hawkeye.model;

public class About {
    private String name;
    private String title;
    private String roll;
    private String regNo;

    public About() {
    }

    public About(String name, String title, String roll, String regNo) {
        this.name = name;
        this.title = title;
        this.roll = roll;
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }
}
