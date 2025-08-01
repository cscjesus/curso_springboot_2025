package edu.leon.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Value("${empleosapp.ruta.imagenes}")
    private String rutaImagenes;

    @Value("${empleosapp.ruta.cv}")
    private String rutaCv;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/logos/**")
//                .addResourceLocations("file:/var/img-vacantes/");
                .addResourceLocations("file:"+rutaImagenes);

        registry.addResourceHandler("/cv/**")
                .addResourceLocations("file:"+rutaCv);
    }

}