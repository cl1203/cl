package com.cl.util;

import com.cl.comm.constants.DictionaryConstants;
import com.cl.comm.exception.BusinessException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.io.InputStream;

public class FtpFileUtils {

    //ftp服务器ip地址
    private static final String FTP_ADDRESS = "120.24.207.170";
    //端口号
    private static final int FTP_PORT = 21;
    //用户名
    private static final String FTP_USERNAME = "ftpuser";
    //密码
    private static final String FTP_PASSWORD = "ftpuser";
    //图片路径
    private static final String FTP_BASEPATH = "site/img";

    public  static boolean uploadFile(String originFileName,InputStream input){
        boolean success = false;
        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("GBK");
        try {
            int reply;
            ftp.connect(FTP_ADDRESS, FTP_PORT);// 连接FTP服务器
            ftp.login(FTP_USERNAME, FTP_PASSWORD);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.makeDirectory(FTP_BASEPATH );// 不存在才会执行这行代码
            ftp.changeWorkingDirectory(FTP_BASEPATH );//切换到path下的文件夹下
            ftp.storeFile(originFileName,input);
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
