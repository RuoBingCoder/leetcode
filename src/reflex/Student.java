package reflex;

/**
 * @author : 石建雷
 * @date :2019/8/21
 */
@SuppressWarnings("all")
public class Student {


    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println("eat...");
    }

    public void sleep() {
        System.out.println("我要睡觉!");
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
