package zjh.codecraft.ioc.aop;

import org.junit.Test;

import zjh.codecraft.ioc.TestBean;
import zjh.codecraft.ioc.TestBeanImpl;
import zjh.codecraft.ioc.context.ApplicationContext;
import zjh.codecraft.ioc.context.ClassPathXmlApplicationContext;

/**
 * @author zhengjianhui on 11/3/18
 */
public class Cglib2AopProxyTest {

    @Test
    public void testInterceptor() throws Exception {
        // --------- helloWorldService without AOP
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop-test.xml");
        TestBean testBean = (TestBean) applicationContext.getBean("test");
        testBean.test();

        // 1. 设置被代理对象(Joinpoint)
        AdvisedSupport advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(TestBeanImpl.class, testBean, TestBean.class.getInterfaces());
        advisedSupport.setTargetSource(targetSource);

        // 2. 设置拦截器(Advice)
        TimerInterceptor timerInterceptor = new TimerInterceptor();
        advisedSupport.setMethodInterceptor(timerInterceptor);

        // 3. 创建代理(Proxy)
        Cglib2AopProxy cglib2AopProxy = new Cglib2AopProxy(advisedSupport);
        TestBean proxy = (TestBean) cglib2AopProxy.getProxy();

        // 4. 基于AOP的调用
        proxy.test();

    }
}
