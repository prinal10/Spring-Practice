package com.demo.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.model.Triangle;

public class DrawingApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Triangle triangle = new Triangle();

		// BeanFactory factory = new XmlBeanFactory(new
		// FileSystemResource("spring.xml"));

		// Application context is similar to the bean factory but it offers more
		// function like event notification, aop, etc. But requires more
		// resources then bean factory. we do'nt have to instantiate file stream
		// ApplicationContext context = new
		// ClassPathXmlApplicationContext("spring.xml");

		/*
		 * This is similar to ApplicationContext but used only we are developing
		 * a SE application i.e a desktop application where we have to
		 * explicitly have to destroy context, this can be done by calling the
		 * registerShutdownHook() method which will destroy the context at the
		 * end of the program. But in the web application the application
		 * context will know when to destroy the context.
		 */
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();

		// instead of explicitly creating a new object we used bean factory to
		// use xml file and create a object in the spring bean container using
		// spring beanfactory
		// Triangle triangle = (Triangle) factory.getBean("triangle");
		Triangle triangle = (Triangle) context.getBean("triangle");
		triangle.draw();

	}

}
