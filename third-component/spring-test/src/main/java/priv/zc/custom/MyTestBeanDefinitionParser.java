package priv.zc.custom;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

import priv.zc.user.entity.User;

public class MyTestBeanDefinitionParser implements BeanDefinitionParser {

    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {

        String id = element.getAttribute("id");
        String username = element.getAttribute("username");
        String password = element.getAttribute("password");
        String age = element.getAttribute("age");
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.getPropertyValues().addPropertyValue("id", id);
        beanDefinition.getPropertyValues().addPropertyValue("username", username);
        beanDefinition.getPropertyValues().addPropertyValue("password", password);
        beanDefinition.getPropertyValues().addPropertyValue("age", age);
        beanDefinition.setBeanClass(User.class);
        parserContext.getRegistry().registerBeanDefinition(id, beanDefinition);
        return beanDefinition;
    }

}
