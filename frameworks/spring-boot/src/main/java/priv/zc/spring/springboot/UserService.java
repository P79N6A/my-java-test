package priv.zc.spring.springboot;

public interface UserService {
    void create(String name,Integer age);

    void deleteByName(String name);

    Integer getAllUsers();

}
