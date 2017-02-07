package com.dong4j.homework;

/**
 * Created by: dong4j.
 * Date: 2017-02-07.
 * Time: 21:01.
 * Description:
 */
public class SymbianGameFactory implements GameFactory{
    @Override
    public OperationController createOperationController() {
        return new SymbianOperationController();
    }

    @Override
    public InterfaceController createInterfaceController() {
        return new SymbianInterfaceController();
    }
}
