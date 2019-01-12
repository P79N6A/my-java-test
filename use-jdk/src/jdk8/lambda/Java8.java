package jdk8.lambda;

import java.util.Random;

public class Java8 {

    public static void main(String[] args) {
        Random random = new Random();
        long ll = random.longs().limit(1).filter(e -> e > 100).findFirst().orElse(0);
        System.out.println(ll);
    }

    public User random() {
        return new User();
    }
}

class User {
    private Long id;
    private String name;
    private int age;
    private int sex;

    public User() {
    }

    public User(Long id, String name, int age, int sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
