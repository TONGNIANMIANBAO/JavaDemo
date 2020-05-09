package com.testJDK15.j2004;

import java.beans.BeanDescriptor;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

public class TestIntrospector {

	public static void main(String[] args) throws IntrospectionException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		Person p = new Person();
		p.setAge(11);
		p.setName("sony");

		BeanInfo beanInfo = Introspector
				.getBeanInfo(p.getClass(), Object.class);//Object.class����
		BeanDescriptor beanDes = beanInfo.getBeanDescriptor();
		System.out.println("BeanDescriptor "+beanDes.getBeanClass());
		
		MethodDescriptor[] methodDes = beanInfo.getMethodDescriptors();
		for (MethodDescriptor method : methodDes) {
			System.out.println("MethodDescriptors "+method.getDisplayName());
		}

		PropertyDescriptor[] proDes = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor pro : proDes) {
			System.out.println("PropertyDescriptors "+pro.getReadMethod().getName());
			System.out.println("//" + pro.getReadMethod().invoke(p));
		}
		for (PropertyDescriptor pro : proDes) {
			System.out.println(pro.getWriteMethod());
			if (pro.getWriteMethod().getName().equalsIgnoreCase("setName")) {
				pro.getWriteMethod().invoke(p, "nintendo");
			}
			System.out.println("--" + p.getName());
		}

	}

}
