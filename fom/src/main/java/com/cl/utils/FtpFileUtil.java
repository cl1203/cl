package com.cl.utils;

import com.cl.comm.exception.BusinessException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

public class FtpFileUtil {

    private static final Logger LOG = LoggerFactory.getLogger(FtpFileUtil.class);

    //ftp服务器ip地址
    private static final String FTP_ADDRESS = "120.24.207.170";
    //端口号
    private static final int FTP_PORT = 21;
    //用户名
    private static final String FTP_USERNAME = "root";
    //密码
    private static final String FTP_PASSWORD = "ChenLong1203";
    //图片路径
    private static final String FTP_BASEPATH = "/home/www/site/img";

    public  static boolean uploadFile(MultipartFile file , String fileName ){
        boolean success = false;
        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("UTF-8");
        try {
            InputStream input = file.getInputStream();
            int reply;
            ftp.connect(FTP_ADDRESS, FTP_PORT);// 连接FTP服务器
            ftp.login(FTP_USERNAME, FTP_PASSWORD);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.makeDirectory(FTP_BASEPATH );// 不存在才会执行这行代码 创建
            success = ftp.changeWorkingDirectory(FTP_BASEPATH );//切换到path下的文件夹下
            if(!success){
                throw new BusinessException("切换目录失败!");
            }
            ftp.enterLocalPassiveMode();
            boolean flag  = ftp.storeFile(new String(fileName.getBytes("UTF-8"),"iso-8859-1"),input);
            LOG.info("upload file: " + flag);
            input.close();
            ftp.logout();
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return success;
    }

}
