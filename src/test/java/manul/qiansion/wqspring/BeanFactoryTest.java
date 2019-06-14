package manul.qiansion.wqspring;

import manul.qiansion.wqspring.factory.AutowireCapableBeanFactory;
import manul.qiansion.wqspring.factory.BeanFactory;
import org.junit.Test;

/**
 * @Auther: Anthony
 * @Date: 2019/6/14 15:31
 * @Description:
 */
public class BeanFactoryTest {

    @Test
    public void test() throws Exception {

        //1.初始化beanFactory
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        //2.bean定义
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("manul.qiansion.wqspring.HelloWorldService");

        //3.设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("text","hello"));
        beanDefinition.setPropertyValues(propertyValues);

        //4.生成bean
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);


        //3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}