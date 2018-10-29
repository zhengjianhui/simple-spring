package zjh.codecraft.ioc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhengjianhui on 10/29/18
 */
public class BeanFactory {

    /**
     * Bean 存储
     */
    private Map<String, BeanDefinition> beanDefinitions = new ConcurrentHashMap();

    /**
     * 获取 bean
     *
     * @param name bena name
     */
    public Object getBean(String name) {
        BeanDefinition beanDefinition = beanDefinitions.get(name);
        if (beanDefinition == null) {
            return null;
        }

        return beanDefinition.getBean();
    }

    /**
     * 注册 bean 到存储
     *
     * @param name           bean key
     * @param beanDefinition bean value
     */
    public void registerBean(String name, BeanDefinition beanDefinition) {
        beanDefinitions.put(name, beanDefinition);
    }


}
