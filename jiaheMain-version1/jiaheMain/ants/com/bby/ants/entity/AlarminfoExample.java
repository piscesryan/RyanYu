package com.bby.ants.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AlarminfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AlarminfoExample() {
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
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMonitorpointsnameIsNull() {
            addCriterion("monitorPointsName is null");
            return (Criteria) this;
        }

        public Criteria andMonitorpointsnameIsNotNull() {
            addCriterion("monitorPointsName is not null");
            return (Criteria) this;
        }

        public Criteria andMonitorpointsnameEqualTo(String value) {
            addCriterion("monitorPointsName =", value, "monitorpointsname");
            return (Criteria) this;
        }

        public Criteria andMonitorpointsnameNotEqualTo(String value) {
            addCriterion("monitorPointsName <>", value, "monitorpointsname");
            return (Criteria) this;
        }

        public Criteria andMonitorpointsnameGreaterThan(String value) {
            addCriterion("monitorPointsName >", value, "monitorpointsname");
            return (Criteria) this;
        }

        public Criteria andMonitorpointsnameGreaterThanOrEqualTo(String value) {
            addCriterion("monitorPointsName >=", value, "monitorpointsname");
            return (Criteria) this;
        }

        public Criteria andMonitorpointsnameLessThan(String value) {
            addCriterion("monitorPointsName <", value, "monitorpointsname");
            return (Criteria) this;
        }

        public Criteria andMonitorpointsnameLessThanOrEqualTo(String value) {
            addCriterion("monitorPointsName <=", value, "monitorpointsname");
            return (Criteria) this;
        }

        public Criteria andMonitorpointsnameLike(String value) {
            addCriterion("monitorPointsName like", value, "monitorpointsname");
            return (Criteria) this;
        }

        public Criteria andMonitorpointsnameNotLike(String value) {
            addCriterion("monitorPointsName not like", value, "monitorpointsname");
            return (Criteria) this;
        }

        public Criteria andMonitorpointsnameIn(List<String> values) {
            addCriterion("monitorPointsName in", values, "monitorpointsname");
            return (Criteria) this;
        }

        public Criteria andMonitorpointsnameNotIn(List<String> values) {
            addCriterion("monitorPointsName not in", values, "monitorpointsname");
            return (Criteria) this;
        }

        public Criteria andMonitorpointsnameBetween(String value1, String value2) {
            addCriterion("monitorPointsName between", value1, value2, "monitorpointsname");
            return (Criteria) this;
        }

        public Criteria andMonitorpointsnameNotBetween(String value1, String value2) {
            addCriterion("monitorPointsName not between", value1, value2, "monitorpointsname");
            return (Criteria) this;
        }

        public Criteria andSendercompIsNull() {
            addCriterion("senderComp is null");
            return (Criteria) this;
        }

        public Criteria andSendercompIsNotNull() {
            addCriterion("senderComp is not null");
            return (Criteria) this;
        }

        public Criteria andSendercompEqualTo(String value) {
            addCriterion("senderComp =", value, "sendercomp");
            return (Criteria) this;
        }

        public Criteria andSendercompNotEqualTo(String value) {
            addCriterion("senderComp <>", value, "sendercomp");
            return (Criteria) this;
        }

        public Criteria andSendercompGreaterThan(String value) {
            addCriterion("senderComp >", value, "sendercomp");
            return (Criteria) this;
        }

        public Criteria andSendercompGreaterThanOrEqualTo(String value) {
            addCriterion("senderComp >=", value, "sendercomp");
            return (Criteria) this;
        }

        public Criteria andSendercompLessThan(String value) {
            addCriterion("senderComp <", value, "sendercomp");
            return (Criteria) this;
        }

        public Criteria andSendercompLessThanOrEqualTo(String value) {
            addCriterion("senderComp <=", value, "sendercomp");
            return (Criteria) this;
        }

        public Criteria andSendercompLike(String value) {
            addCriterion("senderComp like", value, "sendercomp");
            return (Criteria) this;
        }

        public Criteria andSendercompNotLike(String value) {
            addCriterion("senderComp not like", value, "sendercomp");
            return (Criteria) this;
        }

        public Criteria andSendercompIn(List<String> values) {
            addCriterion("senderComp in", values, "sendercomp");
            return (Criteria) this;
        }

        public Criteria andSendercompNotIn(List<String> values) {
            addCriterion("senderComp not in", values, "sendercomp");
            return (Criteria) this;
        }

        public Criteria andSendercompBetween(String value1, String value2) {
            addCriterion("senderComp between", value1, value2, "sendercomp");
            return (Criteria) this;
        }

        public Criteria andSendercompNotBetween(String value1, String value2) {
            addCriterion("senderComp not between", value1, value2, "sendercomp");
            return (Criteria) this;
        }

        public Criteria andTemperatureIsNull() {
            addCriterion("temperature is null");
            return (Criteria) this;
        }

        public Criteria andTemperatureIsNotNull() {
            addCriterion("temperature is not null");
            return (Criteria) this;
        }

        public Criteria andTemperatureEqualTo(Integer value) {
            addCriterion("temperature =", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotEqualTo(Integer value) {
            addCriterion("temperature <>", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureGreaterThan(Integer value) {
            addCriterion("temperature >", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureGreaterThanOrEqualTo(Integer value) {
            addCriterion("temperature >=", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLessThan(Integer value) {
            addCriterion("temperature <", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLessThanOrEqualTo(Integer value) {
            addCriterion("temperature <=", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureIn(List<Integer> values) {
            addCriterion("temperature in", values, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotIn(List<Integer> values) {
            addCriterion("temperature not in", values, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureBetween(Integer value1, Integer value2) {
            addCriterion("temperature between", value1, value2, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotBetween(Integer value1, Integer value2) {
            addCriterion("temperature not between", value1, value2, "temperature");
            return (Criteria) this;
        }

        public Criteria andAlarmtimeIsNull() {
            addCriterion("alarmTime is null");
            return (Criteria) this;
        }

        public Criteria andAlarmtimeIsNotNull() {
            addCriterion("alarmTime is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmtimeEqualTo(Date value) {
            addCriterion("alarmTime =", value, "alarmtime");
            return (Criteria) this;
        }

        public Criteria andAlarmtimeNotEqualTo(Date value) {
            addCriterion("alarmTime <>", value, "alarmtime");
            return (Criteria) this;
        }

        public Criteria andAlarmtimeGreaterThan(Date value) {
            addCriterion("alarmTime >", value, "alarmtime");
            return (Criteria) this;
        }

        public Criteria andAlarmtimeGreaterThanOrEqualTo(String searchDateStart) {
            addCriterion("alarmTime >=", searchDateStart, "alarmtime");
            return (Criteria) this;
        }

        public Criteria andAlarmtimeLessThan(Date value) {
            addCriterion("alarmTime <", value, "alarmtime");
            return (Criteria) this;
        }

        public Criteria andAlarmtimeLessThanOrEqualTo(String searchDateEnd) {
            addCriterion("alarmTime <=", searchDateEnd, "alarmtime");
            return (Criteria) this;
        }

        public Criteria andAlarmtimeIn(List<Date> values) {
            addCriterion("alarmTime in", values, "alarmtime");
            return (Criteria) this;
        }

        public Criteria andAlarmtimeNotIn(List<Date> values) {
            addCriterion("alarmTime not in", values, "alarmtime");
            return (Criteria) this;
        }

        public Criteria andAlarmtimeBetween(String searchDateStart, String searchDateEnd) {
            addCriterion("alarmTime between", searchDateStart, searchDateEnd, "alarmtime");
            return (Criteria) this;
        }

        public Criteria andAlarmtimeNotBetween(Date value1, Date value2) {
            addCriterion("alarmTime not between", value1, value2, "alarmtime");
            return (Criteria) this;
        }

        public Criteria andAlarmtypeIsNull() {
            addCriterion("alarmtype is null");
            return (Criteria) this;
        }

        public Criteria andAlarmtypeIsNotNull() {
            addCriterion("alarmtype is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmtypeEqualTo(String value) {
            addCriterion("alarmtype =", value, "alarmtype");
            return (Criteria) this;
        }

        public Criteria andAlarmtypeNotEqualTo(String value) {
            addCriterion("alarmtype <>", value, "alarmtype");
            return (Criteria) this;
        }

        public Criteria andAlarmtypeGreaterThan(String value) {
            addCriterion("alarmtype >", value, "alarmtype");
            return (Criteria) this;
        }

        public Criteria andAlarmtypeGreaterThanOrEqualTo(String value) {
            addCriterion("alarmtype >=", value, "alarmtype");
            return (Criteria) this;
        }

        public Criteria andAlarmtypeLessThan(String value) {
            addCriterion("alarmtype <", value, "alarmtype");
            return (Criteria) this;
        }

        public Criteria andAlarmtypeLessThanOrEqualTo(String value) {
            addCriterion("alarmtype <=", value, "alarmtype");
            return (Criteria) this;
        }

        public Criteria andAlarmtypeLike(String value) {
            addCriterion("alarmtype like", value, "alarmtype");
            return (Criteria) this;
        }

        public Criteria andAlarmtypeNotLike(String value) {
            addCriterion("alarmtype not like", value, "alarmtype");
            return (Criteria) this;
        }

        public Criteria andAlarmtypeIn(List<String> values) {
            addCriterion("alarmtype in", values, "alarmtype");
            return (Criteria) this;
        }

        public Criteria andAlarmtypeNotIn(List<String> values) {
            addCriterion("alarmtype not in", values, "alarmtype");
            return (Criteria) this;
        }

        public Criteria andAlarmtypeBetween(String value1, String value2) {
            addCriterion("alarmtype between", value1, value2, "alarmtype");
            return (Criteria) this;
        }

        public Criteria andAlarmtypeNotBetween(String value1, String value2) {
            addCriterion("alarmtype not between", value1, value2, "alarmtype");
            return (Criteria) this;
        }

        public Criteria andThresholdIsNull() {
            addCriterion("threshold is null");
            return (Criteria) this;
        }

        public Criteria andThresholdIsNotNull() {
            addCriterion("threshold is not null");
            return (Criteria) this;
        }

        public Criteria andThresholdEqualTo(Integer value) {
            addCriterion("threshold =", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdNotEqualTo(Integer value) {
            addCriterion("threshold <>", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdGreaterThan(Integer value) {
            addCriterion("threshold >", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdGreaterThanOrEqualTo(Integer value) {
            addCriterion("threshold >=", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdLessThan(Integer value) {
            addCriterion("threshold <", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdLessThanOrEqualTo(Integer value) {
            addCriterion("threshold <=", value, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdIn(List<Integer> values) {
            addCriterion("threshold in", values, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdNotIn(List<Integer> values) {
            addCriterion("threshold not in", values, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdBetween(Integer value1, Integer value2) {
            addCriterion("threshold between", value1, value2, "threshold");
            return (Criteria) this;
        }

        public Criteria andThresholdNotBetween(Integer value1, Integer value2) {
            addCriterion("threshold not between", value1, value2, "threshold");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("result like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("result not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("result not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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