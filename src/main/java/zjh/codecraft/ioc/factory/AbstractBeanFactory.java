package zjh.codecraft.ioc.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import zjh.codecraft.ioc.BeanDefinition;

/**
 * bean 的创建
 * @author zhengjianhui on 10/29/18
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    /**
     * Bean 存储
     */
    private Map<String, BeanDefinition> beanDefinitions = new ConcurrentHashMap();

    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition = beanDefinitions.get(name);
        if (beanDefinition == null) {
            return null;
        }

        return doCreate(beanDefinition);
    }

    @Override
    public void registerBean(String name, BeanDefinition mbd) {
        beanDefinitions.put(name, mbd);
    }

    /**
     * 初始化 bean
     * @param mbd
     * @return
     */
    protected abstract Object doCreate(BeanDefinition mbd) throws Exception;

}
