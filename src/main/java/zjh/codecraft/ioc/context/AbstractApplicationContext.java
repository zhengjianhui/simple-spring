package zjh.codecraft.ioc.context;

import java.util.List;

import zjh.codecraft.ioc.BeanPostProcessor;
import zjh.codecraft.ioc.beans.factory.AbstractBeanFactory;

/**
 * @author zhengjianhui on 10/31/18
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void refresh() throws Exception {
        // 注册 BeanDefinition
        loadBeanDefinitions(beanFactory);
        // 实例化 BeanPostProcessor 的 Bean
        registerBeanPostProcessors(beanFactory);
        // 初始化所有 Bean
        onRefresh();
    }

    /**
     * 加载资源 转化为 BeanDefinition
     *
     * @param beanFactory bean 工厂
     * @throws Exception 可能的异常
     */
    protected abstract void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception;

    /**
     * 注册 BeanPostProcessor 类型的 bean
     *
     * @param beanFactory bean 工厂
     * @throws Exception 可能的异常
     */
    protected void registerBeanPostProcessors(AbstractBeanFactory beanFactory) throws Exception {
        List beanPostProcessors = beanFactory.getBeansForType(BeanPostProcessor.class);
        for (Object beanPostProcessor : beanPostProcessors) {
            beanFactory.addBeanPostProcessor((BeanPostProcessor) beanPostProcessor);
        }
    }

    /**
     * 初始化 bean
     *
     * @throws Exception 可能的异常
     */
    protected void onRefresh() throws Exception {
        beanFactory.preInstantiateSingletons();
    }

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }
}
