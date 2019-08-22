package org.dcowl.utils;
import java.util.*;
import java.io.*;
import freemarker.template.*;

public class HelloFreeMarker{

    private Configuration cfg;

    public void init() throws Exception{
        //初始化FreeMarker配置
        //创建一个Configuration实例
        cfg = new Configuration();
        //设置FreeMarker的模版文件位置
        cfg.setDirectoryForTemplateLoading(new File("templates"));
    }

    public void process()throws Exception{
        Map root = new HashMap();
        root.put("name", "FreeMarker!");
        root.put("msg" , "您已经完成了第一个FreeMarker的示例");
        Template t = cfg.getTemplate("test.ftl");
        t.process(root, new OutputStreamWriter(System.out));
    }

    public static void main(String[] args)throws Exception{
        HelloFreeMarker hf = new HelloFreeMarker();
        hf.init();
        hf.process();
    }
}