package com.dong4j.homework;

/**
 * Created by: dong4j.
 * Date: 2017-01-20.
 * Time: 19:44.
 * Description:
 */
public class JpgPictureFactory implements PictureFactory {
    @Override
    public Picture getPicture() {
        return new JpgPicture();
    }
}
