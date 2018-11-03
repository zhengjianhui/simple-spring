package zjh.codecraft.ioc.beans.factory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import zjh.codecraft.ioc.BeanFactoryAware;
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
    protected void applyPropertyValues(Object bean, BeanDefinition mbd) throws Exception {

        // 如果实现 BeanFactoryAware 则将工厂注入
        if (bean instanceof BeanFactoryAware) {
            ((BeanFactoryAware) bean).setBeanFactory(this);
        }

        for (PropertyValue propertyValue : mbd.getPropertyValues().getPropertyValues()) {
            Object value = propertyValue.getValue();

            // 如果有依赖注入, 则先实例化依赖, property 中同时封装了 BeanReference
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }

            // 尝试 set 注入, 如果注入失败则 成员注入
            try {

                Method declaredMethod = bean.getClass().getDeclaredMethod(
                        "set" + propertyValue.getName().substring(0, 1).toUpperCase()
                                + propertyValue.getName().substring(1), value.getClass());
                declaredMethod.setAccessible(true);

                declaredMethod.invoke(bean, value);
            } catch (NoSuchMethodException e) {
                Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
                declaredField.setAccessible(true);
                declaredField.set(bean, value);
            }
        }
    }

}
