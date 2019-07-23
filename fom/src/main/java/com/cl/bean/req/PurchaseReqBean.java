package com.cl.bean.req;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName PurchaseReqBean
 * @Description TODO
 * @Author 陈龙
 * @Date 2019/7/22 16:38
 * @Version 1.0
 **/
public class PurchaseReqBean implements Serializable {

    private static final long serialVersionUID = 4258978832555303240L;

    /**
     * 采购单号
     */
    private String purchaseNumber;

    /**
     * 订单状态1:待采购 2:采购中 3:待裁剪 4:已裁剪
     */
    private String orderStatus;

    /**
     * 采购日期 (录入实采时期)
     */
    private String purchaseTime;

    /**
     * 物料分类
     */
    private String materielType;

}
