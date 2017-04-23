package com.demo.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.model.Shape;

public class DrawingApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Triangle triangle = new Triangle();

		// BeanFactory factory = new XmlBeanFactory(new
		// FileSystemResource("spring.xml"));

		/*
		 * Application context is similar to the bean factory but it offers more
		 * function like event notification, aop, etc. But requires more
		 * resources then bean factory. we do'nt have to instantiate file
		 * stream. Also other benefits are message service used below, event
		 * handling
		 */
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

		System.out.println("---------------Begining of the main class ----------------");
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		// System.out.println("After the spring.xml file is read and the all
		// beans are initialized");

		context.registerShutdownHook();

		System.out.println(context.getMessage("greeting", null, "No message found !!!", null));

		// instead of explicitly creating a new object we used bean factory to
		// use xml file and create a object in the spring bean container using
		// spring beanfactory
		// Triangle triangle = (Triangle) factory.getBean("triangle");

		/*
		 * By creating a interface and implementing it, we don't have to create
		 * a new Object everytime and we can use old object by just changing the
		 * getBean method. Also we can add more SHAPE like oval, rectangle, etc
		 * and just change the call on the getBean method. THIS IS CALLED
		 * "CODING TO INTERFACE"
		 */
		Shape shape = (Shape) context.getBean("triangle");
		// shape.draw();
		shape = (Shape) context.getBean("circle");
		shape.draw();

	}

}
