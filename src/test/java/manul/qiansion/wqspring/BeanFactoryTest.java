package manul.qiansion.wqspring;

import manul.qiansion.wqspring.factory.AutowireCapableBeanFactory;
import manul.qiansion.wqspring.factory.BeanFactory;
import manul.qiansion.wqspring.io.ResourceLoader;
import manul.qiansion.wqspring.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

/**
 * @Auther: Anthony
 * @Date: 2019/6/14 15:31
 * @Description:
 */
public class BeanFactoryTest {

    @Test
    public void test() throws Exception {

        //1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinition("wqspring.xml");

        //2.初始化BeanFactory并注册bean
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        for(Map.Entry<String,BeanDefinition> beanDefinitionEntry:xmlBeanDefinitionReader.getRegistryMap().entrySet()){
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(),beanDefinitionEntry.getValue());
        }

        //3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloService");
        helloWorldService.helloWorld();
    }
}