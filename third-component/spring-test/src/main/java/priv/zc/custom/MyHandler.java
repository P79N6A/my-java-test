package priv.zc.custom;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class MyHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        this.registerBeanDefinitionParser("test",new MyTestBeanDefinitionParser());
    }
}
