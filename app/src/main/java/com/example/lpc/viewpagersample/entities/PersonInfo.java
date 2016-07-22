package com.example.lpc.viewpagersample.entities;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * 用户信息
 * Created by lpc on 2016/7/19.
 */
public class PersonInfo implements Serializable {

    /**
     * 用户对象Id
     */
    String objectId ;
    /**
     * 用户名
     */
    String username ;
    /**
     * 用户密码
     */
    String password ;
    /**
     * 用户手机号是否有效
     */
    Boolean mobilePhoneNumbleVerified ;
    /**
     * 用户手机号
     */
    String mobilePhoneNumber ;
    /**
     * 用户邮箱是否有效
     */
    Boolean emailVerified ;
    /**
     * 用户邮箱
     */
    String email ;
    /**
     * 用户信息创建日期
     */
    String createdAt ;
    /**
     * 用户信息上次更新
     */
    String updateAt ;
    /**
     * 用户头像图片
     */
    Bitmap headImg ;
    /**
     * 用户头像字节流
     */
    String headImgStr ;

    public String getHeadImgStr() {
        return headImgStr;
    }

    public void setHeadImgStr(String headImgStr) {
        this.headImgStr = headImgStr;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getMobilePhoneNumbleVerified() {
        return mobilePhoneNumbleVerified;
    }

    public void setMobilePhoneNumbleVerified(Boolean mobilePhoneNumbleVerified) {
        this.mobilePhoneNumbleVerified = mobilePhoneNumbleVerified;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public Boolean getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public Bitmap getHeadImg() {
        return headImg;
    }

    public void setHeadImg(Bitmap headImg) {
        this.headImg = headImg;
    }
}
