package com.rktirtho.hawkeye.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Organization {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("woner")
    @Expose
    private String woner;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("regDate")
    @Expose
    private String regDate;

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

    public String getWoner() {
        return woner;
    }

    public void setWoner(String woner) {
        this.woner = woner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", woner='" + woner + '\'' +
                ", address='" + address + '\'' +
                ", regDate='" + regDate + '\'' +
                '}';
    }
}
