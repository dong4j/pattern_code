package com.dong4j;

import com.dong4j.factory.Logger;
import com.dong4j.factory.LoggerFactory;
import com.dong4j.utils.ConfigUtil;
import org.junit.Test;

/**
 * Created by: dong4j.
 * Date: 2017-01-19.
 * Time: 12:32.
 * Description:
 */
public class FactoryTest {
    @Test
    public void factoryTest() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        LoggerFactory loggerFactory = (LoggerFactory)ConfigUtil.getType("loggerType");
        Logger logger = loggerFactory.createLogger();
        logger.writeLog();
    }
}
