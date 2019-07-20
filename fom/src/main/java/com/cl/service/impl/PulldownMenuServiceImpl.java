package com.cl.service.impl;

import com.cl.bean.res.PulldownMenuResBean;
import com.cl.dao.PulldownMenuMapper;
import com.cl.service.IPulldownMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName PulldownMenuServiceImpl
 * @Description 获取下拉菜单 实现类
 * @Author 陈龙
 * @Date 2019/7/20 19:11
 * @Version 1.0
 **/
@Service
@Transactional
public class PulldownMenuServiceImpl implements IPulldownMenuService{

    @Resource
    private PulldownMenuMapper pulldownMenuMapper;

    @Override
    public List<PulldownMenuResBean> queryOrgPulldownMenu() {
        List<PulldownMenuResBean> pulldownMenuResBeanList = this.pulldownMenuMapper.queryOrgPulldownMenu();
        return pulldownMenuResBeanList;
    }
}
