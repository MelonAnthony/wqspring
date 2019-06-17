package manul.qiansion.wqspring;

import manul.qiansion.wqspring.io.ResourceLoader;
import java.util.HashMap;
import java.util.Map;


/**
 * @Auther: Anthony
 * @Date: 2019/6/17 14:58
 * @Description:构建实现
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{

    private Map<String,BeanDefinition> registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.registry = new HashMap<String,BeanDefinition>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String,BeanDefinition> getRegistryMap(){
        return this.registry;
    }

    public ResourceLoader getResourceLoader(){
        return this.resourceLoader;
    }
}
