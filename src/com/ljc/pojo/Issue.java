package com.ljc.pojo;

import java.util.Date;

/**
 * Created by matt on 2018/4/27.
 */
public class Issue {
    private int id;
    private String name;
    private int studentId;
    private Date time;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Date getTime() {
        return time;
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

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentId=" + studentId +
                ", time=" + time +
                ", content='" + content + '\'' +
                '}';
    }
}
