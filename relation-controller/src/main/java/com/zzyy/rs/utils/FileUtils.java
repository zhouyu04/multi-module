package com.zzyy.rs.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/6/14 0014.
 */
public class FileUtils extends org.apache.commons.io.FileUtils {

    private static final Random JVM_RANDOM=new Random();
    private static final Map<String, DateFormat> DFS = new HashMap<String, DateFormat>();
    private static DateFormat getFormat(String pattern) {
        DateFormat format = DFS.get(pattern);
        if (format == null) {
            format = new SimpleDateFormat(pattern);
            DFS.put(pattern, format);
        }
        return format;
    }
    private static Date getNow(){
        return Calendar.getInstance().getTime();
    }
    /**
     * 是否存在
     * @param file
     * @return
     */
    public static boolean isExists(File file){
        return file!=null&&file.exists();
    }
    /**
     * 获取文件扩展名
     * @param fileName
     * @return
     */
    public static String getFileExtension(String fileName){
        int position = fileName.lastIndexOf(".");
        return fileName.substring(position);
    }
    /**
     * 获取日期结构的目录，如：2013-02/03
     * @param rootPath
     * @return
     * @throws IOException
     */
    public static String forceMkdirOfDate(String rootPath) throws IOException {
        String path=getFormat("yyyyMM"+File.separator+"dd").format(getNow());
        forceMkdir(new File(rootPath+File.separator+path));
        return path;
    }
    /**
     * @return
     */
    public static String getFileName(){

        return String.valueOf(System.currentTimeMillis())+Math.abs(JVM_RANDOM.nextInt());
    }
    /**
     * 保存文件到某文件夹
     * @param file
     * @param savePath  绝对路径
     * @param srcFileName   原文件名
     * @return  新文件名
     * @throws IOException
     */
    public static String saveFile(File file,String savePath,String srcFileName) throws IOException{
        String fileName=getFileName()+getFileExtension(srcFileName);
        InputStream is= new BufferedInputStream(new FileInputStream(file));
        OutputStream os= new BufferedOutputStream(new FileOutputStream(new File(savePath+File.separator+fileName)));
        try {
            int len = 0;
            byte[] buffer = new byte[500];
            while (-1 != (len = is.read(buffer))) {
                os.write(buffer, 0, len);
            }
            os.flush();
        } catch (IOException e) {
            throw e;
        }finally{
            close(is, os);
        }
        return fileName;
    }



    /**
     * 输出文件
     * @param file
     * @throws IOException
     */
    public static void outputFile(File file,OutputStream stream) throws IOException{
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        try {
            bis = new BufferedInputStream(new FileInputStream(file));
            bos = new BufferedOutputStream(stream);
            while ((bytesRead = bis.read(buffer, 0, 8192)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            bos.flush();
        } finally {
            bis.close();
            bos.close();
        }
    }
    /**
     *
     * @param file
     * @param fileName
     * @throws IOException
     */
    public static  void downloadFile(File file,String fileName,HttpServletResponse response) throws IOException{
        // 弹出下载对话框(以附件形式打开文件流)
        response.setContentType("APPLICATION/OCTET-STREAM; charset=UTF-8");
        response.setHeader("Content-disposition", "attachment;filename="+ fileName);
        OutputStream stream=response.getOutputStream();
        outputFile(file, stream);
    }

    public static void close(InputStream is,OutputStream os){
        if(is!=null){
            try {
                is.close();
            } catch (IOException e) {
            }
        }
        if(os!=null){
            try {
                os.close();
            } catch (IOException e) {
            }
        }
    }
}
