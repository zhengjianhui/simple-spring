package zjh.codecraft.ioc;

import zjh.codecraft.ioc.beans.factory.BeanFactory;

/**
 * 提供让某些 bean 感知工厂的能力, 能对工厂做一些操作
 *
 * @author zhengjianhui on 11/2/18
 */
public interface BeanFactoryAware extends Aware {

    /**
     * 注入工厂
     *
     * @param beanFactory spring bean 工厂
     */
    void setBeanFactory(BeanFactory beanFactory);
}
