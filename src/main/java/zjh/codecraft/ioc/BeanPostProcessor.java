package zjh.codecraft.ioc;

/**
 * @author zhengjianhui on 11/2/18
 */
public interface BeanPostProcessor {

    /**
     * bean初始化方法调用前被调用
     *
     * @param bean     bean 对象
     * @param beanName bean 名称
     * @return bean 对象
     * @throws Exception 可能的异常
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception;

    /**
     * bean初始化方法调用后被调用
     *
     * @param bean     bean 对象
     * @param beanName bean 名称
     * @return bean 对象
     * @throws Exception 可能的异常
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws Exception;
}
