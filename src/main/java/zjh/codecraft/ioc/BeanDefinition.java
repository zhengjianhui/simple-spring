package zjh.codecraft.ioc;

/**
 * @author zhengjianhui on 10/29/18
 */
public class BeanDefinition {

    /**
     * bean 对象
     */
    private Object bean;

    /**
     * bean class
     */
    private Class beanClass;

    /**
     * class name
     */
    private String beanClassName;

    public BeanDefinition() {
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
