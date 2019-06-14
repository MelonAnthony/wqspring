package manul.qiansion.wqspring.factory;

import manul.qiansion.wqspring.BeanDefinition;

/**
 * @Auther: Anthony
 * @Date: 2019/6/14 16:46
 * @Description:
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory{
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) {
        try {
            //这里的newInstance只能调用无参构造器，所以只能beanDefinition里需要一个无参构造器
            Object bean = beanDefinition.getBeanClass().newInstance();
            return bean;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
