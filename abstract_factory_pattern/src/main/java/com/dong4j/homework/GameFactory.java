package com.dong4j.homework;

/**
 * Created by: dong4j.
 * Date: 2017-02-07.
 * Time: 20:59.
 * Description:
 */
public interface GameFactory {
    OperationController createOperationController();
    InterfaceController createInterfaceController();
}
