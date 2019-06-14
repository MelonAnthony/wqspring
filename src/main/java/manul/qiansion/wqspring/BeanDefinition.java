package manul.qiansion.wqspring;

/**
 * @Auther: Anthony
 * @Date: 2019/6/14 15:25
 * @Description:bean定义,装载bean的一些基本信息
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean(){
        return bean;
    }
}
