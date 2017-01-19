package com.dong4j.interface_factory;

/**
 * Created by: dong4j.
 * Date: 2017-01-19.
 * Time: 12:28.
 * Description: 具体工厂
 */
public class FileLoggerFactory implements LoggerFactory{
    @Override
    public Logger createLogger() {
        return new FileLogger();
    }
}
