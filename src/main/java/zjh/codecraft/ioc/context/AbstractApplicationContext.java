package zjh.codecraft.ioc.context;

import zjh.codecraft.ioc.beans.factory.AbstractBeanFactory;

/**
 * @author zhengjianhui on 10/31/18
 */
public class AbstractApplicationContext implements ApplicationContext {

    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void refresh() throws Exception {
    }

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }
}
