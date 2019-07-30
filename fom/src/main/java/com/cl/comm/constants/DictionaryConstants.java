package com.cl.comm.constants;

/**
 * @ClassName DictionaryConstants
 * @Description 数据字典公共编码
 * @Author 陈龙
 * @Date 2019/7/22 16:53
 * @Version 1.0
 **/
public class DictionaryConstants {

    //业务需要
    public static final Integer ALL_BUSINESS_ZERO = 0;
    public static final Integer ALL_BUSINESS_ONE = 1;
    public static final Byte ORDER_STATUS_DELETED = 0;//已删除
    public static final Byte ORDER_STATUS_WAIT_PURCHASE = 1;//待采购
    public static final Byte ORDER_STATUS_ALREADY_PURCHASE= 2; //采购中
    public static final Byte ORDER_STATUS_WAIT_TAILOR = 3; //待裁剪
    public static final Byte ORDER_STATUS_ALREADY_TAILOR = 4; //已裁剪

    public static final long H = 1000 * 60 * 60;//date计算  单位:小时
    public static final String MATERIELCODE = "materiel_type";//物料类型

}