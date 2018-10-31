package zjh.codecraft.ioc.context;

import org.junit.Test;

import zjh.codecraft.ioc.TestBean;

/**
 * @author zhengjianhui on 10/31/18
 */
public class ApplicationContextTest {

    @Test
    public void test() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("test.xml");
        TestBean testBean = (TestBean) applicationContext.getBean("test");
        testBean.test();
    }
}
