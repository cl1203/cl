package com.cl.bean.res;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @ClassName DictItem
 * @Description TODO
 * @Author 陈龙
 * @Date 2019/7/24 16:11
 * @Version 1.0
 **/
public class DictItem implements Serializable {

    private static final long serialVersionUID = -4524638731560307880L;

    /**
     * <p>
     * Field bizCode: 字典类型
     * </p>
     */
    @ApiModelProperty(value = "类型")
    @NotBlank(message = "字典类型不能为空!")
    private String type;

    /**
     * <p>
     * Field bizCode: 字典编码
     * </p>
     */
    @ApiModelProperty(value = "编码")
    private String code;

    /**
     * <p>
     * Field bizText: 字典文案
     * </p>
     */
    @ApiModelProperty(value = "值")
    private String value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
