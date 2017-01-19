package com.dong4j.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by: dong4j.
 * Date: 2017-01-18.
 * Time: 21:06.
 * Description:
 */
public class ConfigUtil {
    public static Object getType(String type) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Properties properties = new Properties();
        try {
            // config.properties 必须放在 classpath 路径下才能加载.
            properties.load(ConfigUtil.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Class obj = Class.forName(properties.getProperty(type));
        return obj.newInstance();
    }
}
