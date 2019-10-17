package com.cl.controller;

import com.cl.aop.LoggerManage;
import com.cl.bean.res.ImgResBean;
import com.cl.comm.constants.DictionaryConstants;
import com.cl.comm.exception.BusinessException;
import com.cl.comm.model.ResponseBeanModel;
import com.cl.config.CommonConfig;
import com.cl.util.FtpFileUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/ftpFile")
@CrossOrigin
@Api(description = "ftp上传")
public class FtpFileUploadController {


    @PostMapping("/uploadImg")
    @ApiOperation(value = "上传图片" , notes = "上传图片")
    public ResponseBeanModel<ImgResBean> uploadImgs(@RequestParam("file")MultipartFile file)throws IOException{
        //判断导入文件是否为空
        if(file.isEmpty()) {
            return new ResponseBeanModel<>("上传图片不能为空！");
        }
        //判断导入文件大小
        if (file.getSize() > Long.valueOf(DictionaryConstants.MAX_IMG_SIZE)) {
            throw new BusinessException("上传的图片大小不能超过10M！");
        }
        String fileName = file.getOriginalFilename();
        if (fileName.indexOf(" ") > 0) {
            throw new BusinessException("文件名不能包含空格！请修改图片名称后重新上传！");
        }
        InputStream inputStream=file.getInputStream();
        String filePath = null;

        Boolean flag= FtpFileUtils.uploadFile(fileName,inputStream);
        if(flag == true){
            filePath = fileName;
        }
        ImgResBean imgResBean = new ImgResBean();
        imgResBean.setImgPath(filePath);
        imgResBean.setImgPrefix(DictionaryConstants.URL);
        return new ResponseBeanModel<>(imgResBean);  //该路径图片名称，前端框架可用ngnix指定的路径+filePath,即可访问到ngnix图片服务器中的图片
    }
}
