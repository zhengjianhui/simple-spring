package zjh.codecraft.ioc.context;

import org.junit.Test;

import zjh.codecraft.ioc.TestBean;
import zjh.codecraft.ioc.TestBeanImpl;

/**
 * @author zhengjianhui on 10/31/18
 */
public class ApplicationContextTest {

    @Test
    public void test() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("test.xml");
        TestBeanImpl testBeanImpl = (TestBeanImpl) applicationContext.getBean("test");
        testBeanImpl.test();
    }

    @Test
    public void aopTest() throws Exception {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop-test.xml");
        TestBean testBeanImpl = (TestBean) applicationContext.getBean("test");

        testBeanImpl.test();
    }
}
