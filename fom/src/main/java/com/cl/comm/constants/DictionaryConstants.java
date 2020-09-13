package com.cl.comm.constants;

import com.cl.comm.model.TokenInfo;

import java.util.HashMap;

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
    public static final Byte AVAILABLE = 1;//可用
    public static final Byte ORDER_STATUS_DELETED = 0;//已删除
    public static final Byte ORDER_STATUS_WAIT_PURCHASE = 1;//待采购
    public static final Byte ORDER_STATUS_ALREADY_PURCHASE= 2; //采购中
    public static final Byte ORDER_STATUS_WAIT_TAILOR = 3; //待裁剪
    public static final Byte ORDER_STATUS_ALREADY_TAILOR = 4; //已裁剪

    public static final long H = 1000 * 60 * 60;//date计算  单位:小时
    public static final String MATERIELCODE = "materiel_type";//物料类型

    public static final Byte DETELE = 0;//已删除
    public static final String PASS_WORD = "12345678";//默认密码

    public static final Integer ADMIN_ORG_ID = 1;//超级管理员组织ID
    public static final Integer PASSWORD_MIN = 8;//密码最短长度
    public static final Integer PASSWORD_MAX = 20;//密码最长长度
    public static final Integer PAGE_SIZE = 10000;//导出10000条

    //权限类型
    public static final Byte PERMISSION_TYPE_ZERO = 0;
    public static final Byte PERMISSION_TYPE_ONE = 1;
    public static final Byte PERMISSION_TYPE_TWO = 2;
    public static final Byte PERMISSION_TYPE_THREE = 3;

    /**
     * 通用失败状态码
     */
    public final static Integer failCode = 55555;

    /**
     *当前登陆的token以及时间
     */
    public  static HashMap<String,TokenInfo> currentLoginTokenMap = new HashMap<>();

    /**
     * 登陆时间有效性 30 分钟 = 30*60*1000
     */
    public static long loginUserfulTime = 1000 * 60 * 30;
    //订单类型
    public static final String ORDER_TPYE_FOB = "FOB";
    public static final String ORDER_TPYE_CMT = "新CMT";

    public static final String MAX_IMG_SIZE = "10485760";
    public static final String URL = "http://39.108.52.48/img";
}
