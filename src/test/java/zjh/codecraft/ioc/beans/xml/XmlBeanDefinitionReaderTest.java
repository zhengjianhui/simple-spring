package zjh.codecraft.ioc.beans.xml;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import zjh.codecraft.ioc.beans.BeanDefinition;
import zjh.codecraft.ioc.beans.io.ResourceLoader;

/**
 * @author zhengjianhui on 10/29/18
 */
public class XmlBeanDefinitionReaderTest {

    @Test
    public void test() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("test.xml");

        Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
        BeanDefinition testBean = registry.get("test");
        Assert.assertTrue(registry.size() > 0);
    }
}
