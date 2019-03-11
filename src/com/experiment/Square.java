package com.experiment;

/*
 * @author:石建雷
 * @data: 2018.11.5
 *
 */
public class Square implements Shape {


    public double area(double x) {


        return x * x;


    }

    public static void main(String[] args) {

        Square square = new Square();
        System.out.println("正方形面积为："+square.area(2.0));


    }

}
