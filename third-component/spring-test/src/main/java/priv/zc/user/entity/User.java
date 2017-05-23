package priv.zc.user.entity;

import java.sql.Timestamp;

public class User {
	private Integer id;
	private String username;
	private String password;
	private Integer age;
	private Timestamp addTime;
	private Timestamp updateTime;
	
	public User(String username, String password, Integer age,
			Timestamp addTime) {
		this.username = username;
		this.password = password;
		this.age = age;
		this.addTime = addTime;
	}
	
	public User(Integer id){
		this.id=id;
	}
	
	public User(){}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", age=" + age + ", addTime=" + addTime
				+ ", updateTime=" + updateTime + "]";
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
}
