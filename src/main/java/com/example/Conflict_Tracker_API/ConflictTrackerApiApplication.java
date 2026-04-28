package com.example.Conflict_Tracker_API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@SpringBootApplication
public class ConflictTrackerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConflictTrackerApiApplication.class, args);
	}

	@Bean
	public CorsFilter corsFilter() {

		CorsConfiguration config = new CorsConfiguration();

		config.setAllowedOriginPatterns(List.of(
				"https://*.vercel.app",
				"http://localhost:5173"
		));

		config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		config.setAllowedHeaders(List.of("*"));
		config.setAllowCredentials(false);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);

		return new CorsFilter(source);
	}
}