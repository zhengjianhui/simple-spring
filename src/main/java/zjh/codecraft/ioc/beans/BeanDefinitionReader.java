package zjh.codecraft.ioc.beans;

/**
 * 解析 xml
 *
 * @author zhengjianhui on 10/29/18
 */
public interface BeanDefinitionReader {

    /**
     * 解析 xml
     *
     * @param location 本地位置
     * @throws Exception IO 异常
     */
    void loadBeanDefinitions(String location) throws Exception;
}
