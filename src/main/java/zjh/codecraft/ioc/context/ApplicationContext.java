package zjh.codecraft.ioc.context;

import zjh.codecraft.ioc.beans.factory.BeanFactory;

/**
 * BeanFactory 的派生, 与 BeanFactory 的延时加载不同
 * 提前一次性加载所有 bean
 *
 * 更多的框架拓展
 *
 * @author zhengjianhui on 10/31/18
 */
public interface ApplicationContext extends BeanFactory {
}
