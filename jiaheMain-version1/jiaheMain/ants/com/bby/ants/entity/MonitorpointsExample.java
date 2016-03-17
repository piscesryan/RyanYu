package com.bby.ants.entity;

import java.util.ArrayList;
import java.util.List;

public class MonitorpointsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MonitorpointsExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
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

        public Criteria andEarlyWarningIsNull() {
            addCriterion("early_warning is null");
            return (Criteria) this;
        }

        public Criteria andEarlyWarningIsNotNull() {
            addCriterion("early_warning is not null");
            return (Criteria) this;
        }

        public Criteria andEarlyWarningEqualTo(Float value) {
            addCriterion("early_warning =", value, "earlyWarning");
            return (Criteria) this;
        }

        public Criteria andEarlyWarningNotEqualTo(Float value) {
            addCriterion("early_warning <>", value, "earlyWarning");
            return (Criteria) this;
        }

        public Criteria andEarlyWarningGreaterThan(Float value) {
            addCriterion("early_warning >", value, "earlyWarning");
            return (Criteria) this;
        }

        public Criteria andEarlyWarningGreaterThanOrEqualTo(Float value) {
            addCriterion("early_warning >=", value, "earlyWarning");
            return (Criteria) this;
        }

        public Criteria andEarlyWarningLessThan(Float value) {
            addCriterion("early_warning <", value, "earlyWarning");
            return (Criteria) this;
        }

        public Criteria andEarlyWarningLessThanOrEqualTo(Float value) {
            addCriterion("early_warning <=", value, "earlyWarning");
            return (Criteria) this;
        }

        public Criteria andEarlyWarningIn(List<Float> values) {
            addCriterion("early_warning in", values, "earlyWarning");
            return (Criteria) this;
        }

        public Criteria andEarlyWarningNotIn(List<Float> values) {
            addCriterion("early_warning not in", values, "earlyWarning");
            return (Criteria) this;
        }

        public Criteria andEarlyWarningBetween(Float value1, Float value2) {
            addCriterion("early_warning between", value1, value2, "earlyWarning");
            return (Criteria) this;
        }

        public Criteria andEarlyWarningNotBetween(Float value1, Float value2) {
            addCriterion("early_warning not between", value1, value2, "earlyWarning");
            return (Criteria) this;
        }

        public Criteria andEmergencyIsNull() {
            addCriterion("emergency is null");
            return (Criteria) this;
        }

        public Criteria andEmergencyIsNotNull() {
            addCriterion("emergency is not null");
            return (Criteria) this;
        }

        public Criteria andEmergencyEqualTo(Float value) {
            addCriterion("emergency =", value, "emergency");
            return (Criteria) this;
        }

        public Criteria andEmergencyNotEqualTo(Float value) {
            addCriterion("emergency <>", value, "emergency");
            return (Criteria) this;
        }

        public Criteria andEmergencyGreaterThan(Float value) {
            addCriterion("emergency >", value, "emergency");
            return (Criteria) this;
        }

        public Criteria andEmergencyGreaterThanOrEqualTo(Float value) {
            addCriterion("emergency >=", value, "emergency");
            return (Criteria) this;
        }

        public Criteria andEmergencyLessThan(Float value) {
            addCriterion("emergency <", value, "emergency");
            return (Criteria) this;
        }

        public Criteria andEmergencyLessThanOrEqualTo(Float value) {
            addCriterion("emergency <=", value, "emergency");
            return (Criteria) this;
        }

        public Criteria andEmergencyIn(List<Float> values) {
            addCriterion("emergency in", values, "emergency");
            return (Criteria) this;
        }

        public Criteria andEmergencyNotIn(List<Float> values) {
            addCriterion("emergency not in", values, "emergency");
            return (Criteria) this;
        }

        public Criteria andEmergencyBetween(Float value1, Float value2) {
            addCriterion("emergency between", value1, value2, "emergency");
            return (Criteria) this;
        }

        public Criteria andEmergencyNotBetween(Float value1, Float value2) {
            addCriterion("emergency not between", value1, value2, "emergency");
            return (Criteria) this;
        }

        public Criteria andBeyondBoundsIsNull() {
            addCriterion("beyond_bounds is null");
            return (Criteria) this;
        }

        public Criteria andBeyondBoundsIsNotNull() {
            addCriterion("beyond_bounds is not null");
            return (Criteria) this;
        }

        public Criteria andBeyondBoundsEqualTo(Float value) {
            addCriterion("beyond_bounds =", value, "beyondBounds");
            return (Criteria) this;
        }

        public Criteria andBeyondBoundsNotEqualTo(Float value) {
            addCriterion("beyond_bounds <>", value, "beyondBounds");
            return (Criteria) this;
        }

        public Criteria andBeyondBoundsGreaterThan(Float value) {
            addCriterion("beyond_bounds >", value, "beyondBounds");
            return (Criteria) this;
        }

        public Criteria andBeyondBoundsGreaterThanOrEqualTo(Float value) {
            addCriterion("beyond_bounds >=", value, "beyondBounds");
            return (Criteria) this;
        }

        public Criteria andBeyondBoundsLessThan(Float value) {
            addCriterion("beyond_bounds <", value, "beyondBounds");
            return (Criteria) this;
        }

        public Criteria andBeyondBoundsLessThanOrEqualTo(Float value) {
            addCriterion("beyond_bounds <=", value, "beyondBounds");
            return (Criteria) this;
        }

        public Criteria andBeyondBoundsIn(List<Float> values) {
            addCriterion("beyond_bounds in", values, "beyondBounds");
            return (Criteria) this;
        }

        public Criteria andBeyondBoundsNotIn(List<Float> values) {
            addCriterion("beyond_bounds not in", values, "beyondBounds");
            return (Criteria) this;
        }

        public Criteria andBeyondBoundsBetween(Float value1, Float value2) {
            addCriterion("beyond_bounds between", value1, value2, "beyondBounds");
            return (Criteria) this;
        }

        public Criteria andBeyondBoundsNotBetween(Float value1, Float value2) {
            addCriterion("beyond_bounds not between", value1, value2, "beyondBounds");
            return (Criteria) this;
        }

        public Criteria andCompidIsNull() {
            addCriterion("compId is null");
            return (Criteria) this;
        }

        public Criteria andCompidIsNotNull() {
            addCriterion("compId is not null");
            return (Criteria) this;
        }

        public Criteria andCompidEqualTo(Long value) {
            addCriterion("compId =", value, "compid");
            return (Criteria) this;
        }

        public Criteria andCompidNotEqualTo(Long value) {
            addCriterion("compId <>", value, "compid");
            return (Criteria) this;
        }

        public Criteria andCompidGreaterThan(Long value) {
            addCriterion("compId >", value, "compid");
            return (Criteria) this;
        }

        public Criteria andCompidGreaterThanOrEqualTo(Long value) {
            addCriterion("compId >=", value, "compid");
            return (Criteria) this;
        }

        public Criteria andCompidLessThan(Long value) {
            addCriterion("compId <", value, "compid");
            return (Criteria) this;
        }

        public Criteria andCompidLessThanOrEqualTo(Long value) {
            addCriterion("compId <=", value, "compid");
            return (Criteria) this;
        }

        public Criteria andCompidIn(List<Long> values) {
            addCriterion("compId in", values, "compid");
            return (Criteria) this;
        }

        public Criteria andCompidNotIn(List<Long> values) {
            addCriterion("compId not in", values, "compid");
            return (Criteria) this;
        }

        public Criteria andCompidBetween(Long value1, Long value2) {
            addCriterion("compId between", value1, value2, "compid");
            return (Criteria) this;
        }

        public Criteria andCompidNotBetween(Long value1, Long value2) {
            addCriterion("compId not between", value1, value2, "compid");
            return (Criteria) this;
        }

        public Criteria andGatewayidIsNull() {
            addCriterion("gateWayId is null");
            return (Criteria) this;
        }

        public Criteria andGatewayidIsNotNull() {
            addCriterion("gateWayId is not null");
            return (Criteria) this;
        }

        public Criteria andGatewayidEqualTo(Long value) {
            addCriterion("gateWayId =", value, "gatewayid");
            return (Criteria) this;
        }

        public Criteria andGatewayidNotEqualTo(Long value) {
            addCriterion("gateWayId <>", value, "gatewayid");
            return (Criteria) this;
        }

        public Criteria andGatewayidGreaterThan(Long value) {
            addCriterion("gateWayId >", value, "gatewayid");
            return (Criteria) this;
        }

        public Criteria andGatewayidGreaterThanOrEqualTo(Long value) {
            addCriterion("gateWayId >=", value, "gatewayid");
            return (Criteria) this;
        }

        public Criteria andGatewayidLessThan(Long value) {
            addCriterion("gateWayId <", value, "gatewayid");
            return (Criteria) this;
        }

        public Criteria andGatewayidLessThanOrEqualTo(Long value) {
            addCriterion("gateWayId <=", value, "gatewayid");
            return (Criteria) this;
        }

        public Criteria andGatewayidIn(List<Long> values) {
            addCriterion("gateWayId in", values, "gatewayid");
            return (Criteria) this;
        }

        public Criteria andGatewayidNotIn(List<Long> values) {
            addCriterion("gateWayId not in", values, "gatewayid");
            return (Criteria) this;
        }

        public Criteria andGatewayidBetween(Long value1, Long value2) {
            addCriterion("gateWayId between", value1, value2, "gatewayid");
            return (Criteria) this;
        }

        public Criteria andGatewayidNotBetween(Long value1, Long value2) {
            addCriterion("gateWayId not between", value1, value2, "gatewayid");
            return (Criteria) this;
        }

        public Criteria andSendernameIsNull() {
            addCriterion("senderName is null");
            return (Criteria) this;
        }

        public Criteria andSendernameIsNotNull() {
            addCriterion("senderName is not null");
            return (Criteria) this;
        }

        public Criteria andSendernameEqualTo(String value) {
            addCriterion("senderName =", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameNotEqualTo(String value) {
            addCriterion("senderName <>", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameGreaterThan(String value) {
            addCriterion("senderName >", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameGreaterThanOrEqualTo(String value) {
            addCriterion("senderName >=", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameLessThan(String value) {
            addCriterion("senderName <", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameLessThanOrEqualTo(String value) {
            addCriterion("senderName <=", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameLike(String value) {
            addCriterion("senderName like", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameNotLike(String value) {
            addCriterion("senderName not like", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameIn(List<String> values) {
            addCriterion("senderName in", values, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameNotIn(List<String> values) {
            addCriterion("senderName not in", values, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameBetween(String value1, String value2) {
            addCriterion("senderName between", value1, value2, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameNotBetween(String value1, String value2) {
            addCriterion("senderName not between", value1, value2, "sendername");
            return (Criteria) this;
        }

        public Criteria andChannelIsNull() {
            addCriterion("channel is null");
            return (Criteria) this;
        }

        public Criteria andChannelIsNotNull() {
            addCriterion("channel is not null");
            return (Criteria) this;
        }

        public Criteria andChannelEqualTo(Integer value) {
            addCriterion("channel =", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotEqualTo(Integer value) {
            addCriterion("channel <>", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThan(Integer value) {
            addCriterion("channel >", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThanOrEqualTo(Integer value) {
            addCriterion("channel >=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThan(Integer value) {
            addCriterion("channel <", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThanOrEqualTo(Integer value) {
            addCriterion("channel <=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelIn(List<Integer> values) {
            addCriterion("channel in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotIn(List<Integer> values) {
            addCriterion("channel not in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelBetween(Integer value1, Integer value2) {
            addCriterion("channel between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotBetween(Integer value1, Integer value2) {
            addCriterion("channel not between", value1, value2, "channel");
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