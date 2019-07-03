package com.cl.comm.model;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.StringJoiner;

import static org.springframework.http.HttpStatus.OK;

/**
 * @ClassName ResponseBeanModel
 * @Description 标准响应体
 * 解决程序中很多需要压制unchecked和rawtypes警告的问题
 * 不再使用静态方法，而是用构造方法来区分。
 * @Author 陈龙
 * @Date 2019/6/26 10:43
 * @Version 1.0
 **/
public class ResponseBeanModel<T> implements Serializable {

    private static final long serialVersionUID = -4281751508454359433L;
    /**
     * 状态码
     */
    private Integer repCode = OK.value();
    /**
     * 状态信息
     */
    private String repMsg = OK.getReasonPhrase();
    /**
     * 对象
     */
    private T repData;

    /**
     * 默认构造方法,不常用
     * 返回200，OK
     */
    public ResponseBeanModel() {
    }

    /**
     * 构造方法，用来给客户端返回一条成功消息（比如操作成功，删除成功等）
     * 建议此时该类的泛型设置为{@link Void}
     *
     * @param repMsg 成功消息
     */
    public ResponseBeanModel(String repMsg) {
        this.repMsg = repMsg;
    }

    /**
     * 用来返回成功的数据（不建议泛型设置为{@link String}）
     *
     * @param repData 返回给客户端的数据
     */
    public ResponseBeanModel(T repData) {
        this.repData = repData;
    }

    /**
     * 通常用不到
     * 返回一个标准http状态{@link HttpStatus}
     *
     * @param status http状态
     */
    public ResponseBeanModel(HttpStatus status) {
        this.repCode = status.value();
        this.repMsg = status.getReasonPhrase();
    }


    public ResponseBeanModel(Integer repCode, String repMsg) {
        this(repCode, repMsg, null);
    }

    /**
     * 完全构造方法，通常用不到
     *
     * @param repCode 状态码
     * @param repMsg  消息
     * @param repData 信息
     */
    public ResponseBeanModel(Integer repCode, String repMsg, T repData) {
        this.repCode = repCode;
        this.repMsg = repMsg;
        this.repData = repData;
    }

    public Integer getRepCode() {
        return repCode;
    }

    public void setRepCode(Integer repCode) {
        this.repCode = repCode;
    }

    public String getRepMsg() {
        return repMsg;
    }

    public void setRepMsg(String repMsg) {
        this.repMsg = repMsg;
    }

    public T getRepData() {
        return repData;
    }

    public void setRepData(T repData) {
        this.repData = repData;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ResponseBeanModel.class.getSimpleName() + "[", "]")
                .add("repCode=" + repCode)
                .add("repMsg='" + repMsg + "'")
                .add("repData=" + repData)
                .toString();
    }
}
