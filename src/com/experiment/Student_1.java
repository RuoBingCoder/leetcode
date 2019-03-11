package com.experiment;

/*
 * @author:石建雷
 * @data: 2018.11.7
 *
 */
public class Student_1 {

    public static void main(String[] args) {
        Student_2 student2 = new Student_2("张三", 12);
        student2.show();
        UnderGraduate graduate = new UnderGraduate("王五", 23, "haha");
        graduate.show();


    }

}

class Student_2 {
    public String name;
    public int age;

    public Student_2(String name, int age) {
        this.name = name;
        this.age = age;
    }



    public void show() {
        System.out.println("name:" + name + " age: " + age);
    }
}

class UnderGraduate extends Student_2 {
    public String degree;

    public UnderGraduate(String name, int age, String degree) {
        super(name, age);
        this.degree = degree;
    }

    public void show() {
        System.out.println("name:" + super.name + " age: " + super.age + " degree:" + degree);
    }
}
