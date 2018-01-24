package com.dgt.model;

import java.util.Date;
import javax.persistence.*;

public class contestants {
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
    private String realname;

    @Column(name = "userPhoto")
    private String userphoto;

    @Column(name = "videoUrl")
    private String videourl;

    private String sex;

    private String mobile;

    private String area;

    @Column(name = "supperiorId")
    private String supperiorid;

    private String status;

    @Column(name = "totalPoint")
    private String totalpoint;

    @Column(name = "totalHits")
    private String totalhits;

    @Column(name = "statusName")
    private String statusname;

    @Column(name = "create_date")
    private Date createDate;

    /**
     * @return relation_id
     */
    public Long getRelationId() {
        return relationId;
    }

    /**
     * @param relationId
     */
    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    /**
     * 获取微信oppenId
     *
     * @return id - 微信oppenId
     */
    public String getId() {
        return id;
    }

    /**
     * 设置微信oppenId
     *
     * @param id 微信oppenId
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number
     */
    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    /**
     * @return qq
     */
    public String getQq() {
        return qq;
    }

    /**
     * @param qq
     */
    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    /**
     * @return realName
     */
    public String getRealname() {
        return realname;
    }

    /**
     * @param realname
     */
    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    /**
     * @return userPhoto
     */
    public String getUserphoto() {
        return userphoto;
    }

    /**
     * @param userphoto
     */
    public void setUserphoto(String userphoto) {
        this.userphoto = userphoto == null ? null : userphoto.trim();
    }

    /**
     * @return videoUrl
     */
    public String getVideourl() {
        return videourl;
    }

    /**
     * @param videourl
     */
    public void setVideourl(String videourl) {
        this.videourl = videourl == null ? null : videourl.trim();
    }

    /**
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * @return area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * @return supperiorId
     */
    public String getSupperiorid() {
        return supperiorid;
    }

    /**
     * @param supperiorid
     */
    public void setSupperiorid(String supperiorid) {
        this.supperiorid = supperiorid == null ? null : supperiorid.trim();
    }

    /**
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return totalPoint
     */
    public String getTotalpoint() {
        return totalpoint;
    }

    /**
     * @param totalpoint
     */
    public void setTotalpoint(String totalpoint) {
        this.totalpoint = totalpoint == null ? null : totalpoint.trim();
    }

    /**
     * @return totalHits
     */
    public String getTotalhits() {
        return totalhits;
    }

    /**
     * @param totalhits
     */
    public void setTotalhits(String totalhits) {
        this.totalhits = totalhits == null ? null : totalhits.trim();
    }

    /**
     * @return statusName
     */
    public String getStatusname() {
        return statusname;
    }

    /**
     * @param statusname
     */
    public void setStatusname(String statusname) {
        this.statusname = statusname == null ? null : statusname.trim();
    }

    /**
     * @return create_date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}