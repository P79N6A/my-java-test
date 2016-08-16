import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import priv.zc.user.entity.User;
import priv.zc.user.service.UserService;


public class UserTest {
	public static void main(String args[]) throws InterruptedException{
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		Thread.sleep(1000);
		UserService userService=(UserService) context.getBean("userService");
		userService.addUser(new User(1));
	}
}
