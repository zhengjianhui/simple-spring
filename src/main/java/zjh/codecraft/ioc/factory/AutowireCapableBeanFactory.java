package zjh.codecraft.ioc.factory;

import zjh.codecraft.ioc.BeanDefinition;

/**
 * 将创建 bean 的工作委托给该类实现
 *
 * @author zhengjianhui on 10/29/18
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doCreate(BeanDefinition beanDefinition) {
        Object obj = null;
        if (beanDefinition.getBean() != null) {
            return beanDefinition.getBean();
        }

        try {
            obj = beanDefinition.getBeanClass().newInstance();
            beanDefinition.setBean(obj);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return obj;

    }
}
