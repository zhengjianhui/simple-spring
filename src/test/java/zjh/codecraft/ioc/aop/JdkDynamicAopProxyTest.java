package zjh.codecraft.ioc.aop;

import org.junit.Test;

import zjh.codecraft.ioc.TestBean;
import zjh.codecraft.ioc.TestBeanImpl;
import zjh.codecraft.ioc.TestOutBeanImpl;

/**
 * @author zhengjianhui on 11/1/18
 */
public class JdkDynamicAopProxyTest {

    @Test
    public void test() {
        // 准备源对象
        TestBeanImpl testBeanImpl = new TestBeanImpl();
        TestOutBeanImpl testOutBeanImpl = new TestOutBeanImpl();
        testBeanImpl.setTest("测试 jdk aop 增强");
        testBeanImpl.setTestOutBean(testOutBeanImpl);

        // 具体增强逻辑
        TimerInterceptor timerInterceptor = new TimerInterceptor();

        // 源对象封装
        TargetSource targetSource = new TargetSource(TestBean.class, testBeanImpl, TestBean.class.getInterfaces());
        // 需要接口, 直接用对象会报错 jdk 动态代理
//        TargetSource targetSource = new TargetSource(testBeanImpl.getClass(), testBeanImpl);

        // AdvisedSupport
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(targetSource);
        advisedSupport.setMethodInterceptor(timerInterceptor);

        // 构建 JDK 代理对象
        JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);
        TestBean proxyObj = (TestBean) jdkDynamicAopProxy.getProxy();

        proxyObj.test();

    }

}
