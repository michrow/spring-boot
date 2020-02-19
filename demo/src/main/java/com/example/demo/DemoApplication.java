package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Locale;

//@Controller
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	//	@RequestMapping("/")
//	String home() {
//		return "redirect:countries";
//	}


	/**
	 * 自定义视图解析器
	 * @return
	 */
	@Bean
	public ViewResolver myViewResolver(){
		return new MyViewResolver();
	}
	private static class MyViewResolver implements ViewResolver{

		@Override
		public View resolveViewName(String s, Locale locale) throws Exception {
			return null;
		}
	}
}
