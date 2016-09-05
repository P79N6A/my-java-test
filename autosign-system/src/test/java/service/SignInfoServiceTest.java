package service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import priv.zc.autosign.service.SignInfoService;
import priv.zc.autosign.vo.ResultVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring.xml", })
public class SignInfoServiceTest {
	@Autowired
	SignInfoService signInfoService;
	
	@Test
	public void testExec(){
		ResultVo vo=signInfoService.exec(1l);
		System.out.println(JSON.parse((String) vo.getData()));
		System.out.println(JSON.toJSONString(vo));
	}
}
