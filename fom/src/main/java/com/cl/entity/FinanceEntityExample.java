package com.cl.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FinanceEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public FinanceEntityExample() {
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

        public Criteria andQuantityTotalIsNull() {
            addCriterion("quantity_total is null");
            return (Criteria) this;
        }

        public Criteria andQuantityTotalIsNotNull() {
            addCriterion("quantity_total is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityTotalEqualTo(Integer value) {
            addCriterion("quantity_total =", value, "quantityTotal");
            return (Criteria) this;
        }

        public Criteria andQuantityTotalNotEqualTo(Integer value) {
            addCriterion("quantity_total <>", value, "quantityTotal");
            return (Criteria) this;
        }

        public Criteria andQuantityTotalGreaterThan(Integer value) {
            addCriterion("quantity_total >", value, "quantityTotal");
            return (Criteria) this;
        }

        public Criteria andQuantityTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("quantity_total >=", value, "quantityTotal");
            return (Criteria) this;
        }

        public Criteria andQuantityTotalLessThan(Integer value) {
            addCriterion("quantity_total <", value, "quantityTotal");
            return (Criteria) this;
        }

        public Criteria andQuantityTotalLessThanOrEqualTo(Integer value) {
            addCriterion("quantity_total <=", value, "quantityTotal");
            return (Criteria) this;
        }

        public Criteria andQuantityTotalIn(List<Integer> values) {
            addCriterion("quantity_total in", values, "quantityTotal");
            return (Criteria) this;
        }

        public Criteria andQuantityTotalNotIn(List<Integer> values) {
            addCriterion("quantity_total not in", values, "quantityTotal");
            return (Criteria) this;
        }

        public Criteria andQuantityTotalBetween(Integer value1, Integer value2) {
            addCriterion("quantity_total between", value1, value2, "quantityTotal");
            return (Criteria) this;
        }

        public Criteria andQuantityTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("quantity_total not between", value1, value2, "quantityTotal");
            return (Criteria) this;
        }

        public Criteria andFlatcarPriceIsNull() {
            addCriterion("flatcar_price is null");
            return (Criteria) this;
        }

        public Criteria andFlatcarPriceIsNotNull() {
            addCriterion("flatcar_price is not null");
            return (Criteria) this;
        }

        public Criteria andFlatcarPriceEqualTo(BigDecimal value) {
            addCriterion("flatcar_price =", value, "flatcarPrice");
            return (Criteria) this;
        }

        public Criteria andFlatcarPriceNotEqualTo(BigDecimal value) {
            addCriterion("flatcar_price <>", value, "flatcarPrice");
            return (Criteria) this;
        }

        public Criteria andFlatcarPriceGreaterThan(BigDecimal value) {
            addCriterion("flatcar_price >", value, "flatcarPrice");
            return (Criteria) this;
        }

        public Criteria andFlatcarPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("flatcar_price >=", value, "flatcarPrice");
            return (Criteria) this;
        }

        public Criteria andFlatcarPriceLessThan(BigDecimal value) {
            addCriterion("flatcar_price <", value, "flatcarPrice");
            return (Criteria) this;
        }

        public Criteria andFlatcarPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("flatcar_price <=", value, "flatcarPrice");
            return (Criteria) this;
        }

        public Criteria andFlatcarPriceIn(List<BigDecimal> values) {
            addCriterion("flatcar_price in", values, "flatcarPrice");
            return (Criteria) this;
        }

        public Criteria andFlatcarPriceNotIn(List<BigDecimal> values) {
            addCriterion("flatcar_price not in", values, "flatcarPrice");
            return (Criteria) this;
        }

        public Criteria andFlatcarPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("flatcar_price between", value1, value2, "flatcarPrice");
            return (Criteria) this;
        }

        public Criteria andFlatcarPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("flatcar_price not between", value1, value2, "flatcarPrice");
            return (Criteria) this;
        }

        public Criteria andFlatcarUserIsNull() {
            addCriterion("flatcar_user is null");
            return (Criteria) this;
        }

        public Criteria andFlatcarUserIsNotNull() {
            addCriterion("flatcar_user is not null");
            return (Criteria) this;
        }

        public Criteria andFlatcarUserEqualTo(String value) {
            addCriterion("flatcar_user =", value, "flatcarUser");
            return (Criteria) this;
        }

        public Criteria andFlatcarUserNotEqualTo(String value) {
            addCriterion("flatcar_user <>", value, "flatcarUser");
            return (Criteria) this;
        }

        public Criteria andFlatcarUserGreaterThan(String value) {
            addCriterion("flatcar_user >", value, "flatcarUser");
            return (Criteria) this;
        }

        public Criteria andFlatcarUserGreaterThanOrEqualTo(String value) {
            addCriterion("flatcar_user >=", value, "flatcarUser");
            return (Criteria) this;
        }

        public Criteria andFlatcarUserLessThan(String value) {
            addCriterion("flatcar_user <", value, "flatcarUser");
            return (Criteria) this;
        }

        public Criteria andFlatcarUserLessThanOrEqualTo(String value) {
            addCriterion("flatcar_user <=", value, "flatcarUser");
            return (Criteria) this;
        }

        public Criteria andFlatcarUserLike(String value) {
            addCriterion("flatcar_user like", value, "flatcarUser");
            return (Criteria) this;
        }

        public Criteria andFlatcarUserNotLike(String value) {
            addCriterion("flatcar_user not like", value, "flatcarUser");
            return (Criteria) this;
        }

        public Criteria andFlatcarUserIn(List<String> values) {
            addCriterion("flatcar_user in", values, "flatcarUser");
            return (Criteria) this;
        }

        public Criteria andFlatcarUserNotIn(List<String> values) {
            addCriterion("flatcar_user not in", values, "flatcarUser");
            return (Criteria) this;
        }

        public Criteria andFlatcarUserBetween(String value1, String value2) {
            addCriterion("flatcar_user between", value1, value2, "flatcarUser");
            return (Criteria) this;
        }

        public Criteria andFlatcarUserNotBetween(String value1, String value2) {
            addCriterion("flatcar_user not between", value1, value2, "flatcarUser");
            return (Criteria) this;
        }

        public Criteria andCartPriceIsNull() {
            addCriterion("cart_price is null");
            return (Criteria) this;
        }

        public Criteria andCartPriceIsNotNull() {
            addCriterion("cart_price is not null");
            return (Criteria) this;
        }

        public Criteria andCartPriceEqualTo(BigDecimal value) {
            addCriterion("cart_price =", value, "cartPrice");
            return (Criteria) this;
        }

        public Criteria andCartPriceNotEqualTo(BigDecimal value) {
            addCriterion("cart_price <>", value, "cartPrice");
            return (Criteria) this;
        }

        public Criteria andCartPriceGreaterThan(BigDecimal value) {
            addCriterion("cart_price >", value, "cartPrice");
            return (Criteria) this;
        }

        public Criteria andCartPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cart_price >=", value, "cartPrice");
            return (Criteria) this;
        }

        public Criteria andCartPriceLessThan(BigDecimal value) {
            addCriterion("cart_price <", value, "cartPrice");
            return (Criteria) this;
        }

        public Criteria andCartPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cart_price <=", value, "cartPrice");
            return (Criteria) this;
        }

        public Criteria andCartPriceIn(List<BigDecimal> values) {
            addCriterion("cart_price in", values, "cartPrice");
            return (Criteria) this;
        }

        public Criteria andCartPriceNotIn(List<BigDecimal> values) {
            addCriterion("cart_price not in", values, "cartPrice");
            return (Criteria) this;
        }

        public Criteria andCartPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cart_price between", value1, value2, "cartPrice");
            return (Criteria) this;
        }

        public Criteria andCartPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cart_price not between", value1, value2, "cartPrice");
            return (Criteria) this;
        }

        public Criteria andCartUserIsNull() {
            addCriterion("cart_user is null");
            return (Criteria) this;
        }

        public Criteria andCartUserIsNotNull() {
            addCriterion("cart_user is not null");
            return (Criteria) this;
        }

        public Criteria andCartUserEqualTo(String value) {
            addCriterion("cart_user =", value, "cartUser");
            return (Criteria) this;
        }

        public Criteria andCartUserNotEqualTo(String value) {
            addCriterion("cart_user <>", value, "cartUser");
            return (Criteria) this;
        }

        public Criteria andCartUserGreaterThan(String value) {
            addCriterion("cart_user >", value, "cartUser");
            return (Criteria) this;
        }

        public Criteria andCartUserGreaterThanOrEqualTo(String value) {
            addCriterion("cart_user >=", value, "cartUser");
            return (Criteria) this;
        }

        public Criteria andCartUserLessThan(String value) {
            addCriterion("cart_user <", value, "cartUser");
            return (Criteria) this;
        }

        public Criteria andCartUserLessThanOrEqualTo(String value) {
            addCriterion("cart_user <=", value, "cartUser");
            return (Criteria) this;
        }

        public Criteria andCartUserLike(String value) {
            addCriterion("cart_user like", value, "cartUser");
            return (Criteria) this;
        }

        public Criteria andCartUserNotLike(String value) {
            addCriterion("cart_user not like", value, "cartUser");
            return (Criteria) this;
        }

        public Criteria andCartUserIn(List<String> values) {
            addCriterion("cart_user in", values, "cartUser");
            return (Criteria) this;
        }

        public Criteria andCartUserNotIn(List<String> values) {
            addCriterion("cart_user not in", values, "cartUser");
            return (Criteria) this;
        }

        public Criteria andCartUserBetween(String value1, String value2) {
            addCriterion("cart_user between", value1, value2, "cartUser");
            return (Criteria) this;
        }

        public Criteria andCartUserNotBetween(String value1, String value2) {
            addCriterion("cart_user not between", value1, value2, "cartUser");
            return (Criteria) this;
        }

        public Criteria andEdgersPriceIsNull() {
            addCriterion("edgers_price is null");
            return (Criteria) this;
        }

        public Criteria andEdgersPriceIsNotNull() {
            addCriterion("edgers_price is not null");
            return (Criteria) this;
        }

        public Criteria andEdgersPriceEqualTo(BigDecimal value) {
            addCriterion("edgers_price =", value, "edgersPrice");
            return (Criteria) this;
        }

        public Criteria andEdgersPriceNotEqualTo(BigDecimal value) {
            addCriterion("edgers_price <>", value, "edgersPrice");
            return (Criteria) this;
        }

        public Criteria andEdgersPriceGreaterThan(BigDecimal value) {
            addCriterion("edgers_price >", value, "edgersPrice");
            return (Criteria) this;
        }

        public Criteria andEdgersPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("edgers_price >=", value, "edgersPrice");
            return (Criteria) this;
        }

        public Criteria andEdgersPriceLessThan(BigDecimal value) {
            addCriterion("edgers_price <", value, "edgersPrice");
            return (Criteria) this;
        }

        public Criteria andEdgersPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("edgers_price <=", value, "edgersPrice");
            return (Criteria) this;
        }

        public Criteria andEdgersPriceIn(List<BigDecimal> values) {
            addCriterion("edgers_price in", values, "edgersPrice");
            return (Criteria) this;
        }

        public Criteria andEdgersPriceNotIn(List<BigDecimal> values) {
            addCriterion("edgers_price not in", values, "edgersPrice");
            return (Criteria) this;
        }

        public Criteria andEdgersPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("edgers_price between", value1, value2, "edgersPrice");
            return (Criteria) this;
        }

        public Criteria andEdgersPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("edgers_price not between", value1, value2, "edgersPrice");
            return (Criteria) this;
        }

        public Criteria andEdgersUserIsNull() {
            addCriterion("edgers_user is null");
            return (Criteria) this;
        }

        public Criteria andEdgersUserIsNotNull() {
            addCriterion("edgers_user is not null");
            return (Criteria) this;
        }

        public Criteria andEdgersUserEqualTo(String value) {
            addCriterion("edgers_user =", value, "edgersUser");
            return (Criteria) this;
        }

        public Criteria andEdgersUserNotEqualTo(String value) {
            addCriterion("edgers_user <>", value, "edgersUser");
            return (Criteria) this;
        }

        public Criteria andEdgersUserGreaterThan(String value) {
            addCriterion("edgers_user >", value, "edgersUser");
            return (Criteria) this;
        }

        public Criteria andEdgersUserGreaterThanOrEqualTo(String value) {
            addCriterion("edgers_user >=", value, "edgersUser");
            return (Criteria) this;
        }

        public Criteria andEdgersUserLessThan(String value) {
            addCriterion("edgers_user <", value, "edgersUser");
            return (Criteria) this;
        }

        public Criteria andEdgersUserLessThanOrEqualTo(String value) {
            addCriterion("edgers_user <=", value, "edgersUser");
            return (Criteria) this;
        }

        public Criteria andEdgersUserLike(String value) {
            addCriterion("edgers_user like", value, "edgersUser");
            return (Criteria) this;
        }

        public Criteria andEdgersUserNotLike(String value) {
            addCriterion("edgers_user not like", value, "edgersUser");
            return (Criteria) this;
        }

        public Criteria andEdgersUserIn(List<String> values) {
            addCriterion("edgers_user in", values, "edgersUser");
            return (Criteria) this;
        }

        public Criteria andEdgersUserNotIn(List<String> values) {
            addCriterion("edgers_user not in", values, "edgersUser");
            return (Criteria) this;
        }

        public Criteria andEdgersUserBetween(String value1, String value2) {
            addCriterion("edgers_user between", value1, value2, "edgersUser");
            return (Criteria) this;
        }

        public Criteria andEdgersUserNotBetween(String value1, String value2) {
            addCriterion("edgers_user not between", value1, value2, "edgersUser");
            return (Criteria) this;
        }

        public Criteria andGreatIroningPriceIsNull() {
            addCriterion("great_ironing_price is null");
            return (Criteria) this;
        }

        public Criteria andGreatIroningPriceIsNotNull() {
            addCriterion("great_ironing_price is not null");
            return (Criteria) this;
        }

        public Criteria andGreatIroningPriceEqualTo(BigDecimal value) {
            addCriterion("great_ironing_price =", value, "greatIroningPrice");
            return (Criteria) this;
        }

        public Criteria andGreatIroningPriceNotEqualTo(BigDecimal value) {
            addCriterion("great_ironing_price <>", value, "greatIroningPrice");
            return (Criteria) this;
        }

        public Criteria andGreatIroningPriceGreaterThan(BigDecimal value) {
            addCriterion("great_ironing_price >", value, "greatIroningPrice");
            return (Criteria) this;
        }

        public Criteria andGreatIroningPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("great_ironing_price >=", value, "greatIroningPrice");
            return (Criteria) this;
        }

        public Criteria andGreatIroningPriceLessThan(BigDecimal value) {
            addCriterion("great_ironing_price <", value, "greatIroningPrice");
            return (Criteria) this;
        }

        public Criteria andGreatIroningPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("great_ironing_price <=", value, "greatIroningPrice");
            return (Criteria) this;
        }

        public Criteria andGreatIroningPriceIn(List<BigDecimal> values) {
            addCriterion("great_ironing_price in", values, "greatIroningPrice");
            return (Criteria) this;
        }

        public Criteria andGreatIroningPriceNotIn(List<BigDecimal> values) {
            addCriterion("great_ironing_price not in", values, "greatIroningPrice");
            return (Criteria) this;
        }

        public Criteria andGreatIroningPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("great_ironing_price between", value1, value2, "greatIroningPrice");
            return (Criteria) this;
        }

        public Criteria andGreatIroningPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("great_ironing_price not between", value1, value2, "greatIroningPrice");
            return (Criteria) this;
        }

        public Criteria andGreatIroningUserIsNull() {
            addCriterion("great_ironing_user is null");
            return (Criteria) this;
        }

        public Criteria andGreatIroningUserIsNotNull() {
            addCriterion("great_ironing_user is not null");
            return (Criteria) this;
        }

        public Criteria andGreatIroningUserEqualTo(String value) {
            addCriterion("great_ironing_user =", value, "greatIroningUser");
            return (Criteria) this;
        }

        public Criteria andGreatIroningUserNotEqualTo(String value) {
            addCriterion("great_ironing_user <>", value, "greatIroningUser");
            return (Criteria) this;
        }

        public Criteria andGreatIroningUserGreaterThan(String value) {
            addCriterion("great_ironing_user >", value, "greatIroningUser");
            return (Criteria) this;
        }

        public Criteria andGreatIroningUserGreaterThanOrEqualTo(String value) {
            addCriterion("great_ironing_user >=", value, "greatIroningUser");
            return (Criteria) this;
        }

        public Criteria andGreatIroningUserLessThan(String value) {
            addCriterion("great_ironing_user <", value, "greatIroningUser");
            return (Criteria) this;
        }

        public Criteria andGreatIroningUserLessThanOrEqualTo(String value) {
            addCriterion("great_ironing_user <=", value, "greatIroningUser");
            return (Criteria) this;
        }

        public Criteria andGreatIroningUserLike(String value) {
            addCriterion("great_ironing_user like", value, "greatIroningUser");
            return (Criteria) this;
        }

        public Criteria andGreatIroningUserNotLike(String value) {
            addCriterion("great_ironing_user not like", value, "greatIroningUser");
            return (Criteria) this;
        }

        public Criteria andGreatIroningUserIn(List<String> values) {
            addCriterion("great_ironing_user in", values, "greatIroningUser");
            return (Criteria) this;
        }

        public Criteria andGreatIroningUserNotIn(List<String> values) {
            addCriterion("great_ironing_user not in", values, "greatIroningUser");
            return (Criteria) this;
        }

        public Criteria andGreatIroningUserBetween(String value1, String value2) {
            addCriterion("great_ironing_user between", value1, value2, "greatIroningUser");
            return (Criteria) this;
        }

        public Criteria andGreatIroningUserNotBetween(String value1, String value2) {
            addCriterion("great_ironing_user not between", value1, value2, "greatIroningUser");
            return (Criteria) this;
        }

        public Criteria andCheckGoodsPriceIsNull() {
            addCriterion("check_goods_price is null");
            return (Criteria) this;
        }

        public Criteria andCheckGoodsPriceIsNotNull() {
            addCriterion("check_goods_price is not null");
            return (Criteria) this;
        }

        public Criteria andCheckGoodsPriceEqualTo(BigDecimal value) {
            addCriterion("check_goods_price =", value, "checkGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andCheckGoodsPriceNotEqualTo(BigDecimal value) {
            addCriterion("check_goods_price <>", value, "checkGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andCheckGoodsPriceGreaterThan(BigDecimal value) {
            addCriterion("check_goods_price >", value, "checkGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andCheckGoodsPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("check_goods_price >=", value, "checkGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andCheckGoodsPriceLessThan(BigDecimal value) {
            addCriterion("check_goods_price <", value, "checkGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andCheckGoodsPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("check_goods_price <=", value, "checkGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andCheckGoodsPriceIn(List<BigDecimal> values) {
            addCriterion("check_goods_price in", values, "checkGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andCheckGoodsPriceNotIn(List<BigDecimal> values) {
            addCriterion("check_goods_price not in", values, "checkGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andCheckGoodsPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("check_goods_price between", value1, value2, "checkGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andCheckGoodsPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("check_goods_price not between", value1, value2, "checkGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andCheckGoodsUserIsNull() {
            addCriterion("check_goods_user is null");
            return (Criteria) this;
        }

        public Criteria andCheckGoodsUserIsNotNull() {
            addCriterion("check_goods_user is not null");
            return (Criteria) this;
        }

        public Criteria andCheckGoodsUserEqualTo(String value) {
            addCriterion("check_goods_user =", value, "checkGoodsUser");
            return (Criteria) this;
        }

        public Criteria andCheckGoodsUserNotEqualTo(String value) {
            addCriterion("check_goods_user <>", value, "checkGoodsUser");
            return (Criteria) this;
        }

        public Criteria andCheckGoodsUserGreaterThan(String value) {
            addCriterion("check_goods_user >", value, "checkGoodsUser");
            return (Criteria) this;
        }

        public Criteria andCheckGoodsUserGreaterThanOrEqualTo(String value) {
            addCriterion("check_goods_user >=", value, "checkGoodsUser");
            return (Criteria) this;
        }

        public Criteria andCheckGoodsUserLessThan(String value) {
            addCriterion("check_goods_user <", value, "checkGoodsUser");
            return (Criteria) this;
        }

        public Criteria andCheckGoodsUserLessThanOrEqualTo(String value) {
            addCriterion("check_goods_user <=", value, "checkGoodsUser");
            return (Criteria) this;
        }

        public Criteria andCheckGoodsUserLike(String value) {
            addCriterion("check_goods_user like", value, "checkGoodsUser");
            return (Criteria) this;
        }

        public Criteria andCheckGoodsUserNotLike(String value) {
            addCriterion("check_goods_user not like", value, "checkGoodsUser");
            return (Criteria) this;
        }

        public Criteria andCheckGoodsUserIn(List<String> values) {
            addCriterion("check_goods_user in", values, "checkGoodsUser");
            return (Criteria) this;
        }

        public Criteria andCheckGoodsUserNotIn(List<String> values) {
            addCriterion("check_goods_user not in", values, "checkGoodsUser");
            return (Criteria) this;
        }

        public Criteria andCheckGoodsUserBetween(String value1, String value2) {
            addCriterion("check_goods_user between", value1, value2, "checkGoodsUser");
            return (Criteria) this;
        }

        public Criteria andCheckGoodsUserNotBetween(String value1, String value2) {
            addCriterion("check_goods_user not between", value1, value2, "checkGoodsUser");
            return (Criteria) this;
        }

        public Criteria andTrimmingPriceIsNull() {
            addCriterion("trimming_price is null");
            return (Criteria) this;
        }

        public Criteria andTrimmingPriceIsNotNull() {
            addCriterion("trimming_price is not null");
            return (Criteria) this;
        }

        public Criteria andTrimmingPriceEqualTo(BigDecimal value) {
            addCriterion("trimming_price =", value, "trimmingPrice");
            return (Criteria) this;
        }

        public Criteria andTrimmingPriceNotEqualTo(BigDecimal value) {
            addCriterion("trimming_price <>", value, "trimmingPrice");
            return (Criteria) this;
        }

        public Criteria andTrimmingPriceGreaterThan(BigDecimal value) {
            addCriterion("trimming_price >", value, "trimmingPrice");
            return (Criteria) this;
        }

        public Criteria andTrimmingPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("trimming_price >=", value, "trimmingPrice");
            return (Criteria) this;
        }

        public Criteria andTrimmingPriceLessThan(BigDecimal value) {
            addCriterion("trimming_price <", value, "trimmingPrice");
            return (Criteria) this;
        }

        public Criteria andTrimmingPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("trimming_price <=", value, "trimmingPrice");
            return (Criteria) this;
        }

        public Criteria andTrimmingPriceIn(List<BigDecimal> values) {
            addCriterion("trimming_price in", values, "trimmingPrice");
            return (Criteria) this;
        }

        public Criteria andTrimmingPriceNotIn(List<BigDecimal> values) {
            addCriterion("trimming_price not in", values, "trimmingPrice");
            return (Criteria) this;
        }

        public Criteria andTrimmingPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("trimming_price between", value1, value2, "trimmingPrice");
            return (Criteria) this;
        }

        public Criteria andTrimmingPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("trimming_price not between", value1, value2, "trimmingPrice");
            return (Criteria) this;
        }

        public Criteria andTrimmingUserIsNull() {
            addCriterion("trimming_user is null");
            return (Criteria) this;
        }

        public Criteria andTrimmingUserIsNotNull() {
            addCriterion("trimming_user is not null");
            return (Criteria) this;
        }

        public Criteria andTrimmingUserEqualTo(String value) {
            addCriterion("trimming_user =", value, "trimmingUser");
            return (Criteria) this;
        }

        public Criteria andTrimmingUserNotEqualTo(String value) {
            addCriterion("trimming_user <>", value, "trimmingUser");
            return (Criteria) this;
        }

        public Criteria andTrimmingUserGreaterThan(String value) {
            addCriterion("trimming_user >", value, "trimmingUser");
            return (Criteria) this;
        }

        public Criteria andTrimmingUserGreaterThanOrEqualTo(String value) {
            addCriterion("trimming_user >=", value, "trimmingUser");
            return (Criteria) this;
        }

        public Criteria andTrimmingUserLessThan(String value) {
            addCriterion("trimming_user <", value, "trimmingUser");
            return (Criteria) this;
        }

        public Criteria andTrimmingUserLessThanOrEqualTo(String value) {
            addCriterion("trimming_user <=", value, "trimmingUser");
            return (Criteria) this;
        }

        public Criteria andTrimmingUserLike(String value) {
            addCriterion("trimming_user like", value, "trimmingUser");
            return (Criteria) this;
        }

        public Criteria andTrimmingUserNotLike(String value) {
            addCriterion("trimming_user not like", value, "trimmingUser");
            return (Criteria) this;
        }

        public Criteria andTrimmingUserIn(List<String> values) {
            addCriterion("trimming_user in", values, "trimmingUser");
            return (Criteria) this;
        }

        public Criteria andTrimmingUserNotIn(List<String> values) {
            addCriterion("trimming_user not in", values, "trimmingUser");
            return (Criteria) this;
        }

        public Criteria andTrimmingUserBetween(String value1, String value2) {
            addCriterion("trimming_user between", value1, value2, "trimmingUser");
            return (Criteria) this;
        }

        public Criteria andTrimmingUserNotBetween(String value1, String value2) {
            addCriterion("trimming_user not between", value1, value2, "trimmingUser");
            return (Criteria) this;
        }

        public Criteria andPackagingPriceIsNull() {
            addCriterion("packaging_price is null");
            return (Criteria) this;
        }

        public Criteria andPackagingPriceIsNotNull() {
            addCriterion("packaging_price is not null");
            return (Criteria) this;
        }

        public Criteria andPackagingPriceEqualTo(BigDecimal value) {
            addCriterion("packaging_price =", value, "packagingPrice");
            return (Criteria) this;
        }

        public Criteria andPackagingPriceNotEqualTo(BigDecimal value) {
            addCriterion("packaging_price <>", value, "packagingPrice");
            return (Criteria) this;
        }

        public Criteria andPackagingPriceGreaterThan(BigDecimal value) {
            addCriterion("packaging_price >", value, "packagingPrice");
            return (Criteria) this;
        }

        public Criteria andPackagingPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("packaging_price >=", value, "packagingPrice");
            return (Criteria) this;
        }

        public Criteria andPackagingPriceLessThan(BigDecimal value) {
            addCriterion("packaging_price <", value, "packagingPrice");
            return (Criteria) this;
        }

        public Criteria andPackagingPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("packaging_price <=", value, "packagingPrice");
            return (Criteria) this;
        }

        public Criteria andPackagingPriceIn(List<BigDecimal> values) {
            addCriterion("packaging_price in", values, "packagingPrice");
            return (Criteria) this;
        }

        public Criteria andPackagingPriceNotIn(List<BigDecimal> values) {
            addCriterion("packaging_price not in", values, "packagingPrice");
            return (Criteria) this;
        }

        public Criteria andPackagingPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("packaging_price between", value1, value2, "packagingPrice");
            return (Criteria) this;
        }

        public Criteria andPackagingPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("packaging_price not between", value1, value2, "packagingPrice");
            return (Criteria) this;
        }

        public Criteria andPackagingUserIsNull() {
            addCriterion("packaging_user is null");
            return (Criteria) this;
        }

        public Criteria andPackagingUserIsNotNull() {
            addCriterion("packaging_user is not null");
            return (Criteria) this;
        }

        public Criteria andPackagingUserEqualTo(String value) {
            addCriterion("packaging_user =", value, "packagingUser");
            return (Criteria) this;
        }

        public Criteria andPackagingUserNotEqualTo(String value) {
            addCriterion("packaging_user <>", value, "packagingUser");
            return (Criteria) this;
        }

        public Criteria andPackagingUserGreaterThan(String value) {
            addCriterion("packaging_user >", value, "packagingUser");
            return (Criteria) this;
        }

        public Criteria andPackagingUserGreaterThanOrEqualTo(String value) {
            addCriterion("packaging_user >=", value, "packagingUser");
            return (Criteria) this;
        }

        public Criteria andPackagingUserLessThan(String value) {
            addCriterion("packaging_user <", value, "packagingUser");
            return (Criteria) this;
        }

        public Criteria andPackagingUserLessThanOrEqualTo(String value) {
            addCriterion("packaging_user <=", value, "packagingUser");
            return (Criteria) this;
        }

        public Criteria andPackagingUserLike(String value) {
            addCriterion("packaging_user like", value, "packagingUser");
            return (Criteria) this;
        }

        public Criteria andPackagingUserNotLike(String value) {
            addCriterion("packaging_user not like", value, "packagingUser");
            return (Criteria) this;
        }

        public Criteria andPackagingUserIn(List<String> values) {
            addCriterion("packaging_user in", values, "packagingUser");
            return (Criteria) this;
        }

        public Criteria andPackagingUserNotIn(List<String> values) {
            addCriterion("packaging_user not in", values, "packagingUser");
            return (Criteria) this;
        }

        public Criteria andPackagingUserBetween(String value1, String value2) {
            addCriterion("packaging_user between", value1, value2, "packagingUser");
            return (Criteria) this;
        }

        public Criteria andPackagingUserNotBetween(String value1, String value2) {
            addCriterion("packaging_user not between", value1, value2, "packagingUser");
            return (Criteria) this;
        }

        public Criteria andReworkPriceIsNull() {
            addCriterion("rework_price is null");
            return (Criteria) this;
        }

        public Criteria andReworkPriceIsNotNull() {
            addCriterion("rework_price is not null");
            return (Criteria) this;
        }

        public Criteria andReworkPriceEqualTo(BigDecimal value) {
            addCriterion("rework_price =", value, "reworkPrice");
            return (Criteria) this;
        }

        public Criteria andReworkPriceNotEqualTo(BigDecimal value) {
            addCriterion("rework_price <>", value, "reworkPrice");
            return (Criteria) this;
        }

        public Criteria andReworkPriceGreaterThan(BigDecimal value) {
            addCriterion("rework_price >", value, "reworkPrice");
            return (Criteria) this;
        }

        public Criteria andReworkPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rework_price >=", value, "reworkPrice");
            return (Criteria) this;
        }

        public Criteria andReworkPriceLessThan(BigDecimal value) {
            addCriterion("rework_price <", value, "reworkPrice");
            return (Criteria) this;
        }

        public Criteria andReworkPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rework_price <=", value, "reworkPrice");
            return (Criteria) this;
        }

        public Criteria andReworkPriceIn(List<BigDecimal> values) {
            addCriterion("rework_price in", values, "reworkPrice");
            return (Criteria) this;
        }

        public Criteria andReworkPriceNotIn(List<BigDecimal> values) {
            addCriterion("rework_price not in", values, "reworkPrice");
            return (Criteria) this;
        }

        public Criteria andReworkPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rework_price between", value1, value2, "reworkPrice");
            return (Criteria) this;
        }

        public Criteria andReworkPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rework_price not between", value1, value2, "reworkPrice");
            return (Criteria) this;
        }

        public Criteria andReworkUserIsNull() {
            addCriterion("rework_user is null");
            return (Criteria) this;
        }

        public Criteria andReworkUserIsNotNull() {
            addCriterion("rework_user is not null");
            return (Criteria) this;
        }

        public Criteria andReworkUserEqualTo(String value) {
            addCriterion("rework_user =", value, "reworkUser");
            return (Criteria) this;
        }

        public Criteria andReworkUserNotEqualTo(String value) {
            addCriterion("rework_user <>", value, "reworkUser");
            return (Criteria) this;
        }

        public Criteria andReworkUserGreaterThan(String value) {
            addCriterion("rework_user >", value, "reworkUser");
            return (Criteria) this;
        }

        public Criteria andReworkUserGreaterThanOrEqualTo(String value) {
            addCriterion("rework_user >=", value, "reworkUser");
            return (Criteria) this;
        }

        public Criteria andReworkUserLessThan(String value) {
            addCriterion("rework_user <", value, "reworkUser");
            return (Criteria) this;
        }

        public Criteria andReworkUserLessThanOrEqualTo(String value) {
            addCriterion("rework_user <=", value, "reworkUser");
            return (Criteria) this;
        }

        public Criteria andReworkUserLike(String value) {
            addCriterion("rework_user like", value, "reworkUser");
            return (Criteria) this;
        }

        public Criteria andReworkUserNotLike(String value) {
            addCriterion("rework_user not like", value, "reworkUser");
            return (Criteria) this;
        }

        public Criteria andReworkUserIn(List<String> values) {
            addCriterion("rework_user in", values, "reworkUser");
            return (Criteria) this;
        }

        public Criteria andReworkUserNotIn(List<String> values) {
            addCriterion("rework_user not in", values, "reworkUser");
            return (Criteria) this;
        }

        public Criteria andReworkUserBetween(String value1, String value2) {
            addCriterion("rework_user between", value1, value2, "reworkUser");
            return (Criteria) this;
        }

        public Criteria andReworkUserNotBetween(String value1, String value2) {
            addCriterion("rework_user not between", value1, value2, "reworkUser");
            return (Criteria) this;
        }

        public Criteria andOtherPriceIsNull() {
            addCriterion("other_price is null");
            return (Criteria) this;
        }

        public Criteria andOtherPriceIsNotNull() {
            addCriterion("other_price is not null");
            return (Criteria) this;
        }

        public Criteria andOtherPriceEqualTo(BigDecimal value) {
            addCriterion("other_price =", value, "otherPrice");
            return (Criteria) this;
        }

        public Criteria andOtherPriceNotEqualTo(BigDecimal value) {
            addCriterion("other_price <>", value, "otherPrice");
            return (Criteria) this;
        }

        public Criteria andOtherPriceGreaterThan(BigDecimal value) {
            addCriterion("other_price >", value, "otherPrice");
            return (Criteria) this;
        }

        public Criteria andOtherPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("other_price >=", value, "otherPrice");
            return (Criteria) this;
        }

        public Criteria andOtherPriceLessThan(BigDecimal value) {
            addCriterion("other_price <", value, "otherPrice");
            return (Criteria) this;
        }

        public Criteria andOtherPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("other_price <=", value, "otherPrice");
            return (Criteria) this;
        }

        public Criteria andOtherPriceIn(List<BigDecimal> values) {
            addCriterion("other_price in", values, "otherPrice");
            return (Criteria) this;
        }

        public Criteria andOtherPriceNotIn(List<BigDecimal> values) {
            addCriterion("other_price not in", values, "otherPrice");
            return (Criteria) this;
        }

        public Criteria andOtherPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other_price between", value1, value2, "otherPrice");
            return (Criteria) this;
        }

        public Criteria andOtherPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other_price not between", value1, value2, "otherPrice");
            return (Criteria) this;
        }

        public Criteria andOtherUserIsNull() {
            addCriterion("other_user is null");
            return (Criteria) this;
        }

        public Criteria andOtherUserIsNotNull() {
            addCriterion("other_user is not null");
            return (Criteria) this;
        }

        public Criteria andOtherUserEqualTo(String value) {
            addCriterion("other_user =", value, "otherUser");
            return (Criteria) this;
        }

        public Criteria andOtherUserNotEqualTo(String value) {
            addCriterion("other_user <>", value, "otherUser");
            return (Criteria) this;
        }

        public Criteria andOtherUserGreaterThan(String value) {
            addCriterion("other_user >", value, "otherUser");
            return (Criteria) this;
        }

        public Criteria andOtherUserGreaterThanOrEqualTo(String value) {
            addCriterion("other_user >=", value, "otherUser");
            return (Criteria) this;
        }

        public Criteria andOtherUserLessThan(String value) {
            addCriterion("other_user <", value, "otherUser");
            return (Criteria) this;
        }

        public Criteria andOtherUserLessThanOrEqualTo(String value) {
            addCriterion("other_user <=", value, "otherUser");
            return (Criteria) this;
        }

        public Criteria andOtherUserLike(String value) {
            addCriterion("other_user like", value, "otherUser");
            return (Criteria) this;
        }

        public Criteria andOtherUserNotLike(String value) {
            addCriterion("other_user not like", value, "otherUser");
            return (Criteria) this;
        }

        public Criteria andOtherUserIn(List<String> values) {
            addCriterion("other_user in", values, "otherUser");
            return (Criteria) this;
        }

        public Criteria andOtherUserNotIn(List<String> values) {
            addCriterion("other_user not in", values, "otherUser");
            return (Criteria) this;
        }

        public Criteria andOtherUserBetween(String value1, String value2) {
            addCriterion("other_user between", value1, value2, "otherUser");
            return (Criteria) this;
        }

        public Criteria andOtherUserNotBetween(String value1, String value2) {
            addCriterion("other_user not between", value1, value2, "otherUser");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("`status` not between", value1, value2, "status");
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