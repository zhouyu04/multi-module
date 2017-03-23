package com.zzyy.rs.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionFlowExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TransactionFlowExample() {
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

        public Criteria andRsNumIsNull() {
            addCriterion("rs_num is null");
            return (Criteria) this;
        }

        public Criteria andRsNumIsNotNull() {
            addCriterion("rs_num is not null");
            return (Criteria) this;
        }

        public Criteria andRsNumEqualTo(Integer value) {
            addCriterion("rs_num =", value, "rsNum");
            return (Criteria) this;
        }

        public Criteria andRsNumNotEqualTo(Integer value) {
            addCriterion("rs_num <>", value, "rsNum");
            return (Criteria) this;
        }

        public Criteria andRsNumGreaterThan(Integer value) {
            addCriterion("rs_num >", value, "rsNum");
            return (Criteria) this;
        }

        public Criteria andRsNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("rs_num >=", value, "rsNum");
            return (Criteria) this;
        }

        public Criteria andRsNumLessThan(Integer value) {
            addCriterion("rs_num <", value, "rsNum");
            return (Criteria) this;
        }

        public Criteria andRsNumLessThanOrEqualTo(Integer value) {
            addCriterion("rs_num <=", value, "rsNum");
            return (Criteria) this;
        }

        public Criteria andRsNumIn(List<Integer> values) {
            addCriterion("rs_num in", values, "rsNum");
            return (Criteria) this;
        }

        public Criteria andRsNumNotIn(List<Integer> values) {
            addCriterion("rs_num not in", values, "rsNum");
            return (Criteria) this;
        }

        public Criteria andRsNumBetween(Integer value1, Integer value2) {
            addCriterion("rs_num between", value1, value2, "rsNum");
            return (Criteria) this;
        }

        public Criteria andRsNumNotBetween(Integer value1, Integer value2) {
            addCriterion("rs_num not between", value1, value2, "rsNum");
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

        public Criteria andDateCreateIsNull() {
            addCriterion("date_create is null");
            return (Criteria) this;
        }

        public Criteria andDateCreateIsNotNull() {
            addCriterion("date_create is not null");
            return (Criteria) this;
        }

        public Criteria andDateCreateEqualTo(Date value) {
            addCriterion("date_create =", value, "dateCreate");
            return (Criteria) this;
        }

        public Criteria andDateCreateNotEqualTo(Date value) {
            addCriterion("date_create <>", value, "dateCreate");
            return (Criteria) this;
        }

        public Criteria andDateCreateGreaterThan(Date value) {
            addCriterion("date_create >", value, "dateCreate");
            return (Criteria) this;
        }

        public Criteria andDateCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("date_create >=", value, "dateCreate");
            return (Criteria) this;
        }

        public Criteria andDateCreateLessThan(Date value) {
            addCriterion("date_create <", value, "dateCreate");
            return (Criteria) this;
        }

        public Criteria andDateCreateLessThanOrEqualTo(Date value) {
            addCriterion("date_create <=", value, "dateCreate");
            return (Criteria) this;
        }

        public Criteria andDateCreateIn(List<Date> values) {
            addCriterion("date_create in", values, "dateCreate");
            return (Criteria) this;
        }

        public Criteria andDateCreateNotIn(List<Date> values) {
            addCriterion("date_create not in", values, "dateCreate");
            return (Criteria) this;
        }

        public Criteria andDateCreateBetween(Date value1, Date value2) {
            addCriterion("date_create between", value1, value2, "dateCreate");
            return (Criteria) this;
        }

        public Criteria andDateCreateNotBetween(Date value1, Date value2) {
            addCriterion("date_create not between", value1, value2, "dateCreate");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Boolean value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Boolean value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Boolean value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Boolean value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Boolean> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Boolean> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("status not between", value1, value2, "status");
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