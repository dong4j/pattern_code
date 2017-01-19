package com.dong4j.abstract_factory;

/**
 * Created by: dong4j.
 * Date: 2017-01-19.
 * Time: 12:29.
 * Description: 具体工厂
 */
public class DatabaseLoggerFactory extends LoggerFactory {
    @Override
    public Logger createLogger() {
        return new DatabaseLogger();
    }
}
