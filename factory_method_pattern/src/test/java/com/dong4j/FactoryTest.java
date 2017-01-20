package com.dong4j;

import com.dong4j.homework.PictureFactory;
import com.dong4j.interface_factory.Logger;
import com.dong4j.utils.ConfigUtil;
import org.junit.Test;

/**
 * Created by: dong4j.
 * Date: 2017-01-19.
 * Time: 12:32.
 * Description:
 */
public class FactoryTest {
    /**
     * Factory test.
     * 抽象工厂为 interface
     * @throws ClassNotFoundException the class not found exception
     * @throws IllegalAccessException the illegal access exception
     * @throws InstantiationException the instantiation exception
     */
    @Test
    public void interfaceFactoryTest() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        com.dong4j.interface_factory.LoggerFactory loggerFactory = (com.dong4j.interface_factory.LoggerFactory)ConfigUtil.getType("loggerType1");
        Logger logger = loggerFactory.createLogger();
        logger.writeLog();
    }

    /**
     * Factory test.
     * 抽象工厂为 abstract
     * @throws ClassNotFoundException the class not found exception
     * @throws IllegalAccessException the illegal access exception
     * @throws InstantiationException the instantiation exception
     */
    @Test
    public void abstractFactoryTest() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        com.dong4j.abstract_factory.LoggerFactory loggerFactory = (com.dong4j.abstract_factory.LoggerFactory)ConfigUtil.getType("loggerType2");
        loggerFactory.writeLog();
    }

    /**
     * Homework test.
     * 使用工厂方法模式实现
     * @throws IllegalAccessException the illegal access exception
     * @throws InstantiationException the instantiation exception
     * @throws ClassNotFoundException the class not found exception
     */
    @Test
    public void homeworkTest() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        PictureFactory pictureFactory = (PictureFactory) ConfigUtil.getType("pictureType");
        pictureFactory.getPicture().readInfo();
    }
}
