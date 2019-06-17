package manul.qiansion.wqspring.xml;

import manul.qiansion.wqspring.BeanDefinition;
import manul.qiansion.wqspring.io.ResourceLoader;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * @Auther: Anthony
 * @Date: 2019/6/17 17:07
 * @Description:
 */
public class XmlBeanDefinitionReaderTest {

    @Test
    public void test() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinition("wqspring.xml");
        Map<String,BeanDefinition> registry = xmlBeanDefinitionReader.getRegistryMap();
        System.out.println("IOC容器装在的beanDefinition:");
        for(Map.Entry<String,BeanDefinition> item:registry.entrySet()){
            System.out.println("name:"+item.getKey()+"===value:"+item.getValue());
        }
    }
}