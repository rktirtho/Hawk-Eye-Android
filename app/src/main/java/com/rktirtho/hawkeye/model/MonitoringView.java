package com.rktirtho.hawkeye.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MonitoringView {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("personId")
    @Expose
    private Integer personId;
    @SerializedName("area")
    @Expose
    private String area;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("permitted")
    @Expose
    private Boolean permitted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Boolean getPermitted() {
        return permitted;
    }

    public void setPermitted(Boolean permitted) {
        this.permitted = permitted;
    }

}