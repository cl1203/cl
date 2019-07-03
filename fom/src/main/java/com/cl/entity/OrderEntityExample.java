package com.cl.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public OrderEntityExample() {
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

        public Criteria andOrderNumberIsNull() {
            addCriterion("order_number is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNotNull() {
            addCriterion("order_number is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberEqualTo(String value) {
            addCriterion("order_number =", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotEqualTo(String value) {
            addCriterion("order_number <>", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThan(String value) {
            addCriterion("order_number >", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThanOrEqualTo(String value) {
            addCriterion("order_number >=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThan(String value) {
            addCriterion("order_number <", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThanOrEqualTo(String value) {
            addCriterion("order_number <=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLike(String value) {
            addCriterion("order_number like", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotLike(String value) {
            addCriterion("order_number not like", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIn(List<String> values) {
            addCriterion("order_number in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotIn(List<String> values) {
            addCriterion("order_number not in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberBetween(String value1, String value2) {
            addCriterion("order_number between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotBetween(String value1, String value2) {
            addCriterion("order_number not between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(Byte value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(Byte value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(Byte value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(Byte value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(Byte value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<Byte> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<Byte> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(Byte value1, Byte value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderQuantityIsNull() {
            addCriterion("order_quantity is null");
            return (Criteria) this;
        }

        public Criteria andOrderQuantityIsNotNull() {
            addCriterion("order_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andOrderQuantityEqualTo(Integer value) {
            addCriterion("order_quantity =", value, "orderQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderQuantityNotEqualTo(Integer value) {
            addCriterion("order_quantity <>", value, "orderQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderQuantityGreaterThan(Integer value) {
            addCriterion("order_quantity >", value, "orderQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_quantity >=", value, "orderQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderQuantityLessThan(Integer value) {
            addCriterion("order_quantity <", value, "orderQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("order_quantity <=", value, "orderQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderQuantityIn(List<Integer> values) {
            addCriterion("order_quantity in", values, "orderQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderQuantityNotIn(List<Integer> values) {
            addCriterion("order_quantity not in", values, "orderQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderQuantityBetween(Integer value1, Integer value2) {
            addCriterion("order_quantity between", value1, value2, "orderQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("order_quantity not between", value1, value2, "orderQuantity");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNull() {
            addCriterion("order_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNotNull() {
            addCriterion("order_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeEqualTo(Date value) {
            addCriterion("order_time =", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotEqualTo(Date value) {
            addCriterion("order_time <>", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThan(Date value) {
            addCriterion("order_time >", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_time >=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThan(Date value) {
            addCriterion("order_time <", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_time <=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIn(List<Date> values) {
            addCriterion("order_time in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotIn(List<Date> values) {
            addCriterion("order_time not in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeBetween(Date value1, Date value2) {
            addCriterion("order_time between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_time not between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andSkuIsNull() {
            addCriterion("sku is null");
            return (Criteria) this;
        }

        public Criteria andSkuIsNotNull() {
            addCriterion("sku is not null");
            return (Criteria) this;
        }

        public Criteria andSkuEqualTo(String value) {
            addCriterion("sku =", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuNotEqualTo(String value) {
            addCriterion("sku <>", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuGreaterThan(String value) {
            addCriterion("sku >", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuGreaterThanOrEqualTo(String value) {
            addCriterion("sku >=", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuLessThan(String value) {
            addCriterion("sku <", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuLessThanOrEqualTo(String value) {
            addCriterion("sku <=", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuLike(String value) {
            addCriterion("sku like", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuNotLike(String value) {
            addCriterion("sku not like", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuIn(List<String> values) {
            addCriterion("sku in", values, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuNotIn(List<String> values) {
            addCriterion("sku not in", values, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuBetween(String value1, String value2) {
            addCriterion("sku between", value1, value2, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuNotBetween(String value1, String value2) {
            addCriterion("sku not between", value1, value2, "sku");
            return (Criteria) this;
        }

        public Criteria andProducerIsNull() {
            addCriterion("producer is null");
            return (Criteria) this;
        }

        public Criteria andProducerIsNotNull() {
            addCriterion("producer is not null");
            return (Criteria) this;
        }

        public Criteria andProducerEqualTo(String value) {
            addCriterion("producer =", value, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerNotEqualTo(String value) {
            addCriterion("producer <>", value, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerGreaterThan(String value) {
            addCriterion("producer >", value, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerGreaterThanOrEqualTo(String value) {
            addCriterion("producer >=", value, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerLessThan(String value) {
            addCriterion("producer <", value, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerLessThanOrEqualTo(String value) {
            addCriterion("producer <=", value, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerLike(String value) {
            addCriterion("producer like", value, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerNotLike(String value) {
            addCriterion("producer not like", value, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerIn(List<String> values) {
            addCriterion("producer in", values, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerNotIn(List<String> values) {
            addCriterion("producer not in", values, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerBetween(String value1, String value2) {
            addCriterion("producer between", value1, value2, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerNotBetween(String value1, String value2) {
            addCriterion("producer not between", value1, value2, "producer");
            return (Criteria) this;
        }

        public Criteria andSecondaryProcessIsNull() {
            addCriterion("secondary_process is null");
            return (Criteria) this;
        }

        public Criteria andSecondaryProcessIsNotNull() {
            addCriterion("secondary_process is not null");
            return (Criteria) this;
        }

        public Criteria andSecondaryProcessEqualTo(String value) {
            addCriterion("secondary_process =", value, "secondaryProcess");
            return (Criteria) this;
        }

        public Criteria andSecondaryProcessNotEqualTo(String value) {
            addCriterion("secondary_process <>", value, "secondaryProcess");
            return (Criteria) this;
        }

        public Criteria andSecondaryProcessGreaterThan(String value) {
            addCriterion("secondary_process >", value, "secondaryProcess");
            return (Criteria) this;
        }

        public Criteria andSecondaryProcessGreaterThanOrEqualTo(String value) {
            addCriterion("secondary_process >=", value, "secondaryProcess");
            return (Criteria) this;
        }

        public Criteria andSecondaryProcessLessThan(String value) {
            addCriterion("secondary_process <", value, "secondaryProcess");
            return (Criteria) this;
        }

        public Criteria andSecondaryProcessLessThanOrEqualTo(String value) {
            addCriterion("secondary_process <=", value, "secondaryProcess");
            return (Criteria) this;
        }

        public Criteria andSecondaryProcessLike(String value) {
            addCriterion("secondary_process like", value, "secondaryProcess");
            return (Criteria) this;
        }

        public Criteria andSecondaryProcessNotLike(String value) {
            addCriterion("secondary_process not like", value, "secondaryProcess");
            return (Criteria) this;
        }

        public Criteria andSecondaryProcessIn(List<String> values) {
            addCriterion("secondary_process in", values, "secondaryProcess");
            return (Criteria) this;
        }

        public Criteria andSecondaryProcessNotIn(List<String> values) {
            addCriterion("secondary_process not in", values, "secondaryProcess");
            return (Criteria) this;
        }

        public Criteria andSecondaryProcessBetween(String value1, String value2) {
            addCriterion("secondary_process between", value1, value2, "secondaryProcess");
            return (Criteria) this;
        }

        public Criteria andSecondaryProcessNotBetween(String value1, String value2) {
            addCriterion("secondary_process not between", value1, value2, "secondaryProcess");
            return (Criteria) this;
        }

        public Criteria andMaterielNameIsNull() {
            addCriterion("materiel_name is null");
            return (Criteria) this;
        }

        public Criteria andMaterielNameIsNotNull() {
            addCriterion("materiel_name is not null");
            return (Criteria) this;
        }

        public Criteria andMaterielNameEqualTo(String value) {
            addCriterion("materiel_name =", value, "materielName");
            return (Criteria) this;
        }

        public Criteria andMaterielNameNotEqualTo(String value) {
            addCriterion("materiel_name <>", value, "materielName");
            return (Criteria) this;
        }

        public Criteria andMaterielNameGreaterThan(String value) {
            addCriterion("materiel_name >", value, "materielName");
            return (Criteria) this;
        }

        public Criteria andMaterielNameGreaterThanOrEqualTo(String value) {
            addCriterion("materiel_name >=", value, "materielName");
            return (Criteria) this;
        }

        public Criteria andMaterielNameLessThan(String value) {
            addCriterion("materiel_name <", value, "materielName");
            return (Criteria) this;
        }

        public Criteria andMaterielNameLessThanOrEqualTo(String value) {
            addCriterion("materiel_name <=", value, "materielName");
            return (Criteria) this;
        }

        public Criteria andMaterielNameLike(String value) {
            addCriterion("materiel_name like", value, "materielName");
            return (Criteria) this;
        }

        public Criteria andMaterielNameNotLike(String value) {
            addCriterion("materiel_name not like", value, "materielName");
            return (Criteria) this;
        }

        public Criteria andMaterielNameIn(List<String> values) {
            addCriterion("materiel_name in", values, "materielName");
            return (Criteria) this;
        }

        public Criteria andMaterielNameNotIn(List<String> values) {
            addCriterion("materiel_name not in", values, "materielName");
            return (Criteria) this;
        }

        public Criteria andMaterielNameBetween(String value1, String value2) {
            addCriterion("materiel_name between", value1, value2, "materielName");
            return (Criteria) this;
        }

        public Criteria andMaterielNameNotBetween(String value1, String value2) {
            addCriterion("materiel_name not between", value1, value2, "materielName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameIsNull() {
            addCriterion("supplier_name is null");
            return (Criteria) this;
        }

        public Criteria andSupplierNameIsNotNull() {
            addCriterion("supplier_name is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierNameEqualTo(String value) {
            addCriterion("supplier_name =", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameNotEqualTo(String value) {
            addCriterion("supplier_name <>", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameGreaterThan(String value) {
            addCriterion("supplier_name >", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameGreaterThanOrEqualTo(String value) {
            addCriterion("supplier_name >=", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameLessThan(String value) {
            addCriterion("supplier_name <", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameLessThanOrEqualTo(String value) {
            addCriterion("supplier_name <=", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameLike(String value) {
            addCriterion("supplier_name like", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameNotLike(String value) {
            addCriterion("supplier_name not like", value, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameIn(List<String> values) {
            addCriterion("supplier_name in", values, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameNotIn(List<String> values) {
            addCriterion("supplier_name not in", values, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameBetween(String value1, String value2) {
            addCriterion("supplier_name between", value1, value2, "supplierName");
            return (Criteria) this;
        }

        public Criteria andSupplierNameNotBetween(String value1, String value2) {
            addCriterion("supplier_name not between", value1, value2, "supplierName");
            return (Criteria) this;
        }

        public Criteria andAnswerPickQuantityIsNull() {
            addCriterion("answer_pick_quantity is null");
            return (Criteria) this;
        }

        public Criteria andAnswerPickQuantityIsNotNull() {
            addCriterion("answer_pick_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerPickQuantityEqualTo(Integer value) {
            addCriterion("answer_pick_quantity =", value, "answerPickQuantity");
            return (Criteria) this;
        }

        public Criteria andAnswerPickQuantityNotEqualTo(Integer value) {
            addCriterion("answer_pick_quantity <>", value, "answerPickQuantity");
            return (Criteria) this;
        }

        public Criteria andAnswerPickQuantityGreaterThan(Integer value) {
            addCriterion("answer_pick_quantity >", value, "answerPickQuantity");
            return (Criteria) this;
        }

        public Criteria andAnswerPickQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("answer_pick_quantity >=", value, "answerPickQuantity");
            return (Criteria) this;
        }

        public Criteria andAnswerPickQuantityLessThan(Integer value) {
            addCriterion("answer_pick_quantity <", value, "answerPickQuantity");
            return (Criteria) this;
        }

        public Criteria andAnswerPickQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("answer_pick_quantity <=", value, "answerPickQuantity");
            return (Criteria) this;
        }

        public Criteria andAnswerPickQuantityIn(List<Integer> values) {
            addCriterion("answer_pick_quantity in", values, "answerPickQuantity");
            return (Criteria) this;
        }

        public Criteria andAnswerPickQuantityNotIn(List<Integer> values) {
            addCriterion("answer_pick_quantity not in", values, "answerPickQuantity");
            return (Criteria) this;
        }

        public Criteria andAnswerPickQuantityBetween(Integer value1, Integer value2) {
            addCriterion("answer_pick_quantity between", value1, value2, "answerPickQuantity");
            return (Criteria) this;
        }

        public Criteria andAnswerPickQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("answer_pick_quantity not between", value1, value2, "answerPickQuantity");
            return (Criteria) this;
        }

        public Criteria andAnswerPickMonovalentIsNull() {
            addCriterion("answer_pick_monovalent is null");
            return (Criteria) this;
        }

        public Criteria andAnswerPickMonovalentIsNotNull() {
            addCriterion("answer_pick_monovalent is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerPickMonovalentEqualTo(BigDecimal value) {
            addCriterion("answer_pick_monovalent =", value, "answerPickMonovalent");
            return (Criteria) this;
        }

        public Criteria andAnswerPickMonovalentNotEqualTo(BigDecimal value) {
            addCriterion("answer_pick_monovalent <>", value, "answerPickMonovalent");
            return (Criteria) this;
        }

        public Criteria andAnswerPickMonovalentGreaterThan(BigDecimal value) {
            addCriterion("answer_pick_monovalent >", value, "answerPickMonovalent");
            return (Criteria) this;
        }

        public Criteria andAnswerPickMonovalentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("answer_pick_monovalent >=", value, "answerPickMonovalent");
            return (Criteria) this;
        }

        public Criteria andAnswerPickMonovalentLessThan(BigDecimal value) {
            addCriterion("answer_pick_monovalent <", value, "answerPickMonovalent");
            return (Criteria) this;
        }

        public Criteria andAnswerPickMonovalentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("answer_pick_monovalent <=", value, "answerPickMonovalent");
            return (Criteria) this;
        }

        public Criteria andAnswerPickMonovalentIn(List<BigDecimal> values) {
            addCriterion("answer_pick_monovalent in", values, "answerPickMonovalent");
            return (Criteria) this;
        }

        public Criteria andAnswerPickMonovalentNotIn(List<BigDecimal> values) {
            addCriterion("answer_pick_monovalent not in", values, "answerPickMonovalent");
            return (Criteria) this;
        }

        public Criteria andAnswerPickMonovalentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("answer_pick_monovalent between", value1, value2, "answerPickMonovalent");
            return (Criteria) this;
        }

        public Criteria andAnswerPickMonovalentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("answer_pick_monovalent not between", value1, value2, "answerPickMonovalent");
            return (Criteria) this;
        }

        public Criteria andAnswerPickTotalIsNull() {
            addCriterion("answer_pick_total is null");
            return (Criteria) this;
        }

        public Criteria andAnswerPickTotalIsNotNull() {
            addCriterion("answer_pick_total is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerPickTotalEqualTo(BigDecimal value) {
            addCriterion("answer_pick_total =", value, "answerPickTotal");
            return (Criteria) this;
        }

        public Criteria andAnswerPickTotalNotEqualTo(BigDecimal value) {
            addCriterion("answer_pick_total <>", value, "answerPickTotal");
            return (Criteria) this;
        }

        public Criteria andAnswerPickTotalGreaterThan(BigDecimal value) {
            addCriterion("answer_pick_total >", value, "answerPickTotal");
            return (Criteria) this;
        }

        public Criteria andAnswerPickTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("answer_pick_total >=", value, "answerPickTotal");
            return (Criteria) this;
        }

        public Criteria andAnswerPickTotalLessThan(BigDecimal value) {
            addCriterion("answer_pick_total <", value, "answerPickTotal");
            return (Criteria) this;
        }

        public Criteria andAnswerPickTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("answer_pick_total <=", value, "answerPickTotal");
            return (Criteria) this;
        }

        public Criteria andAnswerPickTotalIn(List<BigDecimal> values) {
            addCriterion("answer_pick_total in", values, "answerPickTotal");
            return (Criteria) this;
        }

        public Criteria andAnswerPickTotalNotIn(List<BigDecimal> values) {
            addCriterion("answer_pick_total not in", values, "answerPickTotal");
            return (Criteria) this;
        }

        public Criteria andAnswerPickTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("answer_pick_total between", value1, value2, "answerPickTotal");
            return (Criteria) this;
        }

        public Criteria andAnswerPickTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("answer_pick_total not between", value1, value2, "answerPickTotal");
            return (Criteria) this;
        }

        public Criteria andSurplusTimeIsNull() {
            addCriterion("surplus_time is null");
            return (Criteria) this;
        }

        public Criteria andSurplusTimeIsNotNull() {
            addCriterion("surplus_time is not null");
            return (Criteria) this;
        }

        public Criteria andSurplusTimeEqualTo(String value) {
            addCriterion("surplus_time =", value, "surplusTime");
            return (Criteria) this;
        }

        public Criteria andSurplusTimeNotEqualTo(String value) {
            addCriterion("surplus_time <>", value, "surplusTime");
            return (Criteria) this;
        }

        public Criteria andSurplusTimeGreaterThan(String value) {
            addCriterion("surplus_time >", value, "surplusTime");
            return (Criteria) this;
        }

        public Criteria andSurplusTimeGreaterThanOrEqualTo(String value) {
            addCriterion("surplus_time >=", value, "surplusTime");
            return (Criteria) this;
        }

        public Criteria andSurplusTimeLessThan(String value) {
            addCriterion("surplus_time <", value, "surplusTime");
            return (Criteria) this;
        }

        public Criteria andSurplusTimeLessThanOrEqualTo(String value) {
            addCriterion("surplus_time <=", value, "surplusTime");
            return (Criteria) this;
        }

        public Criteria andSurplusTimeLike(String value) {
            addCriterion("surplus_time like", value, "surplusTime");
            return (Criteria) this;
        }

        public Criteria andSurplusTimeNotLike(String value) {
            addCriterion("surplus_time not like", value, "surplusTime");
            return (Criteria) this;
        }

        public Criteria andSurplusTimeIn(List<String> values) {
            addCriterion("surplus_time in", values, "surplusTime");
            return (Criteria) this;
        }

        public Criteria andSurplusTimeNotIn(List<String> values) {
            addCriterion("surplus_time not in", values, "surplusTime");
            return (Criteria) this;
        }

        public Criteria andSurplusTimeBetween(String value1, String value2) {
            addCriterion("surplus_time between", value1, value2, "surplusTime");
            return (Criteria) this;
        }

        public Criteria andSurplusTimeNotBetween(String value1, String value2) {
            addCriterion("surplus_time not between", value1, value2, "surplusTime");
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

        public Criteria andPurchaseTimeEqualTo(Integer value) {
            addCriterion("purchase_time =", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeNotEqualTo(Integer value) {
            addCriterion("purchase_time <>", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeGreaterThan(Integer value) {
            addCriterion("purchase_time >", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("purchase_time >=", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeLessThan(Integer value) {
            addCriterion("purchase_time <", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeLessThanOrEqualTo(Integer value) {
            addCriterion("purchase_time <=", value, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeIn(List<Integer> values) {
            addCriterion("purchase_time in", values, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeNotIn(List<Integer> values) {
            addCriterion("purchase_time not in", values, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeBetween(Integer value1, Integer value2) {
            addCriterion("purchase_time between", value1, value2, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andPurchaseTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("purchase_time not between", value1, value2, "purchaseTime");
            return (Criteria) this;
        }

        public Criteria andTailoringTimeIsNull() {
            addCriterion("tailoring_time is null");
            return (Criteria) this;
        }

        public Criteria andTailoringTimeIsNotNull() {
            addCriterion("tailoring_time is not null");
            return (Criteria) this;
        }

        public Criteria andTailoringTimeEqualTo(Integer value) {
            addCriterion("tailoring_time =", value, "tailoringTime");
            return (Criteria) this;
        }

        public Criteria andTailoringTimeNotEqualTo(Integer value) {
            addCriterion("tailoring_time <>", value, "tailoringTime");
            return (Criteria) this;
        }

        public Criteria andTailoringTimeGreaterThan(Integer value) {
            addCriterion("tailoring_time >", value, "tailoringTime");
            return (Criteria) this;
        }

        public Criteria andTailoringTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("tailoring_time >=", value, "tailoringTime");
            return (Criteria) this;
        }

        public Criteria andTailoringTimeLessThan(Integer value) {
            addCriterion("tailoring_time <", value, "tailoringTime");
            return (Criteria) this;
        }

        public Criteria andTailoringTimeLessThanOrEqualTo(Integer value) {
            addCriterion("tailoring_time <=", value, "tailoringTime");
            return (Criteria) this;
        }

        public Criteria andTailoringTimeIn(List<Integer> values) {
            addCriterion("tailoring_time in", values, "tailoringTime");
            return (Criteria) this;
        }

        public Criteria andTailoringTimeNotIn(List<Integer> values) {
            addCriterion("tailoring_time not in", values, "tailoringTime");
            return (Criteria) this;
        }

        public Criteria andTailoringTimeBetween(Integer value1, Integer value2) {
            addCriterion("tailoring_time between", value1, value2, "tailoringTime");
            return (Criteria) this;
        }

        public Criteria andTailoringTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("tailoring_time not between", value1, value2, "tailoringTime");
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