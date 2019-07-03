package manul.qiansion.wqspring.context;

import manul.qiansion.wqspring.beans.BeanDefinition;
import manul.qiansion.wqspring.beans.factory.AbstractBeanFactory;

/**
 * @Auther: Anthony
 * @Date: 2019/7/2 18:03
 * @Description:
 */
public abstract class AbstractApplicationContext implements ApplicationContext{

    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory abstractBeanFactory) {
        this.beanFactory = abstractBeanFactory;
    }

    public abstract void refresh() throws Exception;

    @Override
    public Object getBean(String name) throws Exception {
       return beanFactory.getBean(name);
    }
}
