package zjh.codecraft.ioc;

import java.util.Map;

import zjh.codecraft.ioc.factory.AutowireCapableBeanFactory;
import zjh.codecraft.ioc.factory.BeanFactory;
import zjh.codecraft.ioc.io.ResourceLoader;
import zjh.codecraft.ioc.xml.XmlBeanDefinitionReader;

/**
 * @author zhengjianhui on 10/29/18
 */
public class Test {

    @org.junit.Test
    public void test() throws Exception {
//        BeanDefinition definition = new BeanDefinition();
//        definition.setBeanClassName("zjh.codecraft.ioc.TestBean");
//
//        BeanFactory factory = new AutowireCapableBeanFactory();
//        factory.registerBean("testBean", definition);
//
//        TestBean testBean = (TestBean) factory.getBean("testBean");
//        testBean.test();

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("test.xml");

        BeanFactory factory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> e : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            factory.registerBean(e.getKey(), e.getValue());
        }

        TestBean testBean = (TestBean) factory.getBean("test");
        testBean.test();



    }
}

