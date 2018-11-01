package zjh.codecraft.ioc.aop;

import org.junit.Test;

import zjh.codecraft.ioc.ITestBean;
import zjh.codecraft.ioc.TestBean;
import zjh.codecraft.ioc.TestOutBean;

/**
 * @author zhengjianhui on 11/1/18
 */
public class JdkDynamicAopProxyTest {

    @Test
    public void test() {
        // 准备源对象
        TestBean testBean = new TestBean();
        TestOutBean testOutBean = new TestOutBean();
        testBean.setTest("测试 jdk aop 增强");
        testBean.setTestOutBean(testOutBean);

        // 具体增强逻辑
        TimerInterceptor timerInterceptor = new TimerInterceptor();

        // 源对象封装
        TargetSource targetSource = new TargetSource(ITestBean.class, testBean);

        // AdvisedSupport
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(targetSource);
        advisedSupport.setMethodInterceptor(timerInterceptor);

        // 构建 JDK 代理对象
        JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);
        ITestBean proxyObj = (ITestBean) jdkDynamicAopProxy.getProxy();

        proxyObj.test();

    }

}
