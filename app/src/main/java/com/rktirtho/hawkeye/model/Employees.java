package com.rktirtho.hawkeye.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Employees {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("orgId")
    @Expose
    private Integer orgId;
    @SerializedName("orgName")
    @Expose
    private String orgName;
    @SerializedName("imageId")
    @Expose
    private String imageId;
    @SerializedName("regesteredTime")
    @Expose
    private String regesteredTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getRegesteredTime() {
        return regesteredTime;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public void setRegesteredTime(String regesteredTime) {
        this.regesteredTime = regesteredTime;
    }
}
