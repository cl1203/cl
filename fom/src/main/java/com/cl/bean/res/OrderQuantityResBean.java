package com.cl.bean.res;

import java.io.Serializable;

/**
 * @ClassName OrderQuantityResBean
 * @Description TODO
 * @Author 陈龙
 * @Date 2019/7/24 13:57
 * @Version 1.0
 **/
public class OrderQuantityResBean implements Serializable {

    private static final long serialVersionUID = 5076755773086073615L;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 尺寸
     */
    private String sizeName;

    /**
     * 数量
     */
    private Integer quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
