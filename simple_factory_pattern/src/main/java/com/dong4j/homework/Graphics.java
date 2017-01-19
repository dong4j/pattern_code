package com.dong4j.homework;

/**
 * Created by: dong4j.
 * Date: 2017-01-19.
 * Time: 11:04.
 * Description:
 * 使用简单工厂模式设计一个可以创建不同几何形状（如圆形、方形和三角形等）的绘图工具，
 * 每个几何图形都具有绘制 draw() 和擦除 erase() 两个方法，
 * 要求在绘制不支持的几何图形时，提示一个 UnSupportedShapeException。
 */
public class Graphics {
     public void draw(){
         System.out.println("画图方法");
     }
     public void erase(){
         System.out.println("擦除方法");
     }

     public static Graphics createGraphics(String type) throws UnSupportedShapeException {
         switch (type){
             case "rot" :
                 return new Rotundity();
             case "squ" :
                 return new Squareness();
             case "tri" :
                 return new Trigon();
             default :
                 throw new UnSupportedShapeException();
         }
     }
}
