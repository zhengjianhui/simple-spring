package zjh.codecraft.ioc;

import zjh.codecraft.ioc.factory.AutowireCapableBeanFactory;
import zjh.codecraft.ioc.factory.BeanFactory;

/**
 * @author zhengjianhui on 10/29/18
 */
public class Test {

    @org.junit.Test
    public void test() throws Exception {
        BeanDefinition definition = new BeanDefinition();
        definition.setBeanClassName("zjh.codecraft.ioc.TestBean");

        BeanFactory factory = new AutowireCapableBeanFactory();
        factory.registerBean("testBean", definition);

        TestBean testBean = (TestBean) factory.getBean("testBean");
        testBean.test();

    }
}

