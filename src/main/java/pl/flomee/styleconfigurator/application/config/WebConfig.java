package pl.flomee.styleconfigurator.application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("*") // Zezwól na wszystkie źródła
            .allowedMethods("*") // Zezwól na wszystkie metody (GET, POST, etc.)
            .allowedHeaders("*"); // Zezwól na wszystkie nagłówki
    }
}