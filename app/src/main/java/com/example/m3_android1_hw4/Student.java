package com.example.m3_android1_hw4;

import java.io.Serializable;

public class Student implements Serializable, Comparable<Student>{
    private String fullName;
    private String phoneNumber;
    private String group;
    private int ID;

    Student(String fullName, String phoneNumber, String group) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.group = group;
    }

    void setID(int ID) {
        this.ID = ID;
    }

    public int getId() {
        return ID;
    }

    String getFullName() {
        return fullName;
    }

    String getPhoneNumber() {
        return phoneNumber;
    }

    String getGroup() {
        return group;
    }

    @Override
    public int compareTo(Student o) {
        return fullName.compareTo(o.getFullName());
    }
}
