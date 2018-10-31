package zjh.codecraft.ioc.context;

import java.util.Map;

import zjh.codecraft.ioc.beans.BeanDefinition;
import zjh.codecraft.ioc.beans.factory.AbstractBeanFactory;
import zjh.codecraft.ioc.beans.factory.AutowireCapableBeanFactory;
import zjh.codecraft.ioc.beans.io.ResourceLoader;
import zjh.codecraft.ioc.beans.xml.XmlBeanDefinitionReader;

/**
 * @author yihua.huang@dianping.com
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) throws Exception {
        this(configLocation, new AutowireCapableBeanFactory());
    }

    public ClassPathXmlApplicationContext(String configLocation, AbstractBeanFactory beanFactory) throws Exception {
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }

    @Override
    public void refresh() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBean(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
    }

}
