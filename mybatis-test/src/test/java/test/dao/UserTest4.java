package test.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.Timestamp;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import priv.zc.user.dao.UserMapper3;
import priv.zc.user.entity.User;

public class UserTest4 {
	private static SqlSession session;
	private static UserMapper3 userMapper;
	private Logger log = Logger.getLogger(this.getClass());

	@Before
	public void before() {
		String configFile = "mybatis-config-4.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(configFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.exit(0);
		}
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
				.build(reader);
		session = sessionFactory.openSession();
		userMapper=session.getMapper(UserMapper3.class);
	}

	@After
	public void after() {
		session.commit();
		session.close();
	}

	public void addUser(){
		User user = new User("A","B",1,new Timestamp(System.currentTimeMillis()));
		Integer id=userMapper.addUser(user );
		log.info(id+"\t"+user);
	}

	@Test
	public void selectOne() {
		log.info(userMapper.getUser(new User(3)));
	}
	
//	@Test
	public void selectList(){
		log.info(userMapper.selectUserList(null));
	}
}
