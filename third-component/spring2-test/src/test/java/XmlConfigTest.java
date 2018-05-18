import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import priv.zc.spring2.service.UserService;

@ContextConfiguration(locations = "classpath:spring-xml.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class XmlConfigTest {
    @Autowired
    private UserService userService;
    @Test
    public void test() {
        userService.say();
    }
}
