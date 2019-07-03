package manul.qiansion.wqspring.beans.factory;

import manul.qiansion.wqspring.beans.BeanDefinition;

/**
 * @Auther: Anthony
 * @Date: 2019/6/14 15:27
 * @Description:beanfacoty作为IOC容器的接口,提供一些最基本的功能
 */
public interface BeanFactory {


    Object getBean(String name) throws Exception;
}
