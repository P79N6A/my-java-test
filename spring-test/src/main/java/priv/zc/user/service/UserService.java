package priv.zc.user.service;

import java.util.List;

import priv.zc.user.entity.User;

public interface UserService {
	int addUser(User user);
	int updateUser(User user);
	int deleteUser(User user);
	User getUser(User user);
	List<User> getUserList(User user);
}
