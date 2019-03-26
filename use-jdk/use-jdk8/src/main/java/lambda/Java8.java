package lambda;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8 {

    public static void main(String[] args) {
        //        stream();
        time();
    }

    public static void stream() {
        System.out.println(
                new Random().longs(100, 0, 100).filter(e -> e < 100 && e > -100).boxed().collect(Collectors.toList()));
        Stream.of("a", "b", "c", "d").filter(e -> e == "b").forEach(s -> System.out.println(s));
        IntStream.range(0, 100).boxed().map(e -> "天天-" + e).map(User::random).forEach(o -> System.out.println(o));
    }

    public static void lambda() {

    }

    public static void optional() {

    }

    public static void time() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
    }

}

class User {
    private Long id;
    private String name;
    private int age;
    private int sex;

    public User() {
    }

    public static User random(String name) {
        Random random = new Random();
        return new User(random.nextLong(), name, random.nextInt(100), random.nextInt(2));
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("age=" + age)
                .add("sex=" + sex)
                .toString();
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
