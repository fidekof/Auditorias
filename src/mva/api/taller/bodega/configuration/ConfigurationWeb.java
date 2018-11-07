package mva.api.taller.bodega.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import mva.api.taller.bodega.controller.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableWebMvc
@ComponentScans(value = {
        @ComponentScan(value = "mva.api.taller.bodega.services"),
        @ComponentScan(value = "mva.api.taller.bodega.bo")
})
public class ConfigurationWeb implements WebMvcConfigurer {


    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        ObjectMapper objectMapper = new ObjectMapper();
        converters.add(new MappingJackson2HttpMessageConverter(objectMapper));
    }


    @Bean
    public InternalResourceViewResolver resolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".html");
        return resolver;
    }


    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        // Register resource handler for CSS and JS
        registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/")
                .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());

        // Register resource handler for images
        registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/resources/images/")
                .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
    }

    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    //|===============>  BEANS <==============|
    @Bean
    public ControllerAuditorias controllerAuditorias() {
        return new ControllerAuditorias();
    }


    @Bean
    public ControllerCounts controllerCounts() {
        return new ControllerCounts();
    }


    @Bean
    public ControllerInventario controllerInventario() {
        return new ControllerInventario();
    }


    @Bean
    public ControllerInventarioVistas controllerInventarioVistas() {
        return new ControllerInventarioVistas();
    }
    //--------------------------- MARCOS ------------------------------

    @Bean
    public ControllerLogin controllerLogin() {
        return new ControllerLogin();
    }

    @Bean
    public ControllerUsuario controllerUsuario() {
        return new ControllerUsuario();
    }

    //-----------------------------------------------------------------
}
