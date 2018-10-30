package zjh.codecraft.ioc.factory;

import java.lang.reflect.Field;

import zjh.codecraft.ioc.BeanDefinition;
import zjh.codecraft.ioc.BeanReference;
import zjh.codecraft.ioc.PropertyValue;

/**
 * 将创建 bean 的工作委托给该类实现
 *
 * @author zhengjianhui on 10/29/18
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doCreate(BeanDefinition beanDefinition) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        if (beanDefinition.getBean() != null) {
            return beanDefinition.getBean();
        }

        Object obj = beanDefinition.getBeanClass().newInstance();
        beanDefinition.setBean(obj);

        if (beanDefinition.getPropertyValues() != null && beanDefinition.getPropertyValues().getPropertyValues().size() != 0) {
            for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {
                Field field = obj.getClass().getDeclaredField(propertyValue.getName());
                field.setAccessible(true);

                // 如果有依赖注入, 则先实例化依赖, property 中同时封装了 BeanReference
                Object value = propertyValue.getValue();
                if(value instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getName());
                }

                field.set(obj, value);
            }
        }

        return obj;

    }
}
