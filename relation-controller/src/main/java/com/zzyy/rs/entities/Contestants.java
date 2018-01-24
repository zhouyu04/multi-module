package com.zzyy.rs.entities;

import java.util.Date;
import javax.persistence.*;

public class Contestants {
    @Id
    @Column(name = "relation_id")
    private Long relationId;

    /**
     * 微信oppenId
     */
    private String id;

    private String number;

    private String qq;

    @Column(name = "realName")
    private String realName;

    @Column(name = "userPhoto")
    private String userPhoto;

    @Column(name = "videoUrl")
    private String videoUrl;

    private String sex;

    private String mobile;

    private String area;

    @Column(name = "supperiorId")
    private String supperiorId;

    private String status;

    @Column(name = "totalPoint")
    private String totalPoint;

    @Column(name = "totalHits")
    private String totalHits;

    @Column(name = "statusName")
    private String statusName;

    @Column(name = "create_date")
    private Date createDate;

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSupperiorId() {
        return supperiorId;
    }

    public void setSupperiorId(String supperiorId) {
        this.supperiorId = supperiorId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(String totalPoint) {
        this.totalPoint = totalPoint;
    }

    public String getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(String totalHits) {
        this.totalHits = totalHits;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}