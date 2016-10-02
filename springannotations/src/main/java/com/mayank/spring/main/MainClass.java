/**
 * 
 */
package com.mayank.spring.main;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mayank.spring.config.AppConfiguration;
import com.mayank.spring.service.SampleService;

/**
 * @author Maverick
 *
 */
public class MainClass {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String args[]) throws IOException{ 
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
		//context.refresh();
		SampleService sampleServiceBean = context.getBean(SampleService.class);
		sampleServiceBean.display();
		context.close();
		System.out.println("End of main method..........");
		
	}

}
