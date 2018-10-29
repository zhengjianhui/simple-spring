package zjh.codecraft.ioc;

/**
 * @author zhengjianhui on 10/29/18
 */
public class BeanDefinition {

    /**
     * bean 对象
     */
    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }

}
