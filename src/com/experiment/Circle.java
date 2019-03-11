package com.experiment;

/*
 * @author:石建雷
 * @data: 2018.11.5
 *
 */
public class Circle implements Shape {

    public double area(double x) {

        return Math.PI * x * x;


    }

    public static void main(String[] args) {

        Circle circle = new Circle();
        System.out.println("圆面积为："+circle.area(3.0));

    }

}
