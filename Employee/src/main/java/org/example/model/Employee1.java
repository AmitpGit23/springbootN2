package org.example.model;

public class Employee1 {
    int eid,no;
    String name,email;
    Manager m1;

    public int getEid() {
        return eid;
    }
    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no= no;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Manager getM1() {
        return m1;
    }
    public void setM1(Manager m1) {
        this.m1 = m1;
    }
}
