package com.myclass.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
/* DispatcherServlet*/
public class DispatcherServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {HibernateConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// khai báo class cấu hình spring mvc
		return new Class[] {WebMvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// cấu hình những request url map với DispatcherServlet
		return new String[] {"/"};
	}

}
