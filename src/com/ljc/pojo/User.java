package com.ljc.pojo;

/**
 * Created by matt on 2018/4/22.
 */
public class User {
    private int id;
    private String account;
    private String password;
    private char authority;
    private String studentId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getAuthority() {
        return authority;
    }

    public void setAuthority(char authority) {
        this.authority = authority;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", authority=" + authority +
                ", studentId='" + studentId + '\'' +
                '}';
    }
}
