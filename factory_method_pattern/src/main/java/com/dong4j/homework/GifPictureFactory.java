package com.dong4j.homework;

/**
 * Created by: dong4j.
 * Date: 2017-01-20.
 * Time: 19:43.
 * Description:
 */
public class GifPictureFactory implements PictureFactory{
    @Override
    public Picture getPicture() {
        return new GifPicture();
    }
}
