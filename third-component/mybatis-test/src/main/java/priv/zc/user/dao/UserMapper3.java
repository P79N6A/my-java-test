package priv.zc.user.dao;

import java.util.List;

import priv.zc.user.entity.User;

public interface UserMapper3 {
	Integer addUser(User user);
	int deleteUser(User user);
	int updateUser(User user);
	User getUser(User user);
	List<User> selectUserList(User user);
}
