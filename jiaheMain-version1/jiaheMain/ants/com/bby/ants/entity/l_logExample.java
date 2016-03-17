package com.bby.ants.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class l_logExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public l_logExample() {
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

        public Criteria andLogIdIsNull() {
            addCriterion("LOG_ID is null");
            return (Criteria) this;
        }

        public Criteria andLogIdIsNotNull() {
            addCriterion("LOG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLogIdEqualTo(Long value) {
            addCriterion("LOG_ID =", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotEqualTo(Long value) {
            addCriterion("LOG_ID <>", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThan(Long value) {
            addCriterion("LOG_ID >", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThanOrEqualTo(Long value) {
            addCriterion("LOG_ID >=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThan(Long value) {
            addCriterion("LOG_ID <", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThanOrEqualTo(Long value) {
            addCriterion("LOG_ID <=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdIn(List<Long> values) {
            addCriterion("LOG_ID in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotIn(List<Long> values) {
            addCriterion("LOG_ID not in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdBetween(Long value1, Long value2) {
            addCriterion("LOG_ID between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotBetween(Long value1, Long value2) {
            addCriterion("LOG_ID not between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andOperateDateIsNull() {
            addCriterion("OPERATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andOperateDateIsNotNull() {
            addCriterion("OPERATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andOperateDateEqualTo(Date value) {
            addCriterion("OPERATE_DATE =", value, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateDateNotEqualTo(Date value) {
            addCriterion("OPERATE_DATE <>", value, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateDateGreaterThan(Date value) {
            addCriterion("OPERATE_DATE >", value, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("OPERATE_DATE >=", value, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateDateLessThan(Date value) {
            addCriterion("OPERATE_DATE <", value, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateDateLessThanOrEqualTo(Date value) {
            addCriterion("OPERATE_DATE <=", value, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateDateIn(List<Date> values) {
            addCriterion("OPERATE_DATE in", values, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateDateNotIn(List<Date> values) {
            addCriterion("OPERATE_DATE not in", values, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateDateBetween(Date value1, Date value2) {
            addCriterion("OPERATE_DATE between", value1, value2, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateDateNotBetween(Date value1, Date value2) {
            addCriterion("OPERATE_DATE not between", value1, value2, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateIsNull() {
            addCriterion("OPERATE is null");
            return (Criteria) this;
        }

        public Criteria andOperateIsNotNull() {
            addCriterion("OPERATE is not null");
            return (Criteria) this;
        }

        public Criteria andOperateEqualTo(String value) {
            addCriterion("OPERATE =", value, "operate");
            return (Criteria) this;
        }

        public Criteria andOperateNotEqualTo(String value) {
            addCriterion("OPERATE <>", value, "operate");
            return (Criteria) this;
        }

        public Criteria andOperateGreaterThan(String value) {
            addCriterion("OPERATE >", value, "operate");
            return (Criteria) this;
        }

        public Criteria andOperateGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATE >=", value, "operate");
            return (Criteria) this;
        }

        public Criteria andOperateLessThan(String value) {
            addCriterion("OPERATE <", value, "operate");
            return (Criteria) this;
        }

        public Criteria andOperateLessThanOrEqualTo(String value) {
            addCriterion("OPERATE <=", value, "operate");
            return (Criteria) this;
        }

        public Criteria andOperateLike(String value) {
            addCriterion("OPERATE like", value, "operate");
            return (Criteria) this;
        }

        public Criteria andOperateNotLike(String value) {
            addCriterion("OPERATE not like", value, "operate");
            return (Criteria) this;
        }

        public Criteria andOperateIn(List<String> values) {
            addCriterion("OPERATE in", values, "operate");
            return (Criteria) this;
        }

        public Criteria andOperateNotIn(List<String> values) {
            addCriterion("OPERATE not in", values, "operate");
            return (Criteria) this;
        }

        public Criteria andOperateBetween(String value1, String value2) {
            addCriterion("OPERATE between", value1, value2, "operate");
            return (Criteria) this;
        }

        public Criteria andOperateNotBetween(String value1, String value2) {
            addCriterion("OPERATE not between", value1, value2, "operate");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andJobnumIsNull() {
            addCriterion("jobNum is null");
            return (Criteria) this;
        }

        public Criteria andJobnumIsNotNull() {
            addCriterion("jobNum is not null");
            return (Criteria) this;
        }

        public Criteria andJobnumEqualTo(String value) {
            addCriterion("jobNum =", value, "jobnum");
            return (Criteria) this;
        }

        public Criteria andJobnumNotEqualTo(String value) {
            addCriterion("jobNum <>", value, "jobnum");
            return (Criteria) this;
        }

        public Criteria andJobnumGreaterThan(String value) {
            addCriterion("jobNum >", value, "jobnum");
            return (Criteria) this;
        }

        public Criteria andJobnumGreaterThanOrEqualTo(String value) {
            addCriterion("jobNum >=", value, "jobnum");
            return (Criteria) this;
        }

        public Criteria andJobnumLessThan(String value) {
            addCriterion("jobNum <", value, "jobnum");
            return (Criteria) this;
        }

        public Criteria andJobnumLessThanOrEqualTo(String value) {
            addCriterion("jobNum <=", value, "jobnum");
            return (Criteria) this;
        }

        public Criteria andJobnumLike(String value) {
            addCriterion("jobNum like", value, "jobnum");
            return (Criteria) this;
        }

        public Criteria andJobnumNotLike(String value) {
            addCriterion("jobNum not like", value, "jobnum");
            return (Criteria) this;
        }

        public Criteria andJobnumIn(List<String> values) {
            addCriterion("jobNum in", values, "jobnum");
            return (Criteria) this;
        }

        public Criteria andJobnumNotIn(List<String> values) {
            addCriterion("jobNum not in", values, "jobnum");
            return (Criteria) this;
        }

        public Criteria andJobnumBetween(String value1, String value2) {
            addCriterion("jobNum between", value1, value2, "jobnum");
            return (Criteria) this;
        }

        public Criteria andJobnumNotBetween(String value1, String value2) {
            addCriterion("jobNum not between", value1, value2, "jobnum");
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