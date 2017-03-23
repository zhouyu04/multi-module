package com.zzyy.rs.entities;

import java.math.BigDecimal;
import java.util.Date;

public class TransactionFlow {
    private Integer id;

    private String rsName;

    private Integer rsNum;

    private BigDecimal operateamount;

    private Date dateCreate;

    private String description;

    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRsName() {
        return rsName;
    }

    public void setRsName(String rsName) {
        this.rsName = rsName == null ? null : rsName.trim();
    }

    public Integer getRsNum() {
        return rsNum;
    }

    public void setRsNum(Integer rsNum) {
        this.rsNum = rsNum;
    }

    public BigDecimal getOperateamount() {
        return operateamount;
    }

    public void setOperateamount(BigDecimal operateamount) {
        this.operateamount = operateamount;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}