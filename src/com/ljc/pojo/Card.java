package com.ljc.pojo;

/**
 * Created by matt on 2018/5/9.
 */
public class Card {
    private int id;
    private int studentId;
    private float balance;
    private char state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public char getState() {
        return state;
    }

    public void setState(char state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", balance=" + balance +
                ", state=" + state +
                '}';
    }
}
