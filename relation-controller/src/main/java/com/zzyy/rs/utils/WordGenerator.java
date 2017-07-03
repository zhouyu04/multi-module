package com.zzyy.rs.utils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
/**
 * Created by Administrator on 2017/6/16 0016.
 */
public class WordGenerator {

    private static Configuration configuration = null;
    private static Map<String, Template> allTemplates = null;

//    static {
//        configuration = new Configuration();
//        configuration.setDefaultEncoding("utf-8");
//        configuration.setClassForTemplateLoading(WordGenerator.class, "/");
//        allTemplates = new HashMap<String, Template>();
//        try {
//            allTemplates.put("resume", configuration.getTemplate("湖南省攸县人民法院.ftl"));
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//    }

    private WordGenerator() {
        throw new AssertionError();
    }

    public static File createDoc(Map<String , Object> dataMap, String type) throws IOException {
        configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");
        String fileDirectory = "/";
        configuration.setClassForTemplateLoading(WordGenerator.class, fileDirectory);
        /** 加载模板 **/
        Template template = configuration.getTemplate("湖南省攸县人民法院.ftl");

        /** 指定输出word文件的路径 **/

        String name = "湖南省攸县人民法院" + (int) (Math.random() * 100000) + ".doc";
        File f = new File(name);
        FileOutputStream fos = new FileOutputStream(f);
        try {
            // 这个地方不能使用FileWriter因为需要指定编码类型否则生成的Word文档会因为有无法识别的编码而无法打开
            Writer w = new OutputStreamWriter(fos, "utf-8");
            template.process(dataMap, w);
            w.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return f;
    }
}
