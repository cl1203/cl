package com.cl.bean.res;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class ImgResBean implements Serializable {

    private static final long serialVersionUID = 8150705509529414939L;

    @ApiModelProperty(value = "图片路径")
    private String imgPath;                           //图片路径

    @ApiModelProperty(value = "图片前缀")
    private String imgPrefix;                         //图片前缀

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getImgPrefix() {
        return imgPrefix;
    }

    public void setImgPrefix(String imgPrefix) {
        this.imgPrefix = imgPrefix;
    }
}
