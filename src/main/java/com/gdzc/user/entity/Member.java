package com.gdzc.user.entity;

import com.gdzc.commons.orm.entity.IdEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Liu_Zhichao on 14-6-5.
 */
@Entity
@Table(name = "lzc_gdzc_user")
public class Member extends IdEntity {
    private String loginName;//登录名
    private String password;//密码
    private String name;//姓名
    private String sex;//性别
    private String address;//居住地址
    private String birthday;//出身日期
    private Integer age;//年龄
    private String censusRegister;//户籍
    private String status;//身份(团员、党员)
    private String email;//邮箱
    private Integer telNum;//电话号码
    private Integer phoneNum;//手机号码
    private Integer IDCard;//身份证号
    private String country;//国家
    private String type;//用户类别
    private String state = "YES";//是否启用,YES-启用,NO-不启用
    private String condition;//状态

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCensusRegister() {
        return censusRegister;
    }

    public void setCensusRegister(String censusRegister) {
        this.censusRegister = censusRegister;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelNum() {
        return telNum;
    }

    public void setTelNum(Integer telNum) {
        this.telNum = telNum;
    }

    public Integer getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(Integer phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getIDCard() {
        return IDCard;
    }

    public void setIDCard(Integer IDCard) {
        this.IDCard = IDCard;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
