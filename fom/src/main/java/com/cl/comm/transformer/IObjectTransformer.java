package com.cl.comm.transformer;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @ClassName IObjectTransformer
 * @Description 对象转换器
 * @Author 陈龙
 * @Date 2019/6/24 14:38
 * @Version 1.0
 **/
public interface IObjectTransformer<F , T>{
    /**
     * 单个对象转换
     * @param object :转换前的对象
     * @return 返回转换后的对象
     */
    T transform(F object);

    /**
     * 列表转换
     *
     * @param objects : 转换前的对象
     * @return 返回转换后的对象
     */
    List<T> transform(List<F> objects);

    /**
     * 分页列表转换
     *
     * @param objects : 转换前的对象
     * @return 返回转换后的对象
     */
    PageInfo<T> transform(PageInfo<F> objects);
}
