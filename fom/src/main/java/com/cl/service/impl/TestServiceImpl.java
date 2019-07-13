package com.cl.service.impl;

import static java.util.stream.Collectors.groupingBy;
import com.cl.bean.req.StudentReqBean;
import com.cl.bean.res.StudentResBean;
import com.cl.comm.exception.BusinessException;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.transformer.IObjectTransformer;
import com.cl.dao.StudentMapper;
import com.cl.entity.StudentEntity;
import com.cl.service.ITestService;
import com.cl.util.DateUtils;
import com.cl.util.ExcelImportUtil;
import com.cl.util.ExcelUtils;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

/**
 * @ClassName TestServiceImpl
 * @Description 测试service 实现类
 * @Author 陈龙
 * @Date 2019/6/24 13:55
 * @Version 1.0
 **/
@Service
@Transactional
public class TestServiceImpl implements ITestService {

    /**
     *  日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TestServiceImpl.class);

    /**
     * student Mapper
     */
    @Resource
    private StudentMapper studentMapper;

    /**
     * student转换器
     */
    @Resource
    private IObjectTransformer<StudentEntity, StudentResBean> studentTransform;


    @Override
    public PageInfo<StudentResBean> queryStudentList(RequestBeanModel<StudentReqBean> requestBeanModel) {
        LOGGER.info("TestServiceImpl  queryStudentList  start");
        //页码校验
        varPage(requestBeanModel);
        //分页查询
        PageInfo<StudentEntity> studentEntityPageInfo = this.studentMapper.selectStudentEntityPage(requestBeanModel);
        //entity转bean
        PageInfo<StudentResBean> studentResBeanPageInfo = this.studentTransform.transform(studentEntityPageInfo);
        String a = null;
        /*if(1==1){
            Integer i = Integer.valueOf(a); //测试空指针异常
            if(2==2){
                throw new BusinessException(5555555 , "测试带code的自定义异常"); //测试带code的自定义异常
            }
            throw new BusinessException("测试不带code的异常");//测试不带code的异常
        }*/
        //测试sql异常
        //this.studentMapper.selectException(123);
        //Assert.isTrue(false , "异常2");
        LOGGER.info("TestServiceImpl  queryStudentList  end");
        return studentResBeanPageInfo;
    }

    private void varPage(RequestBeanModel<StudentReqBean> requestBeanModel){
        StudentReqBean studentReqBean = requestBeanModel.getReqData();
        Assert.notNull(studentReqBean.getPageNum() , "页码不能为空!");
        Assert.notNull(studentReqBean.getPageSize() , "每页数量不能为空!");
        if(studentReqBean.getPageNum() < 1 || studentReqBean.getPageSize() < 1){
            throw new BusinessException("页码信息错误,请填入大于0的整数!");
        }

    }

    @Override
    public void insertStudent(RequestBeanModel<StudentReqBean> requestBeanModel , String userId) {
        LOGGER.info("TestServiceImpl  insertStudent  start");
        StudentEntity studentEntity = new StudentEntity();
        //校验
        this.varStudentReqBean(requestBeanModel.getReqData());
        //bean转entity
        studentEntity = this.studentReqBeanToEntity(requestBeanModel.getReqData() , studentEntity , userId);
        //新增
        int i = this.studentMapper.insertSelective(studentEntity);
        Assert.isTrue(i > 0 , "新增学生失败!");
        LOGGER.info("TestServiceImpl  insertStudent  end");
    }

    /**
     * 校验studentReqBean
     * @param studentReqBean 新增bean
     */
    private void varStudentReqBean(StudentReqBean studentReqBean){
        LOGGER.info("TestServiceImpl  varStudentReqBean  start");
        if(!(studentReqBean.getSex().equals("男") || studentReqBean.getSex().equals("女"))){
            throw new BusinessException("性别只能是男或者女!");
        }
        if(StringUtils.isNotBlank(studentReqBean.getStatus())){
            if(!(studentReqBean.getStatus().equals("0")||studentReqBean.getStatus().equals("1")||studentReqBean.getStatus().equals("2"))){
                throw new BusinessException("选择的状态不存在!");
            }
        }
        LOGGER.info("TestServiceImpl  varStudentReqBean  end");
    }

    /**
     * 新增bean转entity
     * @param studentReqBean 新增bean
     * @param studentEntity entity
     * @param userId 用户id
     */
    private StudentEntity studentReqBeanToEntity(StudentReqBean studentReqBean , StudentEntity studentEntity , String userId){
        LOGGER.info("TestServiceImpl  studentReqBeanToEntity  start");
        studentEntity.setName(studentReqBean.getName());
        studentEntity.setAge(Integer.valueOf(studentReqBean.getAge()));
        studentEntity.setSex(studentReqBean.getSex());
        if(StringUtils.isNotBlank(studentReqBean.getStatus())){
            studentEntity.setStatus(Byte.valueOf(studentReqBean.getStatus()));
        }
        studentEntity.setCreateUser(userId);
        studentEntity.setLastUpdateUser(userId);
        LOGGER.info("TestServiceImpl  studentReqBeanToEntity  end");
        return studentEntity;
    }


    @Override
    public void exportStudent(HttpServletResponse response, RequestBeanModel<StudentReqBean> requestBeanModel) throws IOException {
        LOGGER.info("TestServiceImpl  exportStudent  start");
        StudentReqBean studentReqBean = new StudentReqBean();
        studentReqBean.setPageNum(1);
        studentReqBean.setPageSize(10000);
        //转码
        studentReqBean = this.decodeStudentReqBean(studentReqBean);
        PageInfo<StudentResBean> studentResBeanPageInfo = this.queryStudentList(requestBeanModel);
        List<StudentResBean> studentResBeanList = studentResBeanPageInfo.getList();
        LOGGER.info("studentResBeanList size: " + studentResBeanList.size());
        //表头
        String[] headers = {"姓名(name)" , "年龄(age)" , "性别(sex)" , "创建时间(createTime)"};
        //导出
        ExcelUtils.exportExcel("学生表" , headers , studentResBeanList , response , DateUtils.DATESHOWFORMAT);
        LOGGER.info("TestServiceImpl  exportStudent  end");
    }

    /**
     * 转码
     * @param studentReqBean 导出请求bean
     * @return 转码后的bean
     */
    private StudentReqBean decodeStudentReqBean(StudentReqBean studentReqBean){
        LOGGER.info("TestServiceImpl  decodeStudentReqBean  start");
        //编码
        final String UTF_8 = "UTF-8";
        try{
            if(StringUtils.isNotBlank(studentReqBean.getName())) {
                studentReqBean.setName(URLDecoder.decode(studentReqBean.getName() , UTF_8));
            }
            if(StringUtils.isNotBlank(studentReqBean.getAge())){
                studentReqBean.setAge(URLDecoder.decode(studentReqBean.getAge() , UTF_8));
            }
            if(StringUtils.isNotBlank(studentReqBean.getSex())){
                studentReqBean.setSex(URLDecoder.decode(studentReqBean.getSex() , UTF_8));
            }
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
            LOGGER.error("decoding exception" , e);
        }
        LOGGER.info("TestServiceImpl  decodeStudentReqBean  end");
        return studentReqBean;
    }

    @Override
    public int importStudent(HttpServletRequest request, HttpServletResponse response, String userId, MultipartFile excleFile) throws Exception {
        LOGGER.info("TestServiceImpl  importStudent  start");
        //检查上传的是否是EXCEL文件，以及EXCEL是否符合规则
        Workbook workbook = ExcelImportUtil.checkExcelFile(excleFile);
        //表头
        final String[] HEADCH = {"姓名" , "年龄" , "性别"};
        final String[] HEADSEH ={"name" , "age" , "sex"};
        //校验EXCEL表头是否符合模板
        ExcelImportUtil.checkExcelHead(workbook, HEADCH);
        //数据存放在List集合中
        List<StudentReqBean> studentReqBeanList = ExcelImportUtil.excelToBoList(workbook.getSheetAt(0), HEADSEH, StudentReqBean.class);
        Assert.notEmpty(studentReqBeanList, "Excel数据为空!");
        LOGGER.info("TestServiceImpl  importStudent  end");
        return this.checkExcelData(userId, studentReqBeanList);
    }

    /**
     * 校验导入Excel的数据 并导入
     * @param userId 用户ID
     * @param studentReqBeanList 导入数据
     * @return
     */
    private int checkExcelData(String userId , List<StudentReqBean> studentReqBeanList){
        LOGGER.info("TestServiceImpl  checkExcelData  start");
        //新增总数
        int sum[] = {0};
        studentReqBeanList.forEach(studentReqBean -> {
            //参数校验
            this.varStudentReqBean(studentReqBean);
            //导入校验
            this.varReqBean(studentReqBean);
            //新增bean转entity
            StudentEntity studentEntity = new StudentEntity();
            this.studentReqBeanToEntity(studentReqBean , studentEntity ,userId);
            //新增
            sum[0] += this.studentMapper.insertSelective(studentEntity);
        });
        //校验重复
        /*List<StudentReqBean> studentReqBeanListStream = studentReqBeanList.stream().filter(studentReqBean -> StringUtils.isNotBlank(studentReqBean.getName())).collect(Collectors.toList());
        Map<String , List<StudentReqBean>> stringListMap = studentReqBeanListStream.stream().collect(groupingBy(StudentReqBean :: getName));
        Assert.isTrue(studentReqBeanListStream.size() == stringListMap.size() , "Excel表中存在重复的姓名,请修改!");*/
        LOGGER.info("成功导入学生数据{}条" , sum[0]);
        LOGGER.info("TestServiceImpl  checkExcelData  end");
        return sum[0];
    }

    /**
     * 导入校验
     * @param studentReqBean 导入bean
     */
    private void varReqBean(StudentReqBean studentReqBean){
        //测试这些方法都能校验字符串是否为空
        //Assert.hasLength(studentReqBean.getName() , "姓名不能为空!");
        Assert.hasText(studentReqBean.getName() , "第" + studentReqBean.getRowNum() +"行,姓名不能为空!");
        /*if(StringUtils.isBlank(studentReqBean.getName())){
            throw new BusinessException("第" + studentReqBean.getRowNum() +"行,姓名不能为空!");
        }*/
        if(StringUtils.isBlank(studentReqBean.getAge())){
            throw new BusinessException("第" + studentReqBean.getRowNum() +"行,年龄不能为空!");
        }

    }
}
