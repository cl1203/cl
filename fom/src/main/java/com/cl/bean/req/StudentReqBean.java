package com.cl.bean.req;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @ClassName StudentReqBean
 * @Description student 请求bean
 * @Author 陈龙
 * @Date 2019/6/24 14:56
 * @Version 1.0
 **/
public class StudentReqBean implements Serializable {

    private static final long serialVersionUID = 7324447759325247820L;
    /**
     * 姓名
     */
    @NotBlank(message = "姓名不能为空!")
    @Length(max = 32 , message = "姓名最大长度为32")
    @ApiModelProperty(value = "姓名")
    private String name;

    /**
     * 年龄
     */
    @NotBlank(message = "年龄不能为空!")
    @Pattern(regexp = "^([0-9]|[0-9]{2}|100)$" , message = "年龄必须在0-100之间")
    @ApiModelProperty(value = "年龄")
    private String age;

    /**
     * 性别
     */
    @NotBlank(message = "性别不能为空!")
    @ApiModelProperty(value = "性别")
    private String sex;

    /**
     * 状态（0-删除，1-启用，2-禁用）
     */
    @NotBlank(message = "状态不能为空!")
    @ApiModelProperty(value = "状态")
    private String status;

    /**
     * 导出数量
     */
    @ApiModelProperty(value = "导出数量&查询每页数量")
    private Integer pageSize;
    /**
     * 导出页码
     */
    @ApiModelProperty(value = "导出页码&查询页码")
    private Integer pageNum;

    /**
     * <p>Field rowNum: 行(导入工具类需要)</p>
     */
    private int rowNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }
}
