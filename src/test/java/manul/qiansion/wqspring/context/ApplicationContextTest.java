package manul.qiansion.wqspring.context;

import manul.qiansion.wqspring.HelloWorldService;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Auther: Anthony
 * @Date: 2019/7/3 11:10
 * @Description:
 */
public class ApplicationContextTest {
    @Test
    public void test() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("wqspring.xml");
        HelloWorldService helloWorldService= (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}