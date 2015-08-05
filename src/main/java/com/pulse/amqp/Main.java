package com.pulse.amqp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * This class supplies the main method that creates the spring context
 * and then all processing is invoked asynchronously by messaging.
 * 
 * @author Percero
 *
 */
public class Main{
	/**
	 * Main function for starting the process
	 */
	public static void main(String[] args){
		ApplicationContext context =
				new ClassPathXmlApplicationContext(new String[] {"spring/percero-spring-config.xml","spring/*.xml"});
		System.out.println(context.toString());
	}
}
