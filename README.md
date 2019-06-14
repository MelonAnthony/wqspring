# wqspring
微型spring-了解spring

step1：
setp2：
相比step1,这里更加分工明确了
一个顶级接口beanFactory来提供IOC容器最基本的功能
一个抽象工厂来定义抽象的创建bean的方法
具体的beanFactory(AutowireCapableBeanFactory)来继承抽象工厂，
来具体的实现这个创建bean的方法。

beanDefinition里同时 增加了几个属性和方法 和一个空的构造器
