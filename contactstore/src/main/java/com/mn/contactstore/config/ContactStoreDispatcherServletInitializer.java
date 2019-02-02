package com.mn.contactstore.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
 * This is the combination of 2 classes 1. Business Layer & 2. MVC Layer configuration
 * @see SpringRootConfig, SpringWebConfig 
 * @author Md Nazish
 */

public class ContactStoreDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {

		return new Class[] { SpringRootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return new Class[] { SpringWebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		// Specify URL-Patterns
		return new String[] { "/" };
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// Required: Don't ingore this line
		super.onStartup(servletContext); // must present

		// Configure global task if required.
	}

}
