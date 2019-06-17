# wqspring
微型spring-了解spring

#step1：

基础版本

#setp2：

相比step1,这里更加分工明确了

+ 一个顶级接口__beanFactory__来提供IOC容器最基本的功能
+ 一个抽象工厂来定义抽象的创建bean的方法

具体的beanFactory(AutowireCapableBeanFactory)来继承抽象工厂，
来具体的实现这个创建bean的方法。

+ beanDefinition里同时 增加了几个属性和方法 和一个空的构造器



# step3

相比step2，这里新增了初始化bean和属性配置的方法

+ 新增PropertyValues类(用来添加PropertyValue的属性)
+ 为抽象类的添加具体的方法 applyPropertyValues(通过反射来实现)