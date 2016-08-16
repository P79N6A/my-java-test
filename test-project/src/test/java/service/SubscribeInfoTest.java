package service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import priv.zc.project.model.SubscribeInfo;
import priv.zc.project.service.SubscribeInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml"})
public class SubscribeInfoTest {
	@Autowired
	private SubscribeInfoService subscribeInfoSerivce;
	@Test
	public void insert(){
		SubscribeInfo subscribeInfo = new SubscribeInfo();
		int result = subscribeInfoSerivce.insert(subscribeInfo);
		System.out.println(result);
	}
	
	@Test
	public void selectSome(){
		System.out.println(subscribeInfoSerivce.selectByCondition(null));
	}
}
