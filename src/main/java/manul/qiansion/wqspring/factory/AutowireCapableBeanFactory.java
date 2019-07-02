package manul.qiansion.wqspring.factory;

import manul.qiansion.wqspring.BeanDefinition;
import manul.qiansion.wqspring.BeanReference;
import manul.qiansion.wqspring.PropertyValue;

import java.lang.reflect.Field;

/**
 * @Auther: Anthony
 * @Date: 2019/6/14 16:46
 * @Description:自动装配内容的BeanFactory
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory{
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBeanInstance(beanDefinition);
        beanDefinition.setBean(bean);
        applyPropertyValues(bean,beanDefinition);
        return bean;
    }

    private void applyPropertyValues(Object bean, BeanDefinition mbd) throws Exception {
        for(PropertyValue propertyValue:mbd.getPropertyValues().getPropertyValues()){
            Field declareField = bean.getClass().getDeclaredField(propertyValue.getName());
            declareField.setAccessible(true);
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }
            declareField.set(bean,value);
        }
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }
}
