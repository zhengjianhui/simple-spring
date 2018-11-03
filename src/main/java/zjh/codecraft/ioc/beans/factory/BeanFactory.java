package zjh.codecraft.ioc.beans.factory;

/**
 * @author zhengjianhui on 10/29/18
 */
public interface BeanFactory {

    /**
     * 获取 bean
     *
     * @param name bena name
     * @return bean
     * @throws Exception 未找到类, 或方法, 字段异常, 参数异常, 实例化异常
     */
    Object getBean(String name) throws Exception;

}
