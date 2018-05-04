package com.ljc.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by matt on 2018/4/22.
 */
public class Announcement {

    private int id;
    private Date time;
    private String content;
    private int createrId;
    private int adjusterId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public String getTimeStr() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(time);
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCreaterId() {
        return createrId;
    }

    public void setCreaterId(int createrId) {
        this.createrId = createrId;
    }

    public int getAdjusterId() {
        return adjusterId;
    }

    public void setAdjusterId(int adjusterId) {
        this.adjusterId = adjusterId;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "id=" + id +
                ", time=" + time +
                ", content='" + content + '\'' +
                ", createrId=" + createrId +
                ", adjusterId=" + adjusterId +
                '}';
    }
}
