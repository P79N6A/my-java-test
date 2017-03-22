package priv.zc.user.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import priv.zc.user.entity.User;

@Service
public class UserService {

	private Logger log=Logger.getLogger(this.getClass());

	public int addUser(User user) {
		log.info("addUser");
		return 0;
	}

	public int updateUser(User user) {
		log.info("updateUser");
		return 0;
	}

	public int deleteUser(User user) {
		log.info("deleteUser");
		return 0;
	}

	public User getUser(User user) {
		log.info("getUser");
		return null;
	}

	public List<User> getUserList(User user) {
		log.info("getUserList");
		return null;
	};
}
