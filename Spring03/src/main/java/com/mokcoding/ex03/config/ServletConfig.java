package com.mokcoding.ex03.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

// servlet-context.xml과 동일 
@Configuration // Spring Container에서 관리하는 설정 클래스 
@EnableWebMvc // Spring MVC 기능 사용
@ComponentScan(basePackages = {"com.mokcoding.ex03"}) // component scan 설정
public class ServletConfig implements WebMvcConfigurer{
	
	// ViewResolver 설정 메서드
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// InternalResourceViewResolver 생성 및 설정
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		registry.viewResolver(viewResolver);
	}
	
	// ResourceHandlers 설정 메서드
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 정적 리소스 핸들러를 추가 
		// "/resources/**" 패턴의 요청을 처리하기 위한 핸들러를 등록
		// "/resources/" 경로에 위치한 정적 리소스를 사용할 수 있도록 설정
		registry
		.addResourceHandler("/resources/**")
		.addResourceLocations("/resources/");
	}
} // end ServletConfig
