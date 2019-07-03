package manul.qiansion.wqspring.context;

import manul.qiansion.wqspring.beans.BeanDefinition;
import manul.qiansion.wqspring.beans.factory.AbstractBeanFactory;
import manul.qiansion.wqspring.beans.factory.AutowireCapableBeanFactory;
import manul.qiansion.wqspring.beans.io.ResourceLoader;
import manul.qiansion.wqspring.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @Auther: Anthony
 * @Date: 2019/7/2 18:08
 * @Description:
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext{

    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) throws Exception {
        this(configLocation,new AutowireCapableBeanFactory());
    }

    public ClassPathXmlApplicationContext(String configLocation,AbstractBeanFactory beanFactory) throws Exception {
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }

    @Override
    public void refresh() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinition(this.configLocation);
        for(Map.Entry<String,BeanDefinition> beanDefinitionEntry:xmlBeanDefinitionReader.getRegistryMap().entrySet()){
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(),beanDefinitionEntry.getValue());
        }
    }
}
