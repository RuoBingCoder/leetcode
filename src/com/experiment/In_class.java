package com.experiment;

/*
 * @author:石建雷
 * @data: 2018.11.8
 *
 */
public class In_class {

    public static void main(String[] args){
        In_class in_class=new In_class();

        In in=new In();
        in.show();


    }

}
    class  In{

        public void show(){

            System.out.println("我是内部类！");
        }

    }


