import org.junit.Test;

import zjh.codecraft.ioc.BeanDefinition;
import zjh.codecraft.ioc.BeanFactory;

/**
 * 测试 bean 注册和获取
 * @author zhengjianhui on 10/29/18
 */
public class Step1 {

    @Test
    public void test() {
        BeanDefinition beanDefinition = new BeanDefinition("test");

        BeanFactory beanFactory  = new BeanFactory();

        // register bean definition
        beanFactory.registerBean("test", beanDefinition);

        // get Obj
        Object obj = beanFactory.getBean("test");

        System.out.println(obj);

    }
}
