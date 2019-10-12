package com.cl.controller;

import com.cl.util.FtpFileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/ftpFile")
@CrossOrigin
@Api(description = "ftp上传")
public class FtpFileUploadController {

    @PostMapping("/uploadImg")
    @ApiOperation(value = "上传图片" , notes = "上传图片")
    public String uploadImg(@RequestParam("file")MultipartFile file)throws IOException{
        String fileName = file.getOriginalFilename();
        InputStream input = file.getInputStream();
        String filePath = null;

        Boolean flag = FtpFileUtil.uploadFile(fileName , input);
        if(flag == true){
            System.out.println("上传成功!");
            filePath = fileName;
        }
        return filePath;
    }
}
