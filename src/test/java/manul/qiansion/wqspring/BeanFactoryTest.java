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
    public void test(){
        //1.初始化beanFactory
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        //2.注入bean
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("manul.qiansion.wqspring.HelloWorldService");
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        //3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}