package com.cl.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PurchaseEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public PurchaseEntityExample() {
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

        public Criteria andPurchaseNoIsNull() {
            addCriterion("purchase_no is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoIsNotNull() {
            addCriterion("purchase_no is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoEqualTo(String value) {
            addCriterion("purchase_no =", value, "purchaseNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoNotEqualTo(String value) {
            addCriterion("purchase_no <>", value, "purchaseNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoGreaterThan(String value) {
            addCriterion("purchase_no >", value, "purchaseNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoGreaterThanOrEqualTo(String value) {
            addCriterion("purchase_no >=", value, "purchaseNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoLessThan(String value) {
            addCriterion("purchase_no <", value, "purchaseNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoLessThanOrEqualTo(String value) {
            addCriterion("purchase_no <=", value, "purchaseNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoLike(String value) {
            addCriterion("purchase_no like", value, "purchaseNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoNotLike(String value) {
            addCriterion("purchase_no not like", value, "purchaseNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoIn(List<String> values) {
            addCriterion("purchase_no in", values, "purchaseNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoNotIn(List<String> values) {
            addCriterion("purchase_no not in", values, "purchaseNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoBetween(String value1, String value2) {
            addCriterion("purchase_no between", value1, value2, "purchaseNo");
            return (Criteria) this;
        }

        public Criteria andPurchaseNoNotBetween(String value1, String value2) {
            addCriterion("purchase_no not between", value1, value2, "purchaseNo");
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

        public Criteria andSupplierCodeIsNull() {
            addCriterion("supplier_code is null");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeIsNotNull() {
            addCriterion("supplier_code is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeEqualTo(String value) {
            addCriterion("supplier_code =", value, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeNotEqualTo(String value) {
            addCriterion("supplier_code <>", value, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeGreaterThan(String value) {
            addCriterion("supplier_code >", value, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeGreaterThanOrEqualTo(String value) {
            addCriterion("supplier_code >=", value, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeLessThan(String value) {
            addCriterion("supplier_code <", value, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeLessThanOrEqualTo(String value) {
            addCriterion("supplier_code <=", value, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeLike(String value) {
            addCriterion("supplier_code like", value, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeNotLike(String value) {
            addCriterion("supplier_code not like", value, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeIn(List<String> values) {
            addCriterion("supplier_code in", values, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeNotIn(List<String> values) {
            addCriterion("supplier_code not in", values, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeBetween(String value1, String value2) {
            addCriterion("supplier_code between", value1, value2, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeNotBetween(String value1, String value2) {
            addCriterion("supplier_code not between", value1, value2, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierColorNumberIsNull() {
            addCriterion("supplier_color_number is null");
            return (Criteria) this;
        }

        public Criteria andSupplierColorNumberIsNotNull() {
            addCriterion("supplier_color_number is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierColorNumberEqualTo(String value) {
            addCriterion("supplier_color_number =", value, "supplierColorNumber");
            return (Criteria) this;
        }

        public Criteria andSupplierColorNumberNotEqualTo(String value) {
            addCriterion("supplier_color_number <>", value, "supplierColorNumber");
            return (Criteria) this;
        }

        public Criteria andSupplierColorNumberGreaterThan(String value) {
            addCriterion("supplier_color_number >", value, "supplierColorNumber");
            return (Criteria) this;
        }

        public Criteria andSupplierColorNumberGreaterThanOrEqualTo(String value) {
            addCriterion("supplier_color_number >=", value, "supplierColorNumber");
            return (Criteria) this;
        }

        public Criteria andSupplierColorNumberLessThan(String value) {
            addCriterion("supplier_color_number <", value, "supplierColorNumber");
            return (Criteria) this;
        }

        public Criteria andSupplierColorNumberLessThanOrEqualTo(String value) {
            addCriterion("supplier_color_number <=", value, "supplierColorNumber");
            return (Criteria) this;
        }

        public Criteria andSupplierColorNumberLike(String value) {
            addCriterion("supplier_color_number like", value, "supplierColorNumber");
            return (Criteria) this;
        }

        public Criteria andSupplierColorNumberNotLike(String value) {
            addCriterion("supplier_color_number not like", value, "supplierColorNumber");
            return (Criteria) this;
        }

        public Criteria andSupplierColorNumberIn(List<String> values) {
            addCriterion("supplier_color_number in", values, "supplierColorNumber");
            return (Criteria) this;
        }

        public Criteria andSupplierColorNumberNotIn(List<String> values) {
            addCriterion("supplier_color_number not in", values, "supplierColorNumber");
            return (Criteria) this;
        }

        public Criteria andSupplierColorNumberBetween(String value1, String value2) {
            addCriterion("supplier_color_number between", value1, value2, "supplierColorNumber");
            return (Criteria) this;
        }

        public Criteria andSupplierColorNumberNotBetween(String value1, String value2) {
            addCriterion("supplier_color_number not between", value1, value2, "supplierColorNumber");
            return (Criteria) this;
        }

        public Criteria andPurchaseStatusIsNull() {
            addCriterion("purchase_status is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseStatusIsNotNull() {
            addCriterion("purchase_status is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseStatusEqualTo(Byte value) {
            addCriterion("purchase_status =", value, "purchaseStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseStatusNotEqualTo(Byte value) {
            addCriterion("purchase_status <>", value, "purchaseStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseStatusGreaterThan(Byte value) {
            addCriterion("purchase_status >", value, "purchaseStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("purchase_status >=", value, "purchaseStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseStatusLessThan(Byte value) {
            addCriterion("purchase_status <", value, "purchaseStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseStatusLessThanOrEqualTo(Byte value) {
            addCriterion("purchase_status <=", value, "purchaseStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseStatusIn(List<Byte> values) {
            addCriterion("purchase_status in", values, "purchaseStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseStatusNotIn(List<Byte> values) {
            addCriterion("purchase_status not in", values, "purchaseStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseStatusBetween(Byte value1, Byte value2) {
            addCriterion("purchase_status between", value1, value2, "purchaseStatus");
            return (Criteria) this;
        }

        public Criteria andPurchaseStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("purchase_status not between", value1, value2, "purchaseStatus");
            return (Criteria) this;
        }

        public Criteria andMaterielSkuIsNull() {
            addCriterion("materiel_sku is null");
            return (Criteria) this;
        }

        public Criteria andMaterielSkuIsNotNull() {
            addCriterion("materiel_sku is not null");
            return (Criteria) this;
        }

        public Criteria andMaterielSkuEqualTo(String value) {
            addCriterion("materiel_sku =", value, "materielSku");
            return (Criteria) this;
        }

        public Criteria andMaterielSkuNotEqualTo(String value) {
            addCriterion("materiel_sku <>", value, "materielSku");
            return (Criteria) this;
        }

        public Criteria andMaterielSkuGreaterThan(String value) {
            addCriterion("materiel_sku >", value, "materielSku");
            return (Criteria) this;
        }

        public Criteria andMaterielSkuGreaterThanOrEqualTo(String value) {
            addCriterion("materiel_sku >=", value, "materielSku");
            return (Criteria) this;
        }

        public Criteria andMaterielSkuLessThan(String value) {
            addCriterion("materiel_sku <", value, "materielSku");
            return (Criteria) this;
        }

        public Criteria andMaterielSkuLessThanOrEqualTo(String value) {
            addCriterion("materiel_sku <=", value, "materielSku");
            return (Criteria) this;
        }

        public Criteria andMaterielSkuLike(String value) {
            addCriterion("materiel_sku like", value, "materielSku");
            return (Criteria) this;
        }

        public Criteria andMaterielSkuNotLike(String value) {
            addCriterion("materiel_sku not like", value, "materielSku");
            return (Criteria) this;
        }

        public Criteria andMaterielSkuIn(List<String> values) {
            addCriterion("materiel_sku in", values, "materielSku");
            return (Criteria) this;
        }

        public Criteria andMaterielSkuNotIn(List<String> values) {
            addCriterion("materiel_sku not in", values, "materielSku");
            return (Criteria) this;
        }

        public Criteria andMaterielSkuBetween(String value1, String value2) {
            addCriterion("materiel_sku between", value1, value2, "materielSku");
            return (Criteria) this;
        }

        public Criteria andMaterielSkuNotBetween(String value1, String value2) {
            addCriterion("materiel_sku not between", value1, value2, "materielSku");
            return (Criteria) this;
        }

        public Criteria andMaterielTypeCodeIsNull() {
            addCriterion("materiel_type_code is null");
            return (Criteria) this;
        }

        public Criteria andMaterielTypeCodeIsNotNull() {
            addCriterion("materiel_type_code is not null");
            return (Criteria) this;
        }

        public Criteria andMaterielTypeCodeEqualTo(String value) {
            addCriterion("materiel_type_code =", value, "materielTypeCode");
            return (Criteria) this;
        }

        public Criteria andMaterielTypeCodeNotEqualTo(String value) {
            addCriterion("materiel_type_code <>", value, "materielTypeCode");
            return (Criteria) this;
        }

        public Criteria andMaterielTypeCodeGreaterThan(String value) {
            addCriterion("materiel_type_code >", value, "materielTypeCode");
            return (Criteria) this;
        }

        public Criteria andMaterielTypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("materiel_type_code >=", value, "materielTypeCode");
            return (Criteria) this;
        }

        public Criteria andMaterielTypeCodeLessThan(String value) {
            addCriterion("materiel_type_code <", value, "materielTypeCode");
            return (Criteria) this;
        }

        public Criteria andMaterielTypeCodeLessThanOrEqualTo(String value) {
            addCriterion("materiel_type_code <=", value, "materielTypeCode");
            return (Criteria) this;
        }

        public Criteria andMaterielTypeCodeLike(String value) {
            addCriterion("materiel_type_code like", value, "materielTypeCode");
            return (Criteria) this;
        }

        public Criteria andMaterielTypeCodeNotLike(String value) {
            addCriterion("materiel_type_code not like", value, "materielTypeCode");
            return (Criteria) this;
        }

        public Criteria andMaterielTypeCodeIn(List<String> values) {
            addCriterion("materiel_type_code in", values, "materielTypeCode");
            return (Criteria) this;
        }

        public Criteria andMaterielTypeCodeNotIn(List<String> values) {
            addCriterion("materiel_type_code not in", values, "materielTypeCode");
            return (Criteria) this;
        }

        public Criteria andMaterielTypeCodeBetween(String value1, String value2) {
            addCriterion("materiel_type_code between", value1, value2, "materielTypeCode");
            return (Criteria) this;
        }

        public Criteria andMaterielTypeCodeNotBetween(String value1, String value2) {
            addCriterion("materiel_type_code not between", value1, value2, "materielTypeCode");
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

        public Criteria andMaterielColorIsNull() {
            addCriterion("materiel_color is null");
            return (Criteria) this;
        }

        public Criteria andMaterielColorIsNotNull() {
            addCriterion("materiel_color is not null");
            return (Criteria) this;
        }

        public Criteria andMaterielColorEqualTo(String value) {
            addCriterion("materiel_color =", value, "materielColor");
            return (Criteria) this;
        }

        public Criteria andMaterielColorNotEqualTo(String value) {
            addCriterion("materiel_color <>", value, "materielColor");
            return (Criteria) this;
        }

        public Criteria andMaterielColorGreaterThan(String value) {
            addCriterion("materiel_color >", value, "materielColor");
            return (Criteria) this;
        }

        public Criteria andMaterielColorGreaterThanOrEqualTo(String value) {
            addCriterion("materiel_color >=", value, "materielColor");
            return (Criteria) this;
        }

        public Criteria andMaterielColorLessThan(String value) {
            addCriterion("materiel_color <", value, "materielColor");
            return (Criteria) this;
        }

        public Criteria andMaterielColorLessThanOrEqualTo(String value) {
            addCriterion("materiel_color <=", value, "materielColor");
            return (Criteria) this;
        }

        public Criteria andMaterielColorLike(String value) {
            addCriterion("materiel_color like", value, "materielColor");
            return (Criteria) this;
        }

        public Criteria andMaterielColorNotLike(String value) {
            addCriterion("materiel_color not like", value, "materielColor");
            return (Criteria) this;
        }

        public Criteria andMaterielColorIn(List<String> values) {
            addCriterion("materiel_color in", values, "materielColor");
            return (Criteria) this;
        }

        public Criteria andMaterielColorNotIn(List<String> values) {
            addCriterion("materiel_color not in", values, "materielColor");
            return (Criteria) this;
        }

        public Criteria andMaterielColorBetween(String value1, String value2) {
            addCriterion("materiel_color between", value1, value2, "materielColor");
            return (Criteria) this;
        }

        public Criteria andMaterielColorNotBetween(String value1, String value2) {
            addCriterion("materiel_color not between", value1, value2, "materielColor");
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

        public Criteria andSingleAmountKgIsNull() {
            addCriterion("single_amount_kg is null");
            return (Criteria) this;
        }

        public Criteria andSingleAmountKgIsNotNull() {
            addCriterion("single_amount_kg is not null");
            return (Criteria) this;
        }

        public Criteria andSingleAmountKgEqualTo(BigDecimal value) {
            addCriterion("single_amount_kg =", value, "singleAmountKg");
            return (Criteria) this;
        }

        public Criteria andSingleAmountKgNotEqualTo(BigDecimal value) {
            addCriterion("single_amount_kg <>", value, "singleAmountKg");
            return (Criteria) this;
        }

        public Criteria andSingleAmountKgGreaterThan(BigDecimal value) {
            addCriterion("single_amount_kg >", value, "singleAmountKg");
            return (Criteria) this;
        }

        public Criteria andSingleAmountKgGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("single_amount_kg >=", value, "singleAmountKg");
            return (Criteria) this;
        }

        public Criteria andSingleAmountKgLessThan(BigDecimal value) {
            addCriterion("single_amount_kg <", value, "singleAmountKg");
            return (Criteria) this;
        }

        public Criteria andSingleAmountKgLessThanOrEqualTo(BigDecimal value) {
            addCriterion("single_amount_kg <=", value, "singleAmountKg");
            return (Criteria) this;
        }

        public Criteria andSingleAmountKgIn(List<BigDecimal> values) {
            addCriterion("single_amount_kg in", values, "singleAmountKg");
            return (Criteria) this;
        }

        public Criteria andSingleAmountKgNotIn(List<BigDecimal> values) {
            addCriterion("single_amount_kg not in", values, "singleAmountKg");
            return (Criteria) this;
        }

        public Criteria andSingleAmountKgBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("single_amount_kg between", value1, value2, "singleAmountKg");
            return (Criteria) this;
        }

        public Criteria andSingleAmountKgNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("single_amount_kg not between", value1, value2, "singleAmountKg");
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

        public Criteria andIsExistAbnormalIsNull() {
            addCriterion("is_exist_abnormal is null");
            return (Criteria) this;
        }

        public Criteria andIsExistAbnormalIsNotNull() {
            addCriterion("is_exist_abnormal is not null");
            return (Criteria) this;
        }

        public Criteria andIsExistAbnormalEqualTo(Byte value) {
            addCriterion("is_exist_abnormal =", value, "isExistAbnormal");
            return (Criteria) this;
        }

        public Criteria andIsExistAbnormalNotEqualTo(Byte value) {
            addCriterion("is_exist_abnormal <>", value, "isExistAbnormal");
            return (Criteria) this;
        }

        public Criteria andIsExistAbnormalGreaterThan(Byte value) {
            addCriterion("is_exist_abnormal >", value, "isExistAbnormal");
            return (Criteria) this;
        }

        public Criteria andIsExistAbnormalGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_exist_abnormal >=", value, "isExistAbnormal");
            return (Criteria) this;
        }

        public Criteria andIsExistAbnormalLessThan(Byte value) {
            addCriterion("is_exist_abnormal <", value, "isExistAbnormal");
            return (Criteria) this;
        }

        public Criteria andIsExistAbnormalLessThanOrEqualTo(Byte value) {
            addCriterion("is_exist_abnormal <=", value, "isExistAbnormal");
            return (Criteria) this;
        }

        public Criteria andIsExistAbnormalIn(List<Byte> values) {
            addCriterion("is_exist_abnormal in", values, "isExistAbnormal");
            return (Criteria) this;
        }

        public Criteria andIsExistAbnormalNotIn(List<Byte> values) {
            addCriterion("is_exist_abnormal not in", values, "isExistAbnormal");
            return (Criteria) this;
        }

        public Criteria andIsExistAbnormalBetween(Byte value1, Byte value2) {
            addCriterion("is_exist_abnormal between", value1, value2, "isExistAbnormal");
            return (Criteria) this;
        }

        public Criteria andIsExistAbnormalNotBetween(Byte value1, Byte value2) {
            addCriterion("is_exist_abnormal not between", value1, value2, "isExistAbnormal");
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