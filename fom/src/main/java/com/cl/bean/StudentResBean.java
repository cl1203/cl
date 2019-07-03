package com.cl.bean;

import java.io.Serializable;

/**
 * @ClassName StudentResBean
 * @Description student 返回bean
 * @Author 陈龙
 * @Date 2019/6/24 14:28
 * @Version 1.0
 **/
public class StudentResBean implements Serializable {

    private static final long serialVersionUID = -8586813408217549365L;

    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private String age;

    /**
     * 性别
     */
    private String sex;

    /**
     * 状态（0-删除，1-启用，2-禁用）
     */
    private String status;

    /**
     * 创建时间
     */
    private String createTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
