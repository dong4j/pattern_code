package com.dong4j.abstract_factory;

/**
 * Created by: dong4j.
 * Date: 2017-01-19.
 * Time: 12:25.
 * Description: 抽象工厂接口
 */
public abstract class LoggerFactory {
    public abstract Logger createLogger();

    public void writeLog(){
        Logger logger = this.createLogger();
        logger.writeLog();
    }
}
