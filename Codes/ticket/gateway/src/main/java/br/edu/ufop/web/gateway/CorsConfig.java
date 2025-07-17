package br.edu.ufop.web.gateway;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

// https://docs.spring.io/spring-framework/reference/web/webmvc-cors.html

@Configuration
@EnableWebFlux
public class CorsConfig implements WebFluxConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**");		
	}
}