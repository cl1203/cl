package com.cl.dao;

import com.cl.bean.res.PulldownMenuResBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName PulldownMenuMapper
 * @Description 获取下拉菜单dao
 * @Author 陈龙
 * @Date 2019/7/20 19:16
 * @Version 1.0
 **/
@Repository
public interface PulldownMenuMapper {

    List<PulldownMenuResBean> queryOrgPulldownMenu();
}
