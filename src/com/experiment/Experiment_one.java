package com.experiment;

/*
 * @author:石建雷
 * @data: 2018.11.5
 *
 */
public class Experiment_one {

    public static void main(String[] args) {


        int sum = 0;
        for (int i = 1; i < 100; i = i + 2) {

            sum = i + sum;


        }
        System.out.println("sum:" + sum);
    }

}
