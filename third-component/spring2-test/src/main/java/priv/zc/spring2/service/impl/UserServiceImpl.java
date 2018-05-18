package priv.zc.spring2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import priv.zc.spring2.service.UserService;
import priv.zc.spring2.vo.User;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("user_name_1")
    private User user;

    public void say(){
        System.out.println(user);
    }
}
