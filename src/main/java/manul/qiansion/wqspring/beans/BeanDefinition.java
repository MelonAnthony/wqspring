package manul.qiansion.wqspring.beans;

/**
 * @Auther: Anthony
 * @Date: 2019/6/14 15:25
 * @Description:bean定义,装载bean的一些基本信息
 */
public class BeanDefinition {

    private Object bean;

    private Class beanClass;

    private String beanClassName;

    private PropertyValues propertyValues = new PropertyValues();

    public BeanDefinition(){

    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
