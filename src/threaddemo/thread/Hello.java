package threaddemo.thread;

/*
 * @author:石建雷
 * @data: 2018.11.3
 *
 */
public class Hello {


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Student stu=new Student("张三",18);
        stu.show();
        Undergraduate undergraduate=new Undergraduate("李四",20,"硕士");
        undergraduate.show();
    }
}

class Student{
    public String name;
    public int age;
    public Student(String name,int age) {
        this.name=name;
        this.age=age;
    }
    public void show() {
        System.out.println("name:"+name+"age:"+age);
    }
}

class Undergraduate extends Student {
    public String degree;
    public Undergraduate(String name,int age,String degree) {
        super(name,age);
        this.degree=degree;
    }
    public void show() {
        System.out.println("name:"+name+"age:"+age+"degree:"+degree);
    }

}


