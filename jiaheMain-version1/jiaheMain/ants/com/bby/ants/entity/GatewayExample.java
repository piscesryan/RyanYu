package com.bby.ants.entity;

import java.util.ArrayList;
import java.util.List;

public class GatewayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GatewayExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Id not between", value1, value2, "id");
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

        public Criteria andNetworkidIsNull() {
            addCriterion("networkId is null");
            return (Criteria) this;
        }

        public Criteria andNetworkidIsNotNull() {
            addCriterion("networkId is not null");
            return (Criteria) this;
        }

        public Criteria andNetworkidEqualTo(Integer value) {
            addCriterion("networkId =", value, "networkid");
            return (Criteria) this;
        }

        public Criteria andNetworkidNotEqualTo(Integer value) {
            addCriterion("networkId <>", value, "networkid");
            return (Criteria) this;
        }

        public Criteria andNetworkidGreaterThan(Integer value) {
            addCriterion("networkId >", value, "networkid");
            return (Criteria) this;
        }

        public Criteria andNetworkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("networkId >=", value, "networkid");
            return (Criteria) this;
        }

        public Criteria andNetworkidLessThan(Integer value) {
            addCriterion("networkId <", value, "networkid");
            return (Criteria) this;
        }

        public Criteria andNetworkidLessThanOrEqualTo(Integer value) {
            addCriterion("networkId <=", value, "networkid");
            return (Criteria) this;
        }

        public Criteria andNetworkidIn(List<Integer> values) {
            addCriterion("networkId in", values, "networkid");
            return (Criteria) this;
        }

        public Criteria andNetworkidNotIn(List<Integer> values) {
            addCriterion("networkId not in", values, "networkid");
            return (Criteria) this;
        }

        public Criteria andNetworkidBetween(Integer value1, Integer value2) {
            addCriterion("networkId between", value1, value2, "networkid");
            return (Criteria) this;
        }

        public Criteria andNetworkidNotBetween(Integer value1, Integer value2) {
            addCriterion("networkId not between", value1, value2, "networkid");
            return (Criteria) this;
        }

        public Criteria andHostidIsNull() {
            addCriterion("hostId is null");
            return (Criteria) this;
        }

        public Criteria andHostidIsNotNull() {
            addCriterion("hostId is not null");
            return (Criteria) this;
        }

        public Criteria andHostidEqualTo(Integer value) {
            addCriterion("hostId =", value, "hostid");
            return (Criteria) this;
        }

        public Criteria andHostidNotEqualTo(Integer value) {
            addCriterion("hostId <>", value, "hostid");
            return (Criteria) this;
        }

        public Criteria andHostidGreaterThan(Integer value) {
            addCriterion("hostId >", value, "hostid");
            return (Criteria) this;
        }

        public Criteria andHostidGreaterThanOrEqualTo(Integer value) {
            addCriterion("hostId >=", value, "hostid");
            return (Criteria) this;
        }

        public Criteria andHostidLessThan(Integer value) {
            addCriterion("hostId <", value, "hostid");
            return (Criteria) this;
        }

        public Criteria andHostidLessThanOrEqualTo(Integer value) {
            addCriterion("hostId <=", value, "hostid");
            return (Criteria) this;
        }

        public Criteria andHostidIn(List<Integer> values) {
            addCriterion("hostId in", values, "hostid");
            return (Criteria) this;
        }

        public Criteria andHostidNotIn(List<Integer> values) {
            addCriterion("hostId not in", values, "hostid");
            return (Criteria) this;
        }

        public Criteria andHostidBetween(Integer value1, Integer value2) {
            addCriterion("hostId between", value1, value2, "hostid");
            return (Criteria) this;
        }

        public Criteria andHostidNotBetween(Integer value1, Integer value2) {
            addCriterion("hostId not between", value1, value2, "hostid");
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

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andPortIsNull() {
            addCriterion("port is null");
            return (Criteria) this;
        }

        public Criteria andPortIsNotNull() {
            addCriterion("port is not null");
            return (Criteria) this;
        }

        public Criteria andPortEqualTo(Integer value) {
            addCriterion("port =", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotEqualTo(Integer value) {
            addCriterion("port <>", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThan(Integer value) {
            addCriterion("port >", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThanOrEqualTo(Integer value) {
            addCriterion("port >=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThan(Integer value) {
            addCriterion("port <", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThanOrEqualTo(Integer value) {
            addCriterion("port <=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortIn(List<Integer> values) {
            addCriterion("port in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotIn(List<Integer> values) {
            addCriterion("port not in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortBetween(Integer value1, Integer value2) {
            addCriterion("port between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotBetween(Integer value1, Integer value2) {
            addCriterion("port not between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andBuzzerIsNull() {
            addCriterion("buzzer is null");
            return (Criteria) this;
        }

        public Criteria andBuzzerIsNotNull() {
            addCriterion("buzzer is not null");
            return (Criteria) this;
        }

        public Criteria andBuzzerEqualTo(Integer value) {
            addCriterion("buzzer =", value, "buzzer");
            return (Criteria) this;
        }

        public Criteria andBuzzerNotEqualTo(Integer value) {
            addCriterion("buzzer <>", value, "buzzer");
            return (Criteria) this;
        }

        public Criteria andBuzzerGreaterThan(Integer value) {
            addCriterion("buzzer >", value, "buzzer");
            return (Criteria) this;
        }

        public Criteria andBuzzerGreaterThanOrEqualTo(Integer value) {
            addCriterion("buzzer >=", value, "buzzer");
            return (Criteria) this;
        }

        public Criteria andBuzzerLessThan(Integer value) {
            addCriterion("buzzer <", value, "buzzer");
            return (Criteria) this;
        }

        public Criteria andBuzzerLessThanOrEqualTo(Integer value) {
            addCriterion("buzzer <=", value, "buzzer");
            return (Criteria) this;
        }

        public Criteria andBuzzerIn(List<Integer> values) {
            addCriterion("buzzer in", values, "buzzer");
            return (Criteria) this;
        }

        public Criteria andBuzzerNotIn(List<Integer> values) {
            addCriterion("buzzer not in", values, "buzzer");
            return (Criteria) this;
        }

        public Criteria andBuzzerBetween(Integer value1, Integer value2) {
            addCriterion("buzzer between", value1, value2, "buzzer");
            return (Criteria) this;
        }

        public Criteria andBuzzerNotBetween(Integer value1, Integer value2) {
            addCriterion("buzzer not between", value1, value2, "buzzer");
            return (Criteria) this;
        }

        public Criteria andNodesnumIsNull() {
            addCriterion("nodesNum is null");
            return (Criteria) this;
        }

        public Criteria andNodesnumIsNotNull() {
            addCriterion("nodesNum is not null");
            return (Criteria) this;
        }

        public Criteria andNodesnumEqualTo(Integer value) {
            addCriterion("nodesNum =", value, "nodesnum");
            return (Criteria) this;
        }

        public Criteria andNodesnumNotEqualTo(Integer value) {
            addCriterion("nodesNum <>", value, "nodesnum");
            return (Criteria) this;
        }

        public Criteria andNodesnumGreaterThan(Integer value) {
            addCriterion("nodesNum >", value, "nodesnum");
            return (Criteria) this;
        }

        public Criteria andNodesnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("nodesNum >=", value, "nodesnum");
            return (Criteria) this;
        }

        public Criteria andNodesnumLessThan(Integer value) {
            addCriterion("nodesNum <", value, "nodesnum");
            return (Criteria) this;
        }

        public Criteria andNodesnumLessThanOrEqualTo(Integer value) {
            addCriterion("nodesNum <=", value, "nodesnum");
            return (Criteria) this;
        }

        public Criteria andNodesnumIn(List<Integer> values) {
            addCriterion("nodesNum in", values, "nodesnum");
            return (Criteria) this;
        }

        public Criteria andNodesnumNotIn(List<Integer> values) {
            addCriterion("nodesNum not in", values, "nodesnum");
            return (Criteria) this;
        }

        public Criteria andNodesnumBetween(Integer value1, Integer value2) {
            addCriterion("nodesNum between", value1, value2, "nodesnum");
            return (Criteria) this;
        }

        public Criteria andNodesnumNotBetween(Integer value1, Integer value2) {
            addCriterion("nodesNum not between", value1, value2, "nodesnum");
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