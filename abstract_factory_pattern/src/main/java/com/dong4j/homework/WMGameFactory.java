package com.dong4j.homework;

/**
 * Created by: dong4j.
 * Date: 2017-02-07.
 * Time: 21:03.
 * Description:
 */
public class WMGameFactory implements GameFactory{
    @Override
    public OperationController createOperationController() {
        return new WMOperationController();
    }

    @Override
    public InterfaceController createInterfaceController() {
        return new WMInterfaceController();
    }
}
