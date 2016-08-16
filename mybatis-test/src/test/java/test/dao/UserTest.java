package test.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import priv.zc.user.entity.User;

public class UserTest {
	private static SqlSession session;
	private static Logger log=Logger.getLogger("test");
	
	@Before
	public void before(){
		String configFile = "mybatis-config.xml";
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
	public void after(){
		session.close();
	}
	@Test
	public void add(){
		for (int i = 0; i < 10; i++) {
			session.insert("test.addUser",
					new User("user" + i, "pass" + i, 10 + i, new Timestamp(
							System.currentTimeMillis())));
			session.commit();
		}
	}
	@Test
	public void selectOne() {
		
		log.info(session.selectOne("test.getUser",
				new User(3)));
	}
	
	public void selectList(){
		log.info(session.selectMap("test.selectUserList", new User(), "id"));

	}
}
