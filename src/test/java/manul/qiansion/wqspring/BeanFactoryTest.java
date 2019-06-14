package manul.qiansion.wqspring;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Auther: Anthony
 * @Date: 2019/6/14 15:31
 * @Description:
 */
public class BeanFactoryTest {

    @Test
    public void test(){
        //1.初始化beanFactory
        BeanFactory beanFactory = new BeanFactory();
        //2.注入bean
        BeanDefinition beanDefinition = new BeanDefinition(new HelloWorldService());
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        //3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}