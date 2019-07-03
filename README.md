# wqspring
微型spring-了解spring

# step1-基本容器

*step-1-container-register-and-get*

单纯的map，有get和put bean的功能

基础版本

#setp2-将bean创建放入工厂

*step-2-abstract-beanfactory-and-do-bean-initilizing-in-it*

1. 抽象beanfactory
2. 将bean初始化放入beanfactory

相比step1,这里更加分工明确了

+ 一个顶级接口__beanFactory__来提供IOC容器最基本的功能
+ 一个抽象工厂来定义抽象的创建bean的方法

具体的beanFactory(AutowireCapableBeanFactory)来继承抽象工厂，
来具体的实现这个创建bean的方法。

+ beanDefinition里同时 增加了几个属性和方法 和一个空的构造器

# step3-为bean注入属性

*step-3-inject-bean-with-property*

相比step2，这里新增了初始化bean和属性配置的方法

+ 新增PropertyValues类(用来添加PropertyValue的属性)
+ 为抽象类的添加具体的方法 applyPropertyValues(通过反射来实现)

# step4-读取xml配置来初始化bean

*step-4-config-beanfactory-with-xml*

相比step3，这里增加了读取xml配置的信息

+ 增加Resource相关的资源加载器
+ 增加BeanDefinitionReader相关的读取xml配置信息

利用BeanDefinitionReader将xml信息读取到registry(一个hashmap)中，然后将registry里的BeanDefinition

复制到IOC容器的BeanDefinitionMap中.

# Step5-bean的相互依赖

*step-5-inject-bean-to-bean*

相比step4，对于相互依赖的bean引入了beanReference。

在读取xml文件时，依赖关系ref 就用beanReference来代替。然后在初始化时，根据beanReference里面的name属性，在beanDefinitionMap中找到跟他同名的beanDefinition，若beanDefinition中的bean没有初始化，则创建，已经初始化了，就将该bean通过反射赋值给相应的属性。

# step6-ApplicationContext登场

*step-6-invite-application-context*

相比step5，此处增加了ApplicationContext。

在没有ApplicationContext之前，bean的获取是在BeanFactory里的，bean的初始化是在BeanDefinitionReader里的，这里的ApplicationContext就是将两者结合，形成一个既能初始化bean，又能获取bean的简单IOC容器。