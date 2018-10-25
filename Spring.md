# Sping
IOC���Ʒ�ת������Ȩ��ת�ƣ�Ӧ�ó�����������������Ĵ�����ά�����������ⲿ�������𴴽���ά��  

DI����ע�룬��ʵ�ֿ��Ʒ�ת��һ�ַ�ʽ  

spring��xml���ã�idΪbean��id��classΪ�ö������ȫ��  

�ֶ�����spring��jar����project->properties->jav build path->libraries->add externaljars
src�ļ��³���applicationContext.xml���ڴ���bean���������£�
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

��������ļ���������
1.����Ĺ��� ������������  
2.�þ�̬����������spring������ľ�̬���췽�������ö���  
3.ʵ����������  

ʹ��ʵ��������������
1. factory-bean���ԣ�ָ��һ��bean��id  
2. factory-method���ԣ�ָ��һ������  
3. spring������������bean�Ķ�Ӧ�ķ�������������  

�Զ�װ��ָ����spring��������ĳ�ֹ����Զ�����������������ϵ��Ĭ������²����Զ�װ��  
����ͨ��autowire�������������������Զ�װ�䣬������Ȼ��Ҫ����set����������������������ϵ  

autowrite="byname"
byname:�����������������Ҷ�Ӧ��bean��Ȼ����ö�Ӧ��set���������ע��
   a.����Ҳ�����Ӧ��bean��ע��null
   b.�����ҵ��������������bean
   
bytype:���������������Ͳ��Ҷ�Ӧ��bean��Ȼ����ö�Ӧ��set�������ע��
   a.ͬ��
   b.�п����ҵ��������������bean���ᱨ��
constructor:��bytype���ƣ����ǻ���ù��캯�������ע��

ͨ������������xml��ע�������Ե�ֵ��ʹ��value����
ע�뼯�����͵�ֵ��
�������list���ԣ�
```
<property name="country">
	<list>
		<value>china</value>
		<value>japan</value>
	</list>
</property>
```
set����ͬ�ϣ�
map�е㲻ͬ��
```
<property name="country">
	<map>
		<entry key="china" age="10"/>
		<entry key="japan" age="20"/>
	</map>
</property>
```

�ӳټ��أ���������Ϊ�����Ķ����ȴ���

## ����ע������ע��

@Autowried��@Qualifier  
��ע��֧��set����ע��͹���������ע��  
������set��ʽע��ʱ�����Խ�@Autowried��ӵ�set�������꣬�����ʹ��@Qualifier,��
������ʹ��byType�ķ�ʽ��ע�룬�п��ܳ�������ʹ��@Qualifier,��ȷָ��Ҫע���bean
��id  

@Resource  
ֻ֧��set��ʽע��  
���Խ�ע����ӵ�����ǰ��ʹ��name����ָ��Ҫע���bean id�������ָ��Ĭ�ϰ���byType
��ʽע��  

@Value  
����ʹ�ø�ע����ע��������͵�ֵ  
����ʹ�ø�ע��ʹ��Spring���ʽ  
��ע�������ӵ�����ǰ��������ӵ���Ӧ��set����ǰ  


## Spring MVC
��һ��MVC��ܣ������򻯻���MVC�ܹ���webӦ�ÿ���