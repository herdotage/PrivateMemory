package com.example.lpc.viewpagersample.entities;

import android.graphics.Bitmap;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by lpc on 2016/7/19.
 */
public class PasswordInfo implements Serializable {

    /**
     * 密码对象Id
     */
    String objectId ;
    /**
     * 网站名
     */
    String siteName ;
    /**
     * 网址
     */
    String siteAddress;
    /**
     * 账号
     */
    String userAccount;
    /**
     * 用户密码
     */
    String password ;
    /**
     * 上次的密码
     */
    String lastPassword ;
    /**
     * 用户手机号
     */
    String mobilePhoneNumber ;
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
     * 网址logo图片
     */
    Bitmap webImg ;
    /**
     * 网址图片字节流
     */
    String webImgStr ;

    public PasswordInfo() {
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteAddress() {
        return siteAddress;
    }

    public void setSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastPassword() {
        return lastPassword;
    }

    public void setLastPassword(String lastPassword) {
        this.lastPassword = lastPassword;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
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

    public Bitmap getWebImg() {
        return webImg;
    }

    public void setWebImg(Bitmap webImg) {
        this.webImg = webImg;
    }

    public String getWebImgStr() {
        return webImgStr;
    }

    public void setWebImgStr(String webImgStr) {
        this.webImgStr = webImgStr;
    }
}
