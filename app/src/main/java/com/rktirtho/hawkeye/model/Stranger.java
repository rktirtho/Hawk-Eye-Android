package com.rktirtho.hawkeye.model;

import android.os.health.TimerStat;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.sql.Timestamp;

public class Stranger {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("time")
    @Expose
    private Timestamp time;
    @SerializedName("visited")
    @Expose
    private Integer visited;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Integer getVisited() {
        return visited;
    }

    public void setVisited(Integer visited) {
        this.visited = visited;
    }

}