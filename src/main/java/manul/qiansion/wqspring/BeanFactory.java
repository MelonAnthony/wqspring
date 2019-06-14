package manul.qiansion.wqspring;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: Anthony
 * @Date: 2019/6/14 15:27
 * @Description:
 */
public class BeanFactory {

    private Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String,BeanDefinition>();

    public Object getBean(String name){
        return beanDefinitionMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name , BeanDefinition beanDefinition){
        beanDefinitionMap.put(name,beanDefinition);
    }
}
