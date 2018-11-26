import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import priv.zc.spring.springboot.PropertiesLoad;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PropertiesLoad.class)
public class PropertiesTest {
    @Autowired
    private PropertiesLoad propertiesLoad;

    @Test
    public void getHello() {
        System.out.println(propertiesLoad.getVal1());
        System.out.println(propertiesLoad.getVal2());
        Assert.assertEquals(propertiesLoad.getVal1(), "Hello");
        Assert.assertEquals(propertiesLoad.getVal2(), "World");
    }
}
