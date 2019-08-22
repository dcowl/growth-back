package org.dcowl.utils;

import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 项目读取配置文件工具类
 * 
 * @author <a href="mailto:2867665887@qq.com">DCOWL</a>
 * @version 1.0
 * @since 1.8.0_131
 */
public class PropertiesUtils {

    private static Properties props;

    /**
     * 加载配置文件
     *
     * @param fileName
     */
    private static void readProperties(String fileName) {
        try {
            props = new Properties();
            InputStreamReader inputStream = new InputStreamReader(PropertiesUtils.class.getClassLoader().getResourceAsStream(fileName), "UTF-8");
            props.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 根据key读取对应的value
     *
     * @param key
     * @return
     */
    public static String get(String fileName,String key) {
        readProperties(fileName);
        return props.getProperty(key);
    }

}
