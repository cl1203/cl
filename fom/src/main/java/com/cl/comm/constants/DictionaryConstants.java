package com.cl.comm.constants;

/**
 * @ClassName DictionaryConstants
 * @Description 数据字典公共编码
 * @Author 陈龙
 * @Date 2019/7/22 16:53
 * @Version 1.0
 **/
public enum DictionaryConstants {

    MATERIEL_TYPE_FABRIC("1" , "面料"),
    MATERIEL_TYPE_ACCESSORIES("2" , "辅料");
    /**
     * <p>
     * Field code: 字典编码
     * </p>
     */
    private String code;

    /**
     * <p>
     * Field msg: 字典描述
     * </p>
     */
    private String msg;

    /**
     * <p>
     * Description: 构造函数
     * </p>
     *
     * @param code
     *            字典编码
     * @param msg
     *            字典描述
     */
    private DictionaryConstants(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
