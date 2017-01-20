package com.dong4j.homework;

/**
 * Created by: dong4j.
 * Date: 2017-01-20.
 * Time: 19:41.
 * Description:
 * 使用工厂方法模式设计一个程序来读取各种不同类型的图片格式，
 * 针对每一种图片格式都设计一个图片读取器，
 * 如 GIF 图片读取器用于读取 GIF 格式的图片、JPG 图片读取器用于读取 JPG 格式的图片。
 * 需充分考虑系统的灵活性和可扩展性。
 */
public interface PictureFactory {
    public Picture getPicture();
}
