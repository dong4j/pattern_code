package com.dong4j.factory;

/**
 * Created by: dong4j.
 * Date: 2017-01-20.
 * Time: 21:12.
 * Description:
 */
public class SpringSkinFactory implements SkinFactory{
    @Override
    public Button createButton() {
        return new SpringButton();
    }

    @Override
    public TextField createTextField() {
        return new SpringTextField();
    }

    @Override
    public Combobox createCombobox() {
        return new SpringCombobox();
    }
}
