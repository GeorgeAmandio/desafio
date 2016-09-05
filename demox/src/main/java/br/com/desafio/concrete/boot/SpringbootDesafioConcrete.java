package br.com.desafio.concrete.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SuppressWarnings("deprecation")
@EnableAutoConfiguration
@ComponentScan
@Configuration
@SpringBootApplication
public class SpringbootDesafioConcrete{
	
	@Bean
	public FilterRegistrationBean jwtFilter() {
		
	        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
	        registrationBean.setFilter(new JwtFilter());
	        registrationBean.addUrlPatterns("/api/*");

	        return registrationBean;
	    }

  public static void main(String[] args) {
    SpringApplication.run(SpringbootDesafioConcrete.class, args);
  }
 
}
