package zjh.codecraft.ioc.beans.factory;

import java.lang.reflect.Field;

import zjh.codecraft.ioc.beans.BeanDefinition;
import zjh.codecraft.ioc.beans.BeanReference;
import zjh.codecraft.ioc.beans.PropertyValue;

/**
 * 将创建 bean 的工作委托给该类实现, 该类有 bean 自动注入的功能
 *
 * @author zhengjianhui on 10/29/18
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doCreate(BeanDefinition mbd) throws Exception {
        if (mbd.getBean() != null) {
            return mbd.getBean();
        }

        Object bean = createBeanInstance(mbd);
        applyPropertyValues(bean, mbd);

        return bean;

    }

    protected Object createBeanInstance(BeanDefinition mbd) throws Exception {
        return mbd.getBeanClass().newInstance();
    }

    protected void applyPropertyValues(Object bean, BeanDefinition mbd) throws Exception {
        if (mbd.getPropertyValues() != null && mbd.getPropertyValues().getPropertyValues().size() != 0) {
            for (PropertyValue propertyValue : mbd.getPropertyValues().getPropertyValues()) {
                Field field = bean.getClass().getDeclaredField(propertyValue.getName());
                field.setAccessible(true);

                // 如果有依赖注入, 则先实例化依赖, property 中同时封装了 BeanReference
                Object value = propertyValue.getValue();
                if (value instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getName());
                }

                field.set(bean, value);
                mbd.setBean(bean);
            }
        }
    }

}
