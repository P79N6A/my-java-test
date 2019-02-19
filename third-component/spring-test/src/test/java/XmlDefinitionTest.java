import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:spring-my.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class XmlDefinitionTest implements ApplicationContextAware {
    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    @Test
    public void test() {
        System.out.println("ApplicationName:" + context.getApplicationName());
        System.out.println("DisplayName:" + context.getDisplayName());
        System.out.println("DefinitionCount:" + context.getBeanDefinitionCount());
        System.out.println("BeanDefinitionName:" + Arrays.toString(context.getBeanDefinitionNames()));
        Object bean = context.getBean("1");
        System.out.println(bean);
    }
}
