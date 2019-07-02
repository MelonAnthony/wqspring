package manul.qiansion.wqspring.factory;

import manul.qiansion.wqspring.BeanDefinition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: Anthony
 * @Date: 2019/6/14 16:36
 * @Description:
 */
public abstract class AbstractBeanFactory implements BeanFactory{

    private Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String,BeanDefinition>();

    //三级缓存
    private Map<String,Object> singletonObjects = new ConcurrentHashMap<>();
    private Map<String,Object> singletonFacotories = new ConcurrentHashMap<>();
    private Map<String,Object> earlySingletonObjects = new ConcurrentHashMap<>();

    private final List<String> beanDefinitionNames = new ArrayList<>();

    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition=beanDefinitionMap.get(name);
        if(beanDefinition == null){
            throw new IllegalArgumentException("no bean name"+name+"is defined");
        }
        Object bean = beanDefinition.getBean();
        if(bean == null){
            bean = doCreateBean(beanDefinition);
        }
        return bean;
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
        beanDefinitionMap.put(name,beanDefinition);
        beanDefinitionNames.add(name);
    }

    public void preInstantiateSingletons() throws Exception {
        for(Iterator it = this.beanDefinitionNames.iterator();it.hasNext();){
            String beanName = (String) it.next();
            getBean(beanName);
        }
    }

    /**
     * 初始化bean
     * @param beanDefinition
     * @return
     */
    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;

    public Map<String,Object> getSingletonObjects(){ return  this.singletonObjects;}

    public Map<String,Object> getSingletonFacotories(){ return this.singletonFacotories;}

    public Map<String,Object> getEarlySingletonObjects(){ return this.earlySingletonObjects;}
}
