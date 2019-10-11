package com.cl.bean.req;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class OrderQuantityReqBean implements Serializable {

    private static final long serialVersionUID = -7841794638465335218L;

    /**
     * 尺寸
     */
    @ApiModelProperty(value = "尺寸")
    private String sizeName;

    /**
     * 数量
     */
    @ApiModelProperty(value = "数量")
    private String  quantity;

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
