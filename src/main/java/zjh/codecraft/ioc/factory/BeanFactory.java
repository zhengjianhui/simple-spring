package zjh.codecraft.ioc.factory;

import zjh.codecraft.ioc.BeanDefinition;

/**
 * @author zhengjianhui on 10/29/18
 */
public interface BeanFactory {

    /**
     * 获取 bean
     *
     * @param name bena name
     */
    Object getBean(String name);

    /**
     * 注册 bean 到存储
     *
     * @param name           bean key
     * @param beanDefinition bean value
     */
    void registerBean(String name, BeanDefinition beanDefinition);
}
