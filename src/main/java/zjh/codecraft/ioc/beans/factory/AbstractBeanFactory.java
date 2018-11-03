package zjh.codecraft.ioc.beans.factory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import zjh.codecraft.ioc.BeanPostProcessor;
import zjh.codecraft.ioc.beans.BeanDefinition;

/**
 * bean 的创建
 *
 * @author zhengjianhui on 10/29/18
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    /**
     * Bean 存储
     */
    private Map<String, BeanDefinition> beanDefinitions = new ConcurrentHashMap();

    /**
     * 存储 bean 的 name
     */
    private final List<String> beanDefinitionNames = new ArrayList<String>();

    /**
     * 用于保存实现 BeanPostProcessor 接口的 bean 用于对象实例化加强
     */
    private List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition mbd = beanDefinitions.get(name);
        if (mbd == null) {
            throw new IllegalArgumentException("No bean named " + name + " is defined");
        }

        // 只有第一次创建 bean 的时候需要初始化
        Object bean = mbd.getBean();
        if (bean == null) {
            bean = doCreate(mbd);
            bean = initializeBean(bean, name);

            mbd.setBean(bean);
        }

        return bean;
    }


    /**
     * 对 bean 初始化进行一定操作
     *
     * @param bean     bean 对象
     * @param beanName bean name
     * @return 处理后的对象
     * @throws Exception 可能的异常
     */
    protected Object initializeBean(Object bean, String beanName) throws Exception {
        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            bean = beanPostProcessor.postProcessBeforeInitialization(bean, beanName);
        }

        // TODO:call initialize method
        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            bean = beanPostProcessor.postProcessAfterInitialization(bean, beanName);
        }
        return bean;
    }

    /**
     * 注册 bean 到存储
     *
     * @param name bean key
     * @param mbd  bean value
     */
    public void registerBean(String name, BeanDefinition mbd) {
        beanDefinitions.put(name, mbd);
        beanDefinitionNames.add(name);
    }

    /**
     * 初始化 bean
     *
     * @param mbd matedata
     * @return Object
     */
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

    /**
     * 复制 property 属性, 空实现, 用于给子类实现, 和本类中 doCreate 方法不报错
     *
     * @param bean bean 对象
     * @param mbd  BeanDefinition
     * @throws Exception 可能的异常
     */
    protected void applyPropertyValues(Object bean, BeanDefinition mbd) throws Exception {

    }


    /**
     * 根据 bean type 获取 bean 的实例
     * (如果没有初始化则初始化)
     *
     * @param type class 类型
     * @return List type 类型的 bean 实例集合
     * @throws Exception 可能的异常
     */
    public List getBeansForType(Class type) throws Exception {
        List beans = new ArrayList();

        for (String beanName : beanDefinitionNames) {
            if (type.isAssignableFrom(beanDefinitions.get(beanName).getBeanClass())) {
                beans.add(getBean(beanName));
            }
        }

        return beans;
    }

    /**
     * 添加 BeanPostProcessor 用于 bean 的初始化后操作
     *
     * @param beanPostProcessor BeanPostProcessor
     */
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.add(beanPostProcessor);
    }


    /**
     * 提前初始化单例的 bean
     *
     * @throws Exception 可能的异常
     */
    public void preInstantiateSingletons() throws Exception {
        for (Iterator it = this.beanDefinitionNames.iterator(); it.hasNext(); ) {
            String beanName = (String) it.next();
            getBean(beanName);
        }
    }

}
