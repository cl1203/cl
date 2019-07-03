package com.cl.comm.transformer;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @ClassName AbstractObjectTransformer
 * @Description 默认实现列表转换器
 * @Author 陈龙
 * @Date 2019/6/24 15:03
 * @Version 1.0
 **/
public abstract class AbstractObjectTransformer<F, T> implements IObjectTransformer<F, T> {
    @Override
    public List<T> transform(List<F> froms) {
        List<T> results = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(froms)) {
            for (F from : froms) {
                results.add(transform(from));
            }
        }
        return results;
    }

    @Override
    public PageInfo<T> transform(PageInfo<F> froms) {
        if (froms == null) {
            return new PageInfo<T>();
        }
        PageInfo<T> result = new PageInfo<>(transform(froms.getList()));
        result.setEndRow(froms.getEndRow());
        result.setHasNextPage(froms.isHasNextPage());
        result.setHasPreviousPage(froms.isHasPreviousPage());
        result.setIsFirstPage(froms.isIsFirstPage());
        result.setIsLastPage(froms.isIsLastPage());
        result.setNavigatepageNums(froms.getNavigatepageNums());
        result.setNextPage(froms.getNextPage());
        result.setNavigatePages(froms.getNavigatePages());
        result.setPageNum(froms.getPageNum());
        result.setPages(froms.getPages());
        result.setPageSize(froms.getPageSize());
        result.setPrePage(froms.getPrePage());
        result.setSize(froms.getSize());
        result.setStartRow(froms.getStartRow());
        result.setTotal(froms.getTotal());
        return result;
    }
}
