package com.dong4j.homework;

/**
 * Created by: dong4j.
 * Date: 2017-02-07.
 * Time: 21:02.
 * Description:
 */
public class AndroidGameFactory implements GameFactory{
    @Override
    public OperationController createOperationController() {
        return  new AndroidOperationController();
    }

    @Override
    public InterfaceController createInterfaceController() {
        return  new AndroidInterfaceController();
    }
}
