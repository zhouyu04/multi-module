package com.zzyy.rs.entities;

import java.math.BigDecimal;
import java.util.Date;

public class Account {
    private Integer id;

    private BigDecimal balance;

    private BigDecimal accumulatIncrease;

    private BigDecimal accumulatDecrease;

    private Date createDate;

    private Date modifyDate;

    private String operater;

    private BigDecimal lastBalance;

    private String rsName;

    private String reNum;

    private Integer version;

    private String description;

    private String spell;

    private String firstSpell;

    private BigDecimal operateamount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getAccumulatIncrease() {
        return accumulatIncrease;
    }

    public void setAccumulatIncrease(BigDecimal accumulatIncrease) {
        this.accumulatIncrease = accumulatIncrease;
    }

    public BigDecimal getAccumulatDecrease() {
        return accumulatDecrease;
    }

    public void setAccumulatDecrease(BigDecimal accumulatDecrease) {
        this.accumulatDecrease = accumulatDecrease;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getOperater() {
        return operater;
    }

    public void setOperater(String operater) {
        this.operater = operater == null ? null : operater.trim();
    }

    public BigDecimal getLastBalance() {
        return lastBalance;
    }

    public void setLastBalance(BigDecimal lastBalance) {
        this.lastBalance = lastBalance;
    }

    public String getRsName() {
        return rsName;
    }

    public void setRsName(String rsName) {
        this.rsName = rsName == null ? null : rsName.trim();
    }

    public String getReNum() {
        return reNum;
    }

    public void setReNum(String reNum) {
        this.reNum = reNum == null ? null : reNum.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell == null ? null : spell.trim();
    }

    public String getFirstSpell() {
        return firstSpell;
    }

    public void setFirstSpell(String firstSpell) {
        this.firstSpell = firstSpell == null ? null : firstSpell.trim();
    }

    public BigDecimal getOperateamount() {
        return operateamount;
    }

    public void setOperateamount(BigDecimal operateamount) {
        this.operateamount = operateamount;
    }
}