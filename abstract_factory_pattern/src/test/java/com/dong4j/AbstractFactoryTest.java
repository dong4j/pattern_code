package com.dong4j;

import com.dong4j.factory.Button;
import com.dong4j.factory.Combobox;
import com.dong4j.factory.SkinFactory;
import com.dong4j.factory.TextField;
import com.dong4j.utils.ConfigUtil;
import org.junit.Test;

/**
 * Created by: dong4j.
 * Date: 2017-01-20.
 * Time: 21:19.
 * Description:
 */
public class AbstractFactoryTest {
    @Test
    public void abstractFactoryTest() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        // 使用抽象层定义
        SkinFactory factory;
        Button      bt;
        TextField   tf;
        Combobox    cb;
        factory = (SkinFactory) ConfigUtil.getType("skinType");
        bt = factory.createButton();
        tf = factory.createTextField();
        cb = factory.createCombobox();
        bt.display();
        tf.display();
        cb.display();
    }
}
