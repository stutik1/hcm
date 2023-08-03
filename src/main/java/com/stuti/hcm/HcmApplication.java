package com.stuti.hcm;

import com.stuti.email.api.CustomInterceptor;
import com.stuti.email.api.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan(basePackages = {"com.stuti.*"})
public class HcmApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(HcmApplication.class, args);
	}

	@Bean
	public CustomInterceptor customInterceptor() {
		return new CustomInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(customInterceptor());
	}
}
