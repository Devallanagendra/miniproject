package com.petpeers.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//declaration and implementation interface has
public class WebXMLConf extends AbstractAnnotationConfigDispatcherServletInitializer {

	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	protected Class<?>[] getServletConfigClasses() {

		return new Class[] { DBInternalResourceConfiguration.class };
	}

	protected String[] getServletMappings() {

		return new String[] { "/" };
	}

}
