package zjh.codecraft.ioc.aop.cut;

import org.aopalliance.intercept.MethodInterceptor;

import java.util.List;

import zjh.codecraft.ioc.BeanFactoryAware;
import zjh.codecraft.ioc.BeanPostProcessor;
import zjh.codecraft.ioc.aop.ProxyFactory;
import zjh.codecraft.ioc.aop.TargetSource;
import zjh.codecraft.ioc.beans.factory.AbstractBeanFactory;
import zjh.codecraft.ioc.beans.factory.BeanFactory;

/**
 * 实现 BeanFactoryAware 用于后续从 factory 中获取 PointcutAdvisor
 * 实现 BeanPostProcessor 用于增强 bean
 *
 * @author zhengjianhui on 11/2/18
 */
public class AspectJAwareAdvisorAutoProxyCreator implements BeanFactoryAware, BeanPostProcessor {

    private AbstractBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = (AbstractBeanFactory) beanFactory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        // AspectJExpressionPointcutAdvisor 该类 bean 无需加强
        if (bean instanceof AspectJExpressionPointcutAdvisor) {
            return bean;
        }

        // MethodInterceptor 等同于  advice 同样无需增强
        if (bean instanceof MethodInterceptor) {
            return bean;
        }

        // 获取指定加强对象
        List<AspectJExpressionPointcutAdvisor> advisors
                = beanFactory.getBeansForType(AspectJExpressionPointcutAdvisor.class);

        for (AspectJExpressionPointcutAdvisor advisor : advisors) {
            // 判断类是否符合加强逻辑
            if (advisor.getPointcut().getClassFilter().matches(bean.getClass())) {
//                AdvisedSupport advisedSupport = new AdvisedSupport();
//                // 注入切面
//                advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
//                // 注入方法匹配
//                advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
//                // 注入源对象
//                advisedSupport.setTargetSource(new TargetSource(bean.getClass(), bean, bean.getClass().getInterfaces()));
//
//                return new JdkDynamicAopProxy(advisedSupport).getProxy();

                ProxyFactory advisedSupport = new ProxyFactory();
                advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
                advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());

                TargetSource targetSource = new TargetSource(bean.getClass(), bean, bean.getClass().getInterfaces());
                advisedSupport.setTargetSource(targetSource);

                return advisedSupport.getProxy();
            }
        }

        return bean;
    }
}
