package zjh.codecraft.ioc.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import zjh.codecraft.ioc.BeanDefinition;

/**
 * @author zhengjianhui on 10/29/18
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    /**
     * Bean 存储
     */
    private Map<String, BeanDefinition> beanDefinitions = new ConcurrentHashMap();

    public Object getBean(String name) {
        BeanDefinition beanDefinition = beanDefinitions.get(name);
        if (beanDefinition == null) {
            return null;
        }

        return doCreate(beanDefinition);
    }

    public void registerBean(String name, BeanDefinition beanDefinition) {
        beanDefinitions.put(name, beanDefinition);
    }

    /**
     * 初始化 bean
     * @param beanDefinition
     * @return
     */
    protected abstract Object doCreate(BeanDefinition beanDefinition);

}
