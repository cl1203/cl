package com.cl.service;

import com.cl.bean.req.StudentReqBean;
import com.cl.bean.res.StudentResBean;
import com.cl.comm.model.RequestBeanModel;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName ITestService
 * @Description 测试service
 * @Author 陈龙
 * @Date 2019/6/24 13:55
 * @Version 1.0
 **/
public interface ITestService {

    /*
     * @Author 陈龙
     * @Description 查询student列表
     * @Date 14:18 2019/6/24
     * @Param [pageNum, PageSize, name] 页码  每页数量 姓名
     * @return com.github.pagehelper.PageInfo<com.cl.om.entity.StudentEntity> 查询之后分页结果
     **/
    PageInfo<StudentResBean> queryStudentList(RequestBeanModel<StudentReqBean> requestBeanModel);

    /**
     * @Author 陈龙
     * @Description 单个新增
     * @Date 14:26 2019/6/29
     * @Param [studentReqBean, userId] 新增请求bean  用户ID
     * @return void
     **/
    void insertStudent(RequestBeanModel<StudentReqBean> requestBeanModel, String userId);

    /**
     * @Author 陈龙
     * @Description 导出
     * @Date 14:26 2019/6/29
     * @Param [response, studentReqBean] 响应体 查询请求bean
     * @return void
     **/
    void exportStudent(HttpServletResponse response, RequestBeanModel<StudentReqBean> requestBeanModel)throws IOException;

    /**
     * @Author 陈龙
     * @Description 导入
     * @Date 21:13 2019/6/29
     * @Param [request, response, userId, excleFile] 请求体 响应体  用户ID 文件
     * @return void
     **/
    int importStudent(HttpServletRequest request, HttpServletResponse response, String userId, MultipartFile excleFile)throws Exception;
}
