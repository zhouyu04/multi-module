package com.zzyy.rs.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AccountExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNull() {
            addCriterion("balance is null");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNotNull() {
            addCriterion("balance is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceEqualTo(BigDecimal value) {
            addCriterion("balance =", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotEqualTo(BigDecimal value) {
            addCriterion("balance <>", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThan(BigDecimal value) {
            addCriterion("balance >", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("balance >=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThan(BigDecimal value) {
            addCriterion("balance <", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("balance <=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceIn(List<BigDecimal> values) {
            addCriterion("balance in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotIn(List<BigDecimal> values) {
            addCriterion("balance not in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance not between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andAccumulatIncreaseIsNull() {
            addCriterion("accumulat_increase is null");
            return (Criteria) this;
        }

        public Criteria andAccumulatIncreaseIsNotNull() {
            addCriterion("accumulat_increase is not null");
            return (Criteria) this;
        }

        public Criteria andAccumulatIncreaseEqualTo(BigDecimal value) {
            addCriterion("accumulat_increase =", value, "accumulatIncrease");
            return (Criteria) this;
        }

        public Criteria andAccumulatIncreaseNotEqualTo(BigDecimal value) {
            addCriterion("accumulat_increase <>", value, "accumulatIncrease");
            return (Criteria) this;
        }

        public Criteria andAccumulatIncreaseGreaterThan(BigDecimal value) {
            addCriterion("accumulat_increase >", value, "accumulatIncrease");
            return (Criteria) this;
        }

        public Criteria andAccumulatIncreaseGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("accumulat_increase >=", value, "accumulatIncrease");
            return (Criteria) this;
        }

        public Criteria andAccumulatIncreaseLessThan(BigDecimal value) {
            addCriterion("accumulat_increase <", value, "accumulatIncrease");
            return (Criteria) this;
        }

        public Criteria andAccumulatIncreaseLessThanOrEqualTo(BigDecimal value) {
            addCriterion("accumulat_increase <=", value, "accumulatIncrease");
            return (Criteria) this;
        }

        public Criteria andAccumulatIncreaseIn(List<BigDecimal> values) {
            addCriterion("accumulat_increase in", values, "accumulatIncrease");
            return (Criteria) this;
        }

        public Criteria andAccumulatIncreaseNotIn(List<BigDecimal> values) {
            addCriterion("accumulat_increase not in", values, "accumulatIncrease");
            return (Criteria) this;
        }

        public Criteria andAccumulatIncreaseBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("accumulat_increase between", value1, value2, "accumulatIncrease");
            return (Criteria) this;
        }

        public Criteria andAccumulatIncreaseNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("accumulat_increase not between", value1, value2, "accumulatIncrease");
            return (Criteria) this;
        }

        public Criteria andAccumulatDecreaseIsNull() {
            addCriterion("accumulat_decrease is null");
            return (Criteria) this;
        }

        public Criteria andAccumulatDecreaseIsNotNull() {
            addCriterion("accumulat_decrease is not null");
            return (Criteria) this;
        }

        public Criteria andAccumulatDecreaseEqualTo(BigDecimal value) {
            addCriterion("accumulat_decrease =", value, "accumulatDecrease");
            return (Criteria) this;
        }

        public Criteria andAccumulatDecreaseNotEqualTo(BigDecimal value) {
            addCriterion("accumulat_decrease <>", value, "accumulatDecrease");
            return (Criteria) this;
        }

        public Criteria andAccumulatDecreaseGreaterThan(BigDecimal value) {
            addCriterion("accumulat_decrease >", value, "accumulatDecrease");
            return (Criteria) this;
        }

        public Criteria andAccumulatDecreaseGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("accumulat_decrease >=", value, "accumulatDecrease");
            return (Criteria) this;
        }

        public Criteria andAccumulatDecreaseLessThan(BigDecimal value) {
            addCriterion("accumulat_decrease <", value, "accumulatDecrease");
            return (Criteria) this;
        }

        public Criteria andAccumulatDecreaseLessThanOrEqualTo(BigDecimal value) {
            addCriterion("accumulat_decrease <=", value, "accumulatDecrease");
            return (Criteria) this;
        }

        public Criteria andAccumulatDecreaseIn(List<BigDecimal> values) {
            addCriterion("accumulat_decrease in", values, "accumulatDecrease");
            return (Criteria) this;
        }

        public Criteria andAccumulatDecreaseNotIn(List<BigDecimal> values) {
            addCriterion("accumulat_decrease not in", values, "accumulatDecrease");
            return (Criteria) this;
        }

        public Criteria andAccumulatDecreaseBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("accumulat_decrease between", value1, value2, "accumulatDecrease");
            return (Criteria) this;
        }

        public Criteria andAccumulatDecreaseNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("accumulat_decrease not between", value1, value2, "accumulatDecrease");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNull() {
            addCriterion("modify_date is null");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNotNull() {
            addCriterion("modify_date is not null");
            return (Criteria) this;
        }

        public Criteria andModifyDateEqualTo(Date value) {
            addCriterion("modify_date =", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotEqualTo(Date value) {
            addCriterion("modify_date <>", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThan(Date value) {
            addCriterion("modify_date >", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_date >=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThan(Date value) {
            addCriterion("modify_date <", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThanOrEqualTo(Date value) {
            addCriterion("modify_date <=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateIn(List<Date> values) {
            addCriterion("modify_date in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotIn(List<Date> values) {
            addCriterion("modify_date not in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateBetween(Date value1, Date value2) {
            addCriterion("modify_date between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotBetween(Date value1, Date value2) {
            addCriterion("modify_date not between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andOperaterIsNull() {
            addCriterion("operater is null");
            return (Criteria) this;
        }

        public Criteria andOperaterIsNotNull() {
            addCriterion("operater is not null");
            return (Criteria) this;
        }

        public Criteria andOperaterEqualTo(String value) {
            addCriterion("operater =", value, "operater");
            return (Criteria) this;
        }

        public Criteria andOperaterNotEqualTo(String value) {
            addCriterion("operater <>", value, "operater");
            return (Criteria) this;
        }

        public Criteria andOperaterGreaterThan(String value) {
            addCriterion("operater >", value, "operater");
            return (Criteria) this;
        }

        public Criteria andOperaterGreaterThanOrEqualTo(String value) {
            addCriterion("operater >=", value, "operater");
            return (Criteria) this;
        }

        public Criteria andOperaterLessThan(String value) {
            addCriterion("operater <", value, "operater");
            return (Criteria) this;
        }

        public Criteria andOperaterLessThanOrEqualTo(String value) {
            addCriterion("operater <=", value, "operater");
            return (Criteria) this;
        }

        public Criteria andOperaterLike(String value) {
            addCriterion("operater like", value, "operater");
            return (Criteria) this;
        }

        public Criteria andOperaterNotLike(String value) {
            addCriterion("operater not like", value, "operater");
            return (Criteria) this;
        }

        public Criteria andOperaterIn(List<String> values) {
            addCriterion("operater in", values, "operater");
            return (Criteria) this;
        }

        public Criteria andOperaterNotIn(List<String> values) {
            addCriterion("operater not in", values, "operater");
            return (Criteria) this;
        }

        public Criteria andOperaterBetween(String value1, String value2) {
            addCriterion("operater between", value1, value2, "operater");
            return (Criteria) this;
        }

        public Criteria andOperaterNotBetween(String value1, String value2) {
            addCriterion("operater not between", value1, value2, "operater");
            return (Criteria) this;
        }

        public Criteria andLastBalanceIsNull() {
            addCriterion("last_balance is null");
            return (Criteria) this;
        }

        public Criteria andLastBalanceIsNotNull() {
            addCriterion("last_balance is not null");
            return (Criteria) this;
        }

        public Criteria andLastBalanceEqualTo(BigDecimal value) {
            addCriterion("last_balance =", value, "lastBalance");
            return (Criteria) this;
        }

        public Criteria andLastBalanceNotEqualTo(BigDecimal value) {
            addCriterion("last_balance <>", value, "lastBalance");
            return (Criteria) this;
        }

        public Criteria andLastBalanceGreaterThan(BigDecimal value) {
            addCriterion("last_balance >", value, "lastBalance");
            return (Criteria) this;
        }

        public Criteria andLastBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("last_balance >=", value, "lastBalance");
            return (Criteria) this;
        }

        public Criteria andLastBalanceLessThan(BigDecimal value) {
            addCriterion("last_balance <", value, "lastBalance");
            return (Criteria) this;
        }

        public Criteria andLastBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("last_balance <=", value, "lastBalance");
            return (Criteria) this;
        }

        public Criteria andLastBalanceIn(List<BigDecimal> values) {
            addCriterion("last_balance in", values, "lastBalance");
            return (Criteria) this;
        }

        public Criteria andLastBalanceNotIn(List<BigDecimal> values) {
            addCriterion("last_balance not in", values, "lastBalance");
            return (Criteria) this;
        }

        public Criteria andLastBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("last_balance between", value1, value2, "lastBalance");
            return (Criteria) this;
        }

        public Criteria andLastBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("last_balance not between", value1, value2, "lastBalance");
            return (Criteria) this;
        }

        public Criteria andRsNameIsNull() {
            addCriterion("rs_name is null");
            return (Criteria) this;
        }

        public Criteria andRsNameIsNotNull() {
            addCriterion("rs_name is not null");
            return (Criteria) this;
        }

        public Criteria andRsNameEqualTo(String value) {
            addCriterion("rs_name =", value, "rsName");
            return (Criteria) this;
        }

        public Criteria andRsNameNotEqualTo(String value) {
            addCriterion("rs_name <>", value, "rsName");
            return (Criteria) this;
        }

        public Criteria andRsNameGreaterThan(String value) {
            addCriterion("rs_name >", value, "rsName");
            return (Criteria) this;
        }

        public Criteria andRsNameGreaterThanOrEqualTo(String value) {
            addCriterion("rs_name >=", value, "rsName");
            return (Criteria) this;
        }

        public Criteria andRsNameLessThan(String value) {
            addCriterion("rs_name <", value, "rsName");
            return (Criteria) this;
        }

        public Criteria andRsNameLessThanOrEqualTo(String value) {
            addCriterion("rs_name <=", value, "rsName");
            return (Criteria) this;
        }

        public Criteria andRsNameLike(String value) {
            addCriterion("rs_name like", value, "rsName");
            return (Criteria) this;
        }

        public Criteria andRsNameNotLike(String value) {
            addCriterion("rs_name not like", value, "rsName");
            return (Criteria) this;
        }

        public Criteria andRsNameIn(List<String> values) {
            addCriterion("rs_name in", values, "rsName");
            return (Criteria) this;
        }

        public Criteria andRsNameNotIn(List<String> values) {
            addCriterion("rs_name not in", values, "rsName");
            return (Criteria) this;
        }

        public Criteria andRsNameBetween(String value1, String value2) {
            addCriterion("rs_name between", value1, value2, "rsName");
            return (Criteria) this;
        }

        public Criteria andRsNameNotBetween(String value1, String value2) {
            addCriterion("rs_name not between", value1, value2, "rsName");
            return (Criteria) this;
        }

        public Criteria andReNumIsNull() {
            addCriterion("re_num is null");
            return (Criteria) this;
        }

        public Criteria andReNumIsNotNull() {
            addCriterion("re_num is not null");
            return (Criteria) this;
        }

        public Criteria andReNumEqualTo(String value) {
            addCriterion("re_num =", value, "reNum");
            return (Criteria) this;
        }

        public Criteria andReNumNotEqualTo(String value) {
            addCriterion("re_num <>", value, "reNum");
            return (Criteria) this;
        }

        public Criteria andReNumGreaterThan(String value) {
            addCriterion("re_num >", value, "reNum");
            return (Criteria) this;
        }

        public Criteria andReNumGreaterThanOrEqualTo(String value) {
            addCriterion("re_num >=", value, "reNum");
            return (Criteria) this;
        }

        public Criteria andReNumLessThan(String value) {
            addCriterion("re_num <", value, "reNum");
            return (Criteria) this;
        }

        public Criteria andReNumLessThanOrEqualTo(String value) {
            addCriterion("re_num <=", value, "reNum");
            return (Criteria) this;
        }

        public Criteria andReNumLike(String value) {
            addCriterion("re_num like", value, "reNum");
            return (Criteria) this;
        }

        public Criteria andReNumNotLike(String value) {
            addCriterion("re_num not like", value, "reNum");
            return (Criteria) this;
        }

        public Criteria andReNumIn(List<String> values) {
            addCriterion("re_num in", values, "reNum");
            return (Criteria) this;
        }

        public Criteria andReNumNotIn(List<String> values) {
            addCriterion("re_num not in", values, "reNum");
            return (Criteria) this;
        }

        public Criteria andReNumBetween(String value1, String value2) {
            addCriterion("re_num between", value1, value2, "reNum");
            return (Criteria) this;
        }

        public Criteria andReNumNotBetween(String value1, String value2) {
            addCriterion("re_num not between", value1, value2, "reNum");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andSpellIsNull() {
            addCriterion("spell is null");
            return (Criteria) this;
        }

        public Criteria andSpellIsNotNull() {
            addCriterion("spell is not null");
            return (Criteria) this;
        }

        public Criteria andSpellEqualTo(String value) {
            addCriterion("spell =", value, "spell");
            return (Criteria) this;
        }

        public Criteria andSpellNotEqualTo(String value) {
            addCriterion("spell <>", value, "spell");
            return (Criteria) this;
        }

        public Criteria andSpellGreaterThan(String value) {
            addCriterion("spell >", value, "spell");
            return (Criteria) this;
        }

        public Criteria andSpellGreaterThanOrEqualTo(String value) {
            addCriterion("spell >=", value, "spell");
            return (Criteria) this;
        }

        public Criteria andSpellLessThan(String value) {
            addCriterion("spell <", value, "spell");
            return (Criteria) this;
        }

        public Criteria andSpellLessThanOrEqualTo(String value) {
            addCriterion("spell <=", value, "spell");
            return (Criteria) this;
        }

        public Criteria andSpellLike(String value) {
            addCriterion("spell like", value, "spell");
            return (Criteria) this;
        }

        public Criteria andSpellNotLike(String value) {
            addCriterion("spell not like", value, "spell");
            return (Criteria) this;
        }

        public Criteria andSpellIn(List<String> values) {
            addCriterion("spell in", values, "spell");
            return (Criteria) this;
        }

        public Criteria andSpellNotIn(List<String> values) {
            addCriterion("spell not in", values, "spell");
            return (Criteria) this;
        }

        public Criteria andSpellBetween(String value1, String value2) {
            addCriterion("spell between", value1, value2, "spell");
            return (Criteria) this;
        }

        public Criteria andSpellNotBetween(String value1, String value2) {
            addCriterion("spell not between", value1, value2, "spell");
            return (Criteria) this;
        }

        public Criteria andFirstSpellIsNull() {
            addCriterion("first_spell is null");
            return (Criteria) this;
        }

        public Criteria andFirstSpellIsNotNull() {
            addCriterion("first_spell is not null");
            return (Criteria) this;
        }

        public Criteria andFirstSpellEqualTo(String value) {
            addCriterion("first_spell =", value, "firstSpell");
            return (Criteria) this;
        }

        public Criteria andFirstSpellNotEqualTo(String value) {
            addCriterion("first_spell <>", value, "firstSpell");
            return (Criteria) this;
        }

        public Criteria andFirstSpellGreaterThan(String value) {
            addCriterion("first_spell >", value, "firstSpell");
            return (Criteria) this;
        }

        public Criteria andFirstSpellGreaterThanOrEqualTo(String value) {
            addCriterion("first_spell >=", value, "firstSpell");
            return (Criteria) this;
        }

        public Criteria andFirstSpellLessThan(String value) {
            addCriterion("first_spell <", value, "firstSpell");
            return (Criteria) this;
        }

        public Criteria andFirstSpellLessThanOrEqualTo(String value) {
            addCriterion("first_spell <=", value, "firstSpell");
            return (Criteria) this;
        }

        public Criteria andFirstSpellLike(String value) {
            addCriterion("first_spell like", value, "firstSpell");
            return (Criteria) this;
        }

        public Criteria andFirstSpellNotLike(String value) {
            addCriterion("first_spell not like", value, "firstSpell");
            return (Criteria) this;
        }

        public Criteria andFirstSpellIn(List<String> values) {
            addCriterion("first_spell in", values, "firstSpell");
            return (Criteria) this;
        }

        public Criteria andFirstSpellNotIn(List<String> values) {
            addCriterion("first_spell not in", values, "firstSpell");
            return (Criteria) this;
        }

        public Criteria andFirstSpellBetween(String value1, String value2) {
            addCriterion("first_spell between", value1, value2, "firstSpell");
            return (Criteria) this;
        }

        public Criteria andFirstSpellNotBetween(String value1, String value2) {
            addCriterion("first_spell not between", value1, value2, "firstSpell");
            return (Criteria) this;
        }

        public Criteria andOperateamountIsNull() {
            addCriterion("operateAmount is null");
            return (Criteria) this;
        }

        public Criteria andOperateamountIsNotNull() {
            addCriterion("operateAmount is not null");
            return (Criteria) this;
        }

        public Criteria andOperateamountEqualTo(BigDecimal value) {
            addCriterion("operateAmount =", value, "operateamount");
            return (Criteria) this;
        }

        public Criteria andOperateamountNotEqualTo(BigDecimal value) {
            addCriterion("operateAmount <>", value, "operateamount");
            return (Criteria) this;
        }

        public Criteria andOperateamountGreaterThan(BigDecimal value) {
            addCriterion("operateAmount >", value, "operateamount");
            return (Criteria) this;
        }

        public Criteria andOperateamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("operateAmount >=", value, "operateamount");
            return (Criteria) this;
        }

        public Criteria andOperateamountLessThan(BigDecimal value) {
            addCriterion("operateAmount <", value, "operateamount");
            return (Criteria) this;
        }

        public Criteria andOperateamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("operateAmount <=", value, "operateamount");
            return (Criteria) this;
        }

        public Criteria andOperateamountIn(List<BigDecimal> values) {
            addCriterion("operateAmount in", values, "operateamount");
            return (Criteria) this;
        }

        public Criteria andOperateamountNotIn(List<BigDecimal> values) {
            addCriterion("operateAmount not in", values, "operateamount");
            return (Criteria) this;
        }

        public Criteria andOperateamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("operateAmount between", value1, value2, "operateamount");
            return (Criteria) this;
        }

        public Criteria andOperateamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("operateAmount not between", value1, value2, "operateamount");
            return (Criteria) this;
        }

        public Criteria andPersonmarkIsNull() {
            addCriterion("personMark is null");
            return (Criteria) this;
        }

        public Criteria andPersonmarkIsNotNull() {
            addCriterion("personMark is not null");
            return (Criteria) this;
        }

        public Criteria andPersonmarkEqualTo(String value) {
            addCriterion("personMark =", value, "personmark");
            return (Criteria) this;
        }

        public Criteria andPersonmarkNotEqualTo(String value) {
            addCriterion("personMark <>", value, "personmark");
            return (Criteria) this;
        }

        public Criteria andPersonmarkGreaterThan(String value) {
            addCriterion("personMark >", value, "personmark");
            return (Criteria) this;
        }

        public Criteria andPersonmarkGreaterThanOrEqualTo(String value) {
            addCriterion("personMark >=", value, "personmark");
            return (Criteria) this;
        }

        public Criteria andPersonmarkLessThan(String value) {
            addCriterion("personMark <", value, "personmark");
            return (Criteria) this;
        }

        public Criteria andPersonmarkLessThanOrEqualTo(String value) {
            addCriterion("personMark <=", value, "personmark");
            return (Criteria) this;
        }

        public Criteria andPersonmarkLike(String value) {
            addCriterion("personMark like", value, "personmark");
            return (Criteria) this;
        }

        public Criteria andPersonmarkNotLike(String value) {
            addCriterion("personMark not like", value, "personmark");
            return (Criteria) this;
        }

        public Criteria andPersonmarkIn(List<String> values) {
            addCriterion("personMark in", values, "personmark");
            return (Criteria) this;
        }

        public Criteria andPersonmarkNotIn(List<String> values) {
            addCriterion("personMark not in", values, "personmark");
            return (Criteria) this;
        }

        public Criteria andPersonmarkBetween(String value1, String value2) {
            addCriterion("personMark between", value1, value2, "personmark");
            return (Criteria) this;
        }

        public Criteria andPersonmarkNotBetween(String value1, String value2) {
            addCriterion("personMark not between", value1, value2, "personmark");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}