package manul.qiansion.wqspring;

import java.io.IOException;

/**
 * @Auther: Anthony
 * @Date: 2019/6/17 14:56
 * @Description:读取BeanDefinition接口
 */
public interface BeanDefinitionReader {

    void loadBeanDefinition(String location) throws Exception;
}
