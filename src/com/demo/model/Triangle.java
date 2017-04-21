package com.demo.model;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements ApplicationContextAware, BeanNameAware {

	/*
	 * private String type; private int height;
	 * 
	 * public Triangle(String type) {
	 * 
	 * this.type = type; System.out.println("New type created"); }
	 * 
	 * public Triangle(int height) {
	 * 
	 * this.height = height; System.out.println("New height created"); }
	 * 
	 * public Triangle(String type, int height) { super(); this.type = type;
	 * this.height = height; }
	 * 
	 * public int getHeight() { return height; }
	 * 
	 * public String getType() { return type; }
	 * 
	 * public void setType(String type) { this.type = type; }
	 * 
	 * public void draw() { System.out.println(getType() +
	 * " Traingle drawn of height " + getHeight() + " !!!"); }
	 */

	/*-------------------------------------------------------------------------------------------*/

	private Point pointA;
	private Point pointB;
	private Point pointC;
	private Point pointD;
	private Point pointE;
	private List<Point> points;

	private ApplicationContext context = null;

	private String beanName;

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public Point getPointD() {
		return pointD;
	}

	public void setPointD(Point pointD) {
		this.pointD = pointD;
	}

	public Point getPointE() {
		return pointE;
	}

	public void setPointE(Point pointE) {
		this.pointE = pointE;
	}

	public void draw() {

		System.out.println("This is point A---> X : " + getPointA().getX() + " & Y : " + getPointA().getY());
		System.out.println("This is point B---> X : " + getPointB().getX() + " & Y : " + getPointB().getY());
		System.out.println("This is point C---> X : " + getPointC().getX() + " & Y : " + getPointC().getY());
		System.out.println("This is point D---> X : " + getPointD().getX() + " & Y : " + getPointD().getY());
		System.out.println("This is point E---> X : " + getPointE().getX() + " & Y : " + getPointE().getY());

		System.out.println("Loop begins from here------------------>");
		for (Point point : points) {

			System.out.println("This is Loop Point---> X : " + point.getX() + " & Y : " + point.getY());

		}

	}

	/*
	 * Whenever the spring bean i.e xml is initialized spring will see that the
	 * bean class "Triangle" implements the ApplicationContextAware interface
	 * and so will call the set below method "setApplicationContext", which we
	 * can use to assign is to local context variable in the triangle class.
	 * Using this context object we can initialize any member variable in the
	 * triangle class even if the triangle bean in the xml file is with
	 * singleton scope
	 */
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		// TODO Auto-generated method stub
		this.context = context;

	}

	/*
	 * Similarly when the spring bean sees that the triangle class has
	 * implemented the BeanNameAware interface it will call the below method
	 * setBeanName using which we can set the local memeber variable and use the
	 * bean name anywhere
	 */
	@Override
	public void setBeanName(String beanName) {
		// TODO Auto-generated method stub
		this.beanName = beanName;

	}

	/*
	 * As we have implemented InitializingBean interface the spring bean will
	 * call this method after the class (triangle bean)bean properties from the
	 * xml has initialized.
	 */
	/*
	 * @Override public void afterPropertiesSet() throws Exception { // TODO
	 * Auto-generated method stub
	 * 
	 * System.out.println("After the initialization of Bean!!!");
	 * 
	 * }
	 */
	/*
	 * As we have implemented DisposableBean interface the spring bean will call
	 * this method before it destroys the bean(triangle bean)
	 */
	/*
	 * @Override public void destroy() throws Exception { // TODO Auto-generated
	 * method stub System.out.println("Before destroying the Bean!!!");
	 * 
	 * }
	 */

	/*
	 * This is similar to the above afterPropertiesSet() method. This is
	 * assigned as an initialization method in the spring xml file using
	 * "init-method" para in the triangle bean tag
	 */
	public void myInit() {
		System.out.println("After the initialization of Bean!!!");
	}

	/*
	 * This is similar to the above destroy() method. This is assigned as an
	 * destroy-method in the spring xml file using "destroy-method" para in the
	 * triangle bean tag
	 */
	public void beforeDestroy() {
		System.out.println("Before destroying the Bean!!!");
	}

}
