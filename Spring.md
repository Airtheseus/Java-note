# Sping
IOC控制反转，控制权的转移，应用程序本身不负责以来对象的创建和维护，而是由外部容器负责创建和维护  

DI依赖注入，是实现控制反转的一种方式  

spring的xml配置，id为bean的id，class为该对象类的全称  

手动导入spring的jar包，project->properties->jav build path->libraries->add externaljars
src文件下常见applicationContext.xml用于创建bean，范例如下：
```
<?xml version="1.0" encoding="UTF-8"?>  
<beans  
    xmlns="http://www.springframework.org/schema/beans"  
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
    xmlns:p="http://www.springframework.org/schema/p"  
    xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">  
  
    
    <bean id="northMan" class="test.NorthMan"></bean>  
    <bean id="southMan" class="test.SouthMan"></bean>  
    <bean id="date"     class="java.util.Date"></bean>   
</beans> 
```

创建对象的几个方法：
1.用类的构造 函数创建对象  
2.用静态工厂方法，spring调用类的静态构造方法创建该对象  
3.实例工厂方法  

使用实例方法创建对象：
1. factory-bean属性：指定一个bean的id  
2. factory-method属性：指定一个方法  
3. spring容器会调用这个bean的对应的方法来创建对象  

自动装配指的是spring容器依据某种规则，自动建立对象间的依赖关系，默认情况下不会自动装配  
可以通过autowire属性来告诉容器进行自动装配，容器仍然需要调用set方法或构造器来建立依赖关系  

autowrite="byname"
byname:容器依据属性名查找对应的bean，然后调用对应的set方法来完成注入
   a.如果找不到对应的bean，注入null
   b.不会找到多个符合条件的bean
   
bytype:容器依据属性类型查找对应的bean，然后调用对应的set方法完成注入
   a.同上
   b.有可能找到多个符合条件的bean，会报错
constructor:与bytype类似，但是会调用构造函数来完成注入

通过容器还能在xml中注入类属性的值，使用value属性
注入集合类型的值：
例如添加list属性：
```
<property name="country">
	<list>
		<value>china</value>
		<value>japan</value>
	</list>
</property>
```
set类型同上，
map有点不同：
```
<property name="country">
	<map>
		<entry key="china" age="10"/>
		<entry key="japan" age="20"/>
	</map>
</property>
```

延迟加载，把作用于为单例的对象先创建

## 依赖注入的相关注解

@Autowried和@Qualifier  
该注解支持set方法注入和构造器方法注入  
当采用set方式注入时，可以将@Autowried添加到set方法掐年，如果不使用@Qualifier,则
容器会使用byType的方式来注入，有可能出错，建议使用@Qualifier,明确指出要注入的bean
的id  

@Resource  
只支持set方式注入  
可以将注解添加到属性前，使用name属性指定要注入的bean id，如果不指定默认按照byType
方式注入  

@Value  
可以使用该注解来注入基本类型的值  
可以使用该注解使用Spring表达式  
该注解可以添加到属性前，或者添加到对应的set方法前  


## Spring MVC
是一个MVC框架，用来简化基于MVC架构的web应用开发