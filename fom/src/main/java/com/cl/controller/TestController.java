package com.cl.controller;

import com.cl.bean.req.StudentReqBean;
import com.cl.bean.res.StudentResBean;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.ResponseBeanModel;
import com.cl.service.ITestService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;


/**
 * @ClassName TestController
 * @Description 测试controller
 * @Author 陈龙
 * @Date 2019/6/24 13:55
 * @Version 1.0
 **/
@RestController
@RequestMapping("/test")
@CrossOrigin
@Api(description = "测试接口")
public class TestController {

    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    /**
     * 测试service
     */
    @Resource
    private ITestService iStudentService;

    /**
     * @Author 陈龙
     * @Description 查询student列表
     * @Date 14:19 2019/6/24
     * @Param [pageNum, pageSize, name] 页码  每页数量 姓名
     * @return com.github.pagehelper.PageInfo<com.cl.om.entity.StudentEntity> 查询之后分页结果
     **/
    @PostMapping("/selectStudent")
    @ApiOperation(value = "测试查询接口" , notes = "根据条件查询学生")
    public ResponseBeanModel<PageInfo<StudentResBean>> queryStudentList(@RequestBody RequestBeanModel<StudentReqBean> requestBeanModel){
        LOGGER.info("TestController  queryStudentList  start" );
        PageInfo<StudentResBean> studentResBeanPageInfo = iStudentService.queryStudentList(requestBeanModel);
        LOGGER.info("TestController  queryStudentList  end" );
        return new ResponseBeanModel<>(studentResBeanPageInfo);
    }

    /**
     * @Author 陈龙
     * @Description 单个新增
     * @Date 14:24 2019/6/29
     * @Param [studentReqBean] 新增请求bean
     * @return com.cl.om.comm.model.ResponseBeanModel<java.lang.Void>
     **/
    @PostMapping("/insertStudent")
    @ApiOperation(value = "测试新增接口" , notes = "根据传参新增学生")
    public ResponseBeanModel<Void> insertStudent(@RequestBody @Valid RequestBeanModel<StudentReqBean> requestBeanModel){
        LOGGER.info("TestController  insertStudent  start" );
        this.iStudentService.insertStudent(requestBeanModel , requestBeanModel.getUserId());
        LOGGER.info("TestController  insertStudent  end" );
        return new ResponseBeanModel<>("新增成功");
    }

    /**
     * @Author 陈龙
     * @Description 导出
     * @Date 14:28 2019/6/29
     * @Param [response, studentReqBean] 响应体  查询请求bean
     * @return com.cl.om.comm.model.ResponseBeanModel<java.lang.Void>
     **/
    @GetMapping("/exportStudent")
    @ApiOperation(value = "测试导出接口" , notes = "根据传参导出学生")
    public ResponseBeanModel<Void> exportStudent(HttpServletResponse response , RequestBeanModel<StudentReqBean> requestBeanModel )throws IOException{
        LOGGER.info("TestController  exportStudent  start" );
        this.iStudentService.exportStudent(response , requestBeanModel);
        LOGGER.info("TestController  exportStudent  end" );
        return new ResponseBeanModel<>("导出成功");
    }

    /**
     * @Author 陈龙
     * @Description 导入
     * @Date 21:27 2019/6/29
     * @Param [request, response, excleFile] 请求体 响应体 文件
     * @return com.cl.om.comm.model.ResponseBeanModel<java.lang.Void>
     **/
    @PostMapping("/importStudent")
    @ApiOperation(value = "测试导入接口" , notes = "导入学生")
    public ResponseBeanModel<Void> importStudent(HttpServletRequest request , HttpServletResponse response , @RequestParam MultipartFile excleFile , @RequestParam String userId)throws Exception{
        LOGGER.info("TestController  importStudent  start" );
        int i = this.iStudentService.importStudent(request , response , userId , excleFile);
        LOGGER.info("TestController  importStudent  end" );
        return new ResponseBeanModel<>("成功导入: " + i + "条数据");
    }

}
