package com.sae.express.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PickUpInfoModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public PickUpInfoModelExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
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

        public Criteria andPickUpIdIsNull() {
            addCriterion("pick_up_id is null");
            return (Criteria) this;
        }

        public Criteria andPickUpIdIsNotNull() {
            addCriterion("pick_up_id is not null");
            return (Criteria) this;
        }

        public Criteria andPickUpIdEqualTo(Integer value) {
            addCriterion("pick_up_id =", value, "pickUpId");
            return (Criteria) this;
        }

        public Criteria andPickUpIdNotEqualTo(Integer value) {
            addCriterion("pick_up_id <>", value, "pickUpId");
            return (Criteria) this;
        }

        public Criteria andPickUpIdGreaterThan(Integer value) {
            addCriterion("pick_up_id >", value, "pickUpId");
            return (Criteria) this;
        }

        public Criteria andPickUpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pick_up_id >=", value, "pickUpId");
            return (Criteria) this;
        }

        public Criteria andPickUpIdLessThan(Integer value) {
            addCriterion("pick_up_id <", value, "pickUpId");
            return (Criteria) this;
        }

        public Criteria andPickUpIdLessThanOrEqualTo(Integer value) {
            addCriterion("pick_up_id <=", value, "pickUpId");
            return (Criteria) this;
        }

        public Criteria andPickUpIdIn(List<Integer> values) {
            addCriterion("pick_up_id in", values, "pickUpId");
            return (Criteria) this;
        }

        public Criteria andPickUpIdNotIn(List<Integer> values) {
            addCriterion("pick_up_id not in", values, "pickUpId");
            return (Criteria) this;
        }

        public Criteria andPickUpIdBetween(Integer value1, Integer value2) {
            addCriterion("pick_up_id between", value1, value2, "pickUpId");
            return (Criteria) this;
        }

        public Criteria andPickUpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pick_up_id not between", value1, value2, "pickUpId");
            return (Criteria) this;
        }

        public Criteria andExpressCodeIsNull() {
            addCriterion("express_code is null");
            return (Criteria) this;
        }

        public Criteria andExpressCodeIsNotNull() {
            addCriterion("express_code is not null");
            return (Criteria) this;
        }

        public Criteria andExpressCodeEqualTo(String value) {
            addCriterion("express_code =", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeNotEqualTo(String value) {
            addCriterion("express_code <>", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeGreaterThan(String value) {
            addCriterion("express_code >", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeGreaterThanOrEqualTo(String value) {
            addCriterion("express_code >=", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeLessThan(String value) {
            addCriterion("express_code <", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeLessThanOrEqualTo(String value) {
            addCriterion("express_code <=", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeLike(String value) {
            addCriterion("express_code like", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeNotLike(String value) {
            addCriterion("express_code not like", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeIn(List<String> values) {
            addCriterion("express_code in", values, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeNotIn(List<String> values) {
            addCriterion("express_code not in", values, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeBetween(String value1, String value2) {
            addCriterion("express_code between", value1, value2, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeNotBetween(String value1, String value2) {
            addCriterion("express_code not between", value1, value2, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressIsNull() {
            addCriterion("express is null");
            return (Criteria) this;
        }

        public Criteria andExpressIsNotNull() {
            addCriterion("express is not null");
            return (Criteria) this;
        }

        public Criteria andExpressEqualTo(String value) {
            addCriterion("express =", value, "express");
            return (Criteria) this;
        }

        public Criteria andExpressNotEqualTo(String value) {
            addCriterion("express <>", value, "express");
            return (Criteria) this;
        }

        public Criteria andExpressGreaterThan(String value) {
            addCriterion("express >", value, "express");
            return (Criteria) this;
        }

        public Criteria andExpressGreaterThanOrEqualTo(String value) {
            addCriterion("express >=", value, "express");
            return (Criteria) this;
        }

        public Criteria andExpressLessThan(String value) {
            addCriterion("express <", value, "express");
            return (Criteria) this;
        }

        public Criteria andExpressLessThanOrEqualTo(String value) {
            addCriterion("express <=", value, "express");
            return (Criteria) this;
        }

        public Criteria andExpressLike(String value) {
            addCriterion("express like", value, "express");
            return (Criteria) this;
        }

        public Criteria andExpressNotLike(String value) {
            addCriterion("express not like", value, "express");
            return (Criteria) this;
        }

        public Criteria andExpressIn(List<String> values) {
            addCriterion("express in", values, "express");
            return (Criteria) this;
        }

        public Criteria andExpressNotIn(List<String> values) {
            addCriterion("express not in", values, "express");
            return (Criteria) this;
        }

        public Criteria andExpressBetween(String value1, String value2) {
            addCriterion("express between", value1, value2, "express");
            return (Criteria) this;
        }

        public Criteria andExpressNotBetween(String value1, String value2) {
            addCriterion("express not between", value1, value2, "express");
            return (Criteria) this;
        }

        public Criteria andCountIsNull() {
            addCriterion("count is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("count is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(Integer value) {
            addCriterion("count =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(Integer value) {
            addCriterion("count <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(Integer value) {
            addCriterion("count >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("count >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(Integer value) {
            addCriterion("count <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(Integer value) {
            addCriterion("count <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<Integer> values) {
            addCriterion("count in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<Integer> values) {
            addCriterion("count not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(Integer value1, Integer value2) {
            addCriterion("count between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(Integer value1, Integer value2) {
            addCriterion("count not between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andExpressDateIsNull() {
            addCriterion("express_date is null");
            return (Criteria) this;
        }

        public Criteria andExpressDateIsNotNull() {
            addCriterion("express_date is not null");
            return (Criteria) this;
        }

        public Criteria andExpressDateEqualTo(Date value) {
            addCriterion("express_date =", value, "expressDate");
            return (Criteria) this;
        }

        public Criteria andExpressDateNotEqualTo(Date value) {
            addCriterion("express_date <>", value, "expressDate");
            return (Criteria) this;
        }

        public Criteria andExpressDateGreaterThan(Date value) {
            addCriterion("express_date >", value, "expressDate");
            return (Criteria) this;
        }

        public Criteria andExpressDateGreaterThanOrEqualTo(Date value) {
            addCriterion("express_date >=", value, "expressDate");
            return (Criteria) this;
        }

        public Criteria andExpressDateLessThan(Date value) {
            addCriterion("express_date <", value, "expressDate");
            return (Criteria) this;
        }

        public Criteria andExpressDateLessThanOrEqualTo(Date value) {
            addCriterion("express_date <=", value, "expressDate");
            return (Criteria) this;
        }

        public Criteria andExpressDateIn(List<Date> values) {
            addCriterion("express_date in", values, "expressDate");
            return (Criteria) this;
        }

        public Criteria andExpressDateNotIn(List<Date> values) {
            addCriterion("express_date not in", values, "expressDate");
            return (Criteria) this;
        }

        public Criteria andExpressDateBetween(Date value1, Date value2) {
            addCriterion("express_date between", value1, value2, "expressDate");
            return (Criteria) this;
        }

        public Criteria andExpressDateNotBetween(Date value1, Date value2) {
            addCriterion("express_date not between", value1, value2, "expressDate");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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