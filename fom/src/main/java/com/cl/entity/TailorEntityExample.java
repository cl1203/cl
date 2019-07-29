package com.cl.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TailorEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public TailorEntityExample() {
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

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andTailoringGroupIsNull() {
            addCriterion("tailoring_group is null");
            return (Criteria) this;
        }

        public Criteria andTailoringGroupIsNotNull() {
            addCriterion("tailoring_group is not null");
            return (Criteria) this;
        }

        public Criteria andTailoringGroupEqualTo(String value) {
            addCriterion("tailoring_group =", value, "tailoringGroup");
            return (Criteria) this;
        }

        public Criteria andTailoringGroupNotEqualTo(String value) {
            addCriterion("tailoring_group <>", value, "tailoringGroup");
            return (Criteria) this;
        }

        public Criteria andTailoringGroupGreaterThan(String value) {
            addCriterion("tailoring_group >", value, "tailoringGroup");
            return (Criteria) this;
        }

        public Criteria andTailoringGroupGreaterThanOrEqualTo(String value) {
            addCriterion("tailoring_group >=", value, "tailoringGroup");
            return (Criteria) this;
        }

        public Criteria andTailoringGroupLessThan(String value) {
            addCriterion("tailoring_group <", value, "tailoringGroup");
            return (Criteria) this;
        }

        public Criteria andTailoringGroupLessThanOrEqualTo(String value) {
            addCriterion("tailoring_group <=", value, "tailoringGroup");
            return (Criteria) this;
        }

        public Criteria andTailoringGroupLike(String value) {
            addCriterion("tailoring_group like", value, "tailoringGroup");
            return (Criteria) this;
        }

        public Criteria andTailoringGroupNotLike(String value) {
            addCriterion("tailoring_group not like", value, "tailoringGroup");
            return (Criteria) this;
        }

        public Criteria andTailoringGroupIn(List<String> values) {
            addCriterion("tailoring_group in", values, "tailoringGroup");
            return (Criteria) this;
        }

        public Criteria andTailoringGroupNotIn(List<String> values) {
            addCriterion("tailoring_group not in", values, "tailoringGroup");
            return (Criteria) this;
        }

        public Criteria andTailoringGroupBetween(String value1, String value2) {
            addCriterion("tailoring_group between", value1, value2, "tailoringGroup");
            return (Criteria) this;
        }

        public Criteria andTailoringGroupNotBetween(String value1, String value2) {
            addCriterion("tailoring_group not between", value1, value2, "tailoringGroup");
            return (Criteria) this;
        }

        public Criteria andAnswerCutQuantityIsNull() {
            addCriterion("answer_cut_quantity is null");
            return (Criteria) this;
        }

        public Criteria andAnswerCutQuantityIsNotNull() {
            addCriterion("answer_cut_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerCutQuantityEqualTo(Integer value) {
            addCriterion("answer_cut_quantity =", value, "answerCutQuantity");
            return (Criteria) this;
        }

        public Criteria andAnswerCutQuantityNotEqualTo(Integer value) {
            addCriterion("answer_cut_quantity <>", value, "answerCutQuantity");
            return (Criteria) this;
        }

        public Criteria andAnswerCutQuantityGreaterThan(Integer value) {
            addCriterion("answer_cut_quantity >", value, "answerCutQuantity");
            return (Criteria) this;
        }

        public Criteria andAnswerCutQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("answer_cut_quantity >=", value, "answerCutQuantity");
            return (Criteria) this;
        }

        public Criteria andAnswerCutQuantityLessThan(Integer value) {
            addCriterion("answer_cut_quantity <", value, "answerCutQuantity");
            return (Criteria) this;
        }

        public Criteria andAnswerCutQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("answer_cut_quantity <=", value, "answerCutQuantity");
            return (Criteria) this;
        }

        public Criteria andAnswerCutQuantityIn(List<Integer> values) {
            addCriterion("answer_cut_quantity in", values, "answerCutQuantity");
            return (Criteria) this;
        }

        public Criteria andAnswerCutQuantityNotIn(List<Integer> values) {
            addCriterion("answer_cut_quantity not in", values, "answerCutQuantity");
            return (Criteria) this;
        }

        public Criteria andAnswerCutQuantityBetween(Integer value1, Integer value2) {
            addCriterion("answer_cut_quantity between", value1, value2, "answerCutQuantity");
            return (Criteria) this;
        }

        public Criteria andAnswerCutQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("answer_cut_quantity not between", value1, value2, "answerCutQuantity");
            return (Criteria) this;
        }

        public Criteria andActualCutQuantityIsNull() {
            addCriterion("actual_cut_quantity is null");
            return (Criteria) this;
        }

        public Criteria andActualCutQuantityIsNotNull() {
            addCriterion("actual_cut_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andActualCutQuantityEqualTo(Integer value) {
            addCriterion("actual_cut_quantity =", value, "actualCutQuantity");
            return (Criteria) this;
        }

        public Criteria andActualCutQuantityNotEqualTo(Integer value) {
            addCriterion("actual_cut_quantity <>", value, "actualCutQuantity");
            return (Criteria) this;
        }

        public Criteria andActualCutQuantityGreaterThan(Integer value) {
            addCriterion("actual_cut_quantity >", value, "actualCutQuantity");
            return (Criteria) this;
        }

        public Criteria andActualCutQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("actual_cut_quantity >=", value, "actualCutQuantity");
            return (Criteria) this;
        }

        public Criteria andActualCutQuantityLessThan(Integer value) {
            addCriterion("actual_cut_quantity <", value, "actualCutQuantity");
            return (Criteria) this;
        }

        public Criteria andActualCutQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("actual_cut_quantity <=", value, "actualCutQuantity");
            return (Criteria) this;
        }

        public Criteria andActualCutQuantityIn(List<Integer> values) {
            addCriterion("actual_cut_quantity in", values, "actualCutQuantity");
            return (Criteria) this;
        }

        public Criteria andActualCutQuantityNotIn(List<Integer> values) {
            addCriterion("actual_cut_quantity not in", values, "actualCutQuantity");
            return (Criteria) this;
        }

        public Criteria andActualCutQuantityBetween(Integer value1, Integer value2) {
            addCriterion("actual_cut_quantity between", value1, value2, "actualCutQuantity");
            return (Criteria) this;
        }

        public Criteria andActualCutQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("actual_cut_quantity not between", value1, value2, "actualCutQuantity");
            return (Criteria) this;
        }

        public Criteria andMonovalentIsNull() {
            addCriterion("monovalent is null");
            return (Criteria) this;
        }

        public Criteria andMonovalentIsNotNull() {
            addCriterion("monovalent is not null");
            return (Criteria) this;
        }

        public Criteria andMonovalentEqualTo(BigDecimal value) {
            addCriterion("monovalent =", value, "monovalent");
            return (Criteria) this;
        }

        public Criteria andMonovalentNotEqualTo(BigDecimal value) {
            addCriterion("monovalent <>", value, "monovalent");
            return (Criteria) this;
        }

        public Criteria andMonovalentGreaterThan(BigDecimal value) {
            addCriterion("monovalent >", value, "monovalent");
            return (Criteria) this;
        }

        public Criteria andMonovalentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("monovalent >=", value, "monovalent");
            return (Criteria) this;
        }

        public Criteria andMonovalentLessThan(BigDecimal value) {
            addCriterion("monovalent <", value, "monovalent");
            return (Criteria) this;
        }

        public Criteria andMonovalentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("monovalent <=", value, "monovalent");
            return (Criteria) this;
        }

        public Criteria andMonovalentIn(List<BigDecimal> values) {
            addCriterion("monovalent in", values, "monovalent");
            return (Criteria) this;
        }

        public Criteria andMonovalentNotIn(List<BigDecimal> values) {
            addCriterion("monovalent not in", values, "monovalent");
            return (Criteria) this;
        }

        public Criteria andMonovalentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("monovalent between", value1, value2, "monovalent");
            return (Criteria) this;
        }

        public Criteria andMonovalentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("monovalent not between", value1, value2, "monovalent");
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

        public Criteria andTailoringStatusIsNull() {
            addCriterion("tailoring_status is null");
            return (Criteria) this;
        }

        public Criteria andTailoringStatusIsNotNull() {
            addCriterion("tailoring_status is not null");
            return (Criteria) this;
        }

        public Criteria andTailoringStatusEqualTo(Byte value) {
            addCriterion("tailoring_status =", value, "tailoringStatus");
            return (Criteria) this;
        }

        public Criteria andTailoringStatusNotEqualTo(Byte value) {
            addCriterion("tailoring_status <>", value, "tailoringStatus");
            return (Criteria) this;
        }

        public Criteria andTailoringStatusGreaterThan(Byte value) {
            addCriterion("tailoring_status >", value, "tailoringStatus");
            return (Criteria) this;
        }

        public Criteria andTailoringStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("tailoring_status >=", value, "tailoringStatus");
            return (Criteria) this;
        }

        public Criteria andTailoringStatusLessThan(Byte value) {
            addCriterion("tailoring_status <", value, "tailoringStatus");
            return (Criteria) this;
        }

        public Criteria andTailoringStatusLessThanOrEqualTo(Byte value) {
            addCriterion("tailoring_status <=", value, "tailoringStatus");
            return (Criteria) this;
        }

        public Criteria andTailoringStatusIn(List<Byte> values) {
            addCriterion("tailoring_status in", values, "tailoringStatus");
            return (Criteria) this;
        }

        public Criteria andTailoringStatusNotIn(List<Byte> values) {
            addCriterion("tailoring_status not in", values, "tailoringStatus");
            return (Criteria) this;
        }

        public Criteria andTailoringStatusBetween(Byte value1, Byte value2) {
            addCriterion("tailoring_status between", value1, value2, "tailoringStatus");
            return (Criteria) this;
        }

        public Criteria andTailoringStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("tailoring_status not between", value1, value2, "tailoringStatus");
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