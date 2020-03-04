package com.example.pool.druid.pojo;

public class UserDb2 {
    private Integer id;

    private String name;

    private Integer gender;

    private Integer age;

    private Integer status;

    private String remark;

    private String myAddr;

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
        this.name = name == null ? null : name.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getMyAddr() {
        return myAddr;
    }

    public void setMyAddr(String myAddr) {
        this.myAddr = myAddr == null ? null : myAddr.trim();
    }
}