package com.demo.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

/*
 * Tells spring that this class is a bean and name of the bean will be lower case 
 * of the class name. To use this we have to add a context:component bean in xml 
 * file, which tells that there is package with classes marked as component class
 * for bean creation 
 * 
 * Similarly we can add @Service, @Controller, @Repository and other annotations to
 * tell spring what this class is meant or class role / how this class will be used/ or act
 * 
 *  We have created a private local publisher object. Now to notify spring and to set the 
 *  global publisher  to this local publisher we implement ApplicationEventPublisherAware interface. 
 *  Which has a method that passes the global publisher object, we can assign this global object to
 *  the local publisher. This global publisher object is application context object that has implemented 
 *  the ApplicationEventPublisherAware
*/
@Component
public class Circle implements Shape, ApplicationEventPublisherAware {

	private Point center1;
	private Point center2;

	/*
	 * Using this message source object we can read and print text from a
	 * .properties file specified in the xml. We can also use it to print other
	 * class member variables values. for example see draw() method below where
	 * we use this object to print the center2
	 */
	@Autowired
	private MessageSource messageSource;

	/*
	 * We have created an EventListener class. No we have to publish an event so
	 * that spring can detect that kind/type of event. We will use
	 * ApplicationEventPublisher interface variable
	 */
	private ApplicationEventPublisher publisher;

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public Point getCenter1() {
		return center1;
	}

	/*
	 * This will tell spring that the below setter must run during the bean
	 * initialization in the .xml file. By this we are validating during the
	 * initialization that the member variables of this class are getting values
	 * and we don't get any null pointer exception during the run time. Instead
	 * throw an exception during the bean initialization itself. But for this
	 * annotation to work we have to add a required bean post processor bean in
	 * xml. This bean will search for the required annotated
	 * method/class/variables and verifies in the xml these annotated are
	 * initialized or not.
	 */
	// @Required
	@Resource(name = "pointF")
	public void setCenter1(Point center) {
		this.center1 = center;
	}

	public Point getCenter2() {
		return center2;
	}

	/*
	 * During the bean the bean initialization spring will search for a bean
	 * with property having the same type as of this annotated class member
	 * variable "center2", as we have multiple beans having the same type,
	 * spring will then look byName if it finds bean with the same name as class
	 * member variable name then the member variable is initialized with that
	 * bean. But for this annotation to work we have to add a autowired bean
	 * post processor bean in xml. We don't have to specify any property for
	 * this member variable in the BEAN in xml file.
	 */
	// @Autowired
	/*
	 * If spring don't find any bean by type or name than we can use this
	 * qualifier annotation. Now wherever the qualifier tag inside any bean is
	 * assigned value="circleRelated" that beans properties are initialized for
	 * this member variable i.e "circle2". This is used as second guess after
	 * autowired
	 */
	// @Qualifier("circleRelated")

	/*
	 * Using this annotation the spring knows the bean id/name/alias in xml file
	 * So spring will initialize this member variable ("center") with the bean
	 * specified in the name of resource annotation below. If we don't specify
	 * name para then spring will look for the bean having the same name as the
	 * member variable i.e "center2"
	 */
	@Resource(name = "center")
	public void setCenter2(Point center2) {
		this.center2 = center2;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

		System.out.println("The Point1 from the Circle class: X = " + center1.getX() + " & " + "Y = " + center1.getY());
		// System.out.println("The Point2 from the Circle class: X = " +
		// center2.getX() + " & " + "Y = " + center2.getY());
		System.out.println(this.messageSource.getMessage("printdata", new Object[] { center2.getX(), center2.getY() },
				"No message found !!!", null));

		System.out.println("This is greeting from Circle: "
				+ this.messageSource.getMessage("greeting", null, "No message found !!!", null));

		// created an event
		DrawEvent drawevent = new DrawEvent(this);

		// published the above created event
		publisher.publishEvent(drawevent);
	}

	/*
	 * Similar to the init that we did for triangle but this is by using
	 * annotation and nothing in the xml file
	 */
	@PostConstruct
	public void initializeCircle() {
		System.out.println("This is initialization of CIRCLE !!!");
	}

	/*
	 * Similar to the destroy that we did for triangle but this is by using
	 * annotation and nothing in the xml file. Same as for the triangle destroy
	 * we have to registerShutdownHook method on the context object in the main
	 * method only one time for all (triangle, circle ,etc) for the below
	 * destroy method to be called before application/main method exists
	 */
	@PreDestroy
	public void destroyCircle() {
		System.out.println("This is destroy of CIRCLE !!!");

	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		// TODO Auto-generated method stub
		this.publisher = publisher;

	}

}
