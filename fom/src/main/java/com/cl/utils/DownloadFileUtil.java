package com.cl.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class DownloadFileUtil {


    public static HttpServletResponse download(String path, HttpServletResponse response) {
        OutputStream toClient=null;
        InputStream fis = null;
        try {
            // path是指欲下载的文件的路径。
            File file = new File(path);
            // 取得文件名。
            String filename = file.getName();
            // 取得文件的后缀名。
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

            // 以流的形式下载文件。
             fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }finally {
            if (toClient!=null){
                try {
                    toClient.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if (fis!=null){
                try {
                    fis.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return response;
    }
}
