package com.cl.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PurchaseManageEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public PurchaseManageEntityExample() {
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

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumberIsNull() {
            addCriterion("purchase_number is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumberIsNotNull() {
            addCriterion("purchase_number is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumberEqualTo(String value) {
            addCriterion("purchase_number =", value, "purchaseNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumberNotEqualTo(String value) {
            addCriterion("purchase_number <>", value, "purchaseNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumberGreaterThan(String value) {
            addCriterion("purchase_number >", value, "purchaseNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumberGreaterThanOrEqualTo(String value) {
            addCriterion("purchase_number >=", value, "purchaseNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumberLessThan(String value) {
            addCriterion("purchase_number <", value, "purchaseNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumberLessThanOrEqualTo(String value) {
            addCriterion("purchase_number <=", value, "purchaseNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumberLike(String value) {
            addCriterion("purchase_number like", value, "purchaseNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumberNotLike(String value) {
            addCriterion("purchase_number not like", value, "purchaseNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumberIn(List<String> values) {
            addCriterion("purchase_number in", values, "purchaseNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumberNotIn(List<String> values) {
            addCriterion("purchase_number not in", values, "purchaseNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumberBetween(String value1, String value2) {
            addCriterion("purchase_number between", value1, value2, "purchaseNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumberNotBetween(String value1, String value2) {
            addCriterion("purchase_number not between", value1, value2, "purchaseNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeIsNull() {
            addCriterion("purchase_time is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeIsNotNull() {
            addCriterion("purchase_time is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeEqualTo(Date value) {
            addCriterion("purchase_time =", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeNotEqualTo(Date value) {
            addCriterion("purchase_time <>", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeGreaterThan(Date value) {
            addCriterion("purchase_time >", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("purchase_time >=", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeLessThan(Date value) {
            addCriterion("purchase_time <", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeLessThanOrEqualTo(Date value) {
            addCriterion("purchase_time <=", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeIn(List<Date> values) {
            addCriterion("purchase_time in", values, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeNotIn(List<Date> values) {
            addCriterion("purchase_time not in", values, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeBetween(Date value1, Date value2) {
            addCriterion("purchase_time between", value1, value2, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeNotBetween(Date value1, Date value2) {
            addCriterion("purchase_time not between", value1, value2, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andActualPickQuantityIsNull() {
            addCriterion("actual_pick_quantity is null");
            return (Criteria) this;
        }

        public Criteria andActualPickQuantityIsNotNull() {
            addCriterion("actual_pick_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andActualPickQuantityEqualTo(Integer value) {
            addCriterion("actual_pick_quantity =", value, "actualPickQuantity");
            return (Criteria) this;
        }

        public Criteria andActualPickQuantityNotEqualTo(Integer value) {
            addCriterion("actual_pick_quantity <>", value, "actualPickQuantity");
            return (Criteria) this;
        }

        public Criteria andActualPickQuantityGreaterThan(Integer value) {
            addCriterion("actual_pick_quantity >", value, "actualPickQuantity");
            return (Criteria) this;
        }

        public Criteria andActualPickQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("actual_pick_quantity >=", value, "actualPickQuantity");
            return (Criteria) this;
        }

        public Criteria andActualPickQuantityLessThan(Integer value) {
            addCriterion("actual_pick_quantity <", value, "actualPickQuantity");
            return (Criteria) this;
        }

        public Criteria andActualPickQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("actual_pick_quantity <=", value, "actualPickQuantity");
            return (Criteria) this;
        }

        public Criteria andActualPickQuantityIn(List<Integer> values) {
            addCriterion("actual_pick_quantity in", values, "actualPickQuantity");
            return (Criteria) this;
        }

        public Criteria andActualPickQuantityNotIn(List<Integer> values) {
            addCriterion("actual_pick_quantity not in", values, "actualPickQuantity");
            return (Criteria) this;
        }

        public Criteria andActualPickQuantityBetween(Integer value1, Integer value2) {
            addCriterion("actual_pick_quantity between", value1, value2, "actualPickQuantity");
            return (Criteria) this;
        }

        public Criteria andActualPickQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("actual_pick_quantity not between", value1, value2, "actualPickQuantity");
            return (Criteria) this;
        }

        public Criteria andActualPickMonovalentIsNull() {
            addCriterion("actual_pick_monovalent is null");
            return (Criteria) this;
        }

        public Criteria andActualPickMonovalentIsNotNull() {
            addCriterion("actual_pick_monovalent is not null");
            return (Criteria) this;
        }

        public Criteria andActualPickMonovalentEqualTo(BigDecimal value) {
            addCriterion("actual_pick_monovalent =", value, "actualPickMonovalent");
            return (Criteria) this;
        }

        public Criteria andActualPickMonovalentNotEqualTo(BigDecimal value) {
            addCriterion("actual_pick_monovalent <>", value, "actualPickMonovalent");
            return (Criteria) this;
        }

        public Criteria andActualPickMonovalentGreaterThan(BigDecimal value) {
            addCriterion("actual_pick_monovalent >", value, "actualPickMonovalent");
            return (Criteria) this;
        }

        public Criteria andActualPickMonovalentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("actual_pick_monovalent >=", value, "actualPickMonovalent");
            return (Criteria) this;
        }

        public Criteria andActualPickMonovalentLessThan(BigDecimal value) {
            addCriterion("actual_pick_monovalent <", value, "actualPickMonovalent");
            return (Criteria) this;
        }

        public Criteria andActualPickMonovalentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("actual_pick_monovalent <=", value, "actualPickMonovalent");
            return (Criteria) this;
        }

        public Criteria andActualPickMonovalentIn(List<BigDecimal> values) {
            addCriterion("actual_pick_monovalent in", values, "actualPickMonovalent");
            return (Criteria) this;
        }

        public Criteria andActualPickMonovalentNotIn(List<BigDecimal> values) {
            addCriterion("actual_pick_monovalent not in", values, "actualPickMonovalent");
            return (Criteria) this;
        }

        public Criteria andActualPickMonovalentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actual_pick_monovalent between", value1, value2, "actualPickMonovalent");
            return (Criteria) this;
        }

        public Criteria andActualPickMonovalentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actual_pick_monovalent not between", value1, value2, "actualPickMonovalent");
            return (Criteria) this;
        }

        public Criteria andActualPickTotalIsNull() {
            addCriterion("actual_pick_total is null");
            return (Criteria) this;
        }

        public Criteria andActualPickTotalIsNotNull() {
            addCriterion("actual_pick_total is not null");
            return (Criteria) this;
        }

        public Criteria andActualPickTotalEqualTo(BigDecimal value) {
            addCriterion("actual_pick_total =", value, "actualPickTotal");
            return (Criteria) this;
        }

        public Criteria andActualPickTotalNotEqualTo(BigDecimal value) {
            addCriterion("actual_pick_total <>", value, "actualPickTotal");
            return (Criteria) this;
        }

        public Criteria andActualPickTotalGreaterThan(BigDecimal value) {
            addCriterion("actual_pick_total >", value, "actualPickTotal");
            return (Criteria) this;
        }

        public Criteria andActualPickTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("actual_pick_total >=", value, "actualPickTotal");
            return (Criteria) this;
        }

        public Criteria andActualPickTotalLessThan(BigDecimal value) {
            addCriterion("actual_pick_total <", value, "actualPickTotal");
            return (Criteria) this;
        }

        public Criteria andActualPickTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("actual_pick_total <=", value, "actualPickTotal");
            return (Criteria) this;
        }

        public Criteria andActualPickTotalIn(List<BigDecimal> values) {
            addCriterion("actual_pick_total in", values, "actualPickTotal");
            return (Criteria) this;
        }

        public Criteria andActualPickTotalNotIn(List<BigDecimal> values) {
            addCriterion("actual_pick_total not in", values, "actualPickTotal");
            return (Criteria) this;
        }

        public Criteria andActualPickTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actual_pick_total between", value1, value2, "actualPickTotal");
            return (Criteria) this;
        }

        public Criteria andActualPickTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actual_pick_total not between", value1, value2, "actualPickTotal");
            return (Criteria) this;
        }

        public Criteria andConsumingTimeIsNull() {
            addCriterion("consuming_time is null");
            return (Criteria) this;
        }

        public Criteria andConsumingTimeIsNotNull() {
            addCriterion("consuming_time is not null");
            return (Criteria) this;
        }

        public Criteria andConsumingTimeEqualTo(BigDecimal value) {
            addCriterion("consuming_time =", value, "consumingTime");
            return (Criteria) this;
        }

        public Criteria andConsumingTimeNotEqualTo(BigDecimal value) {
            addCriterion("consuming_time <>", value, "consumingTime");
            return (Criteria) this;
        }

        public Criteria andConsumingTimeGreaterThan(BigDecimal value) {
            addCriterion("consuming_time >", value, "consumingTime");
            return (Criteria) this;
        }

        public Criteria andConsumingTimeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("consuming_time >=", value, "consumingTime");
            return (Criteria) this;
        }

        public Criteria andConsumingTimeLessThan(BigDecimal value) {
            addCriterion("consuming_time <", value, "consumingTime");
            return (Criteria) this;
        }

        public Criteria andConsumingTimeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("consuming_time <=", value, "consumingTime");
            return (Criteria) this;
        }

        public Criteria andConsumingTimeIn(List<BigDecimal> values) {
            addCriterion("consuming_time in", values, "consumingTime");
            return (Criteria) this;
        }

        public Criteria andConsumingTimeNotIn(List<BigDecimal> values) {
            addCriterion("consuming_time not in", values, "consumingTime");
            return (Criteria) this;
        }

        public Criteria andConsumingTimeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("consuming_time between", value1, value2, "consumingTime");
            return (Criteria) this;
        }

        public Criteria andConsumingTimeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("consuming_time not between", value1, value2, "consumingTime");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
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

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNull() {
            addCriterion("last_update_time is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNotNull() {
            addCriterion("last_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeEqualTo(Date value) {
            addCriterion("last_update_time =", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotEqualTo(Date value) {
            addCriterion("last_update_time <>", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThan(Date value) {
            addCriterion("last_update_time >", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_update_time >=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThan(Date value) {
            addCriterion("last_update_time <", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_update_time <=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIn(List<Date> values) {
            addCriterion("last_update_time in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotIn(List<Date> values) {
            addCriterion("last_update_time not in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("last_update_time between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_update_time not between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIsNull() {
            addCriterion("last_update_user is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIsNotNull() {
            addCriterion("last_update_user is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserEqualTo(String value) {
            addCriterion("last_update_user =", value, "lastUpdateUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserNotEqualTo(String value) {
            addCriterion("last_update_user <>", value, "lastUpdateUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserGreaterThan(String value) {
            addCriterion("last_update_user >", value, "lastUpdateUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("last_update_user >=", value, "lastUpdateUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserLessThan(String value) {
            addCriterion("last_update_user <", value, "lastUpdateUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("last_update_user <=", value, "lastUpdateUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserLike(String value) {
            addCriterion("last_update_user like", value, "lastUpdateUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserNotLike(String value) {
            addCriterion("last_update_user not like", value, "lastUpdateUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIn(List<String> values) {
            addCriterion("last_update_user in", values, "lastUpdateUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserNotIn(List<String> values) {
            addCriterion("last_update_user not in", values, "lastUpdateUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserBetween(String value1, String value2) {
            addCriterion("last_update_user between", value1, value2, "lastUpdateUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserNotBetween(String value1, String value2) {
            addCriterion("last_update_user not between", value1, value2, "lastUpdateUser");
            return (Criteria) this;
        }
    }

    /**
     */
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