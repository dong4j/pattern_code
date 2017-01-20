package com.dong4j.factory;

/**
 * Created by: dong4j.
 * Date: 2017-01-20.
 * Time: 21:12.
 * Description:
 */
public class SummerSkinFactory implements SkinFactory{
    @Override
    public Button createButton() {
        return new SummerButton();
    }

    @Override
    public TextField createTextField() {
        return new SummerTextField();
    }

    @Override
    public Combobox createCombobox() {
        return new SummerCombobox();
    }
}
