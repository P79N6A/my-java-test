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

import priv.zc.user.dao.UserMapper2;
import priv.zc.user.entity.User;

public class UserTest2 {
	private static SqlSession session;
	private static Logger log = Logger.getLogger("test");

	@Before
	public void before() {
		String configFile = "mybatis-config-2.xml";
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
	}

	@After
	public void after() {
		session.commit();
		session.close();
	}

//	@Test
	public void insert(){
		log.info(session.insert("priv.zc.user.dao.UserMapper2.addUser", new User("A","B",1,new Timestamp(System.currentTimeMillis()))));
	}
//	@Test
	public void selectOne() {
		User user=session.selectOne("priv.zc.user.dao.UserMapper2.getUser",new User(3));
		log.info(user);
	}
	@Test
	public void testInterface(){
		UserMapper2 userMapper=session.getMapper(UserMapper2.class);
		System.out.println(userMapper.getUser(new User(3)));
	}
}
