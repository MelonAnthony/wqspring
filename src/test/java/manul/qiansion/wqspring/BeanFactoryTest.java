package manul.qiansion.wqspring;

import manul.qiansion.wqspring.beans.BeanDefinition;
import manul.qiansion.wqspring.beans.factory.AbstractBeanFactory;
import manul.qiansion.wqspring.beans.factory.AutowireCapableBeanFactory;
import manul.qiansion.wqspring.beans.io.ResourceLoader;
import manul.qiansion.wqspring.beans.xml.XmlBeanDefinitionReader;
import manul.qiansion.wqspring.context.ApplicationContext;
import manul.qiansion.wqspring.context.ClassPathXmlApplicationContext;
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
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for(Map.Entry<String,BeanDefinition> beanDefinitionEntry:xmlBeanDefinitionReader.getRegistryMap().entrySet()){
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(),beanDefinitionEntry.getValue());
        }

        //3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }

    @Test
    public void testPreInstantiate() throws Exception {
        // 1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinition("wqspring.xml");

        // 2.初始化BeanFactory并注册bean
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistryMap().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 3.初始化bean
        beanFactory.preInstantiateSingletons();

        // 4.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }

}