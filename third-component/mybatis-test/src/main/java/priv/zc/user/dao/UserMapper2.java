package priv.zc.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import priv.zc.user.entity.User;

public interface UserMapper2 {
	@Insert("insert into user values(null,#{username},#{password},#{age},#{addTime},#{updateTime})")
	Integer addUser(User user);
	@Delete("delete from user where id=#{id}")
	int deleteUser(User user);
	@Update("update user set username=#{username},password=#{password},age=#{age},add_time=#{addTime},update_time=#{updateTime}")
	int updateUser(User user);
	@Select("select * from user where id=#{id}")
	User getUser(User user);
	@Select("select * from user")
	List<User> selectUserList(User user);
}
