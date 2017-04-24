package com.demo.model;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@SuppressWarnings("rawtypes")
@Component
public class MyEventListener implements ApplicationListener {

	/*
	 * This method will be called when any application event i.e frame work
	 * related event is published. This class has to be registered as bean and
	 * so will used @Component annotation instead of specifying it in the xml
	 * file
	 */
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		// TODO Auto-generated method stub
		System.out.println(event.toString());

	}

}
