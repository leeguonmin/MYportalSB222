package himedia.myportal;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// mvc 설정 클래스 
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
	
	// 인터셉터 설정
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
	
	
}
