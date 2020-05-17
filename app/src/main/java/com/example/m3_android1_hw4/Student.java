package com.example.m3_android1_hw4;

import java.io.Serializable;

public class Student implements Serializable, Comparable<Student>{
    private String fullName;
    private String phoneNumber;
    private String group;

    public Student(String fullName, String phoneNumber, String group) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.group = group;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public int compareTo(Student o) {
        return fullName.compareTo(o.getFullName());
    }
}
