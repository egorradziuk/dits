package com.dev_incubator.dits.config;

import com.dev_incubator.dits.config.security.SecurityConfig;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.context.ConfigurableWebEnvironment;
import org.springframework.web.context.support.StandardServletEnvironment;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@Import({JpaConfig.class, SecurityConfig.class})
@ComponentScan(basePackages = "com.dev_incubator.dits")
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * указывается путь до ресурсов (js, css, itc.)
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler( "/**" )
                .addResourceLocations( "/WEB-INF/template/" );
    }

//todo эта хреновина не подымает @ModelAttribute
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/main").setViewName("main");
//        registry.addViewController("/").setViewName("main");
//    }

    @Override
    public Validator getValidator() {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.setValidationMessageSource(messageSource());
        return validator;
    }

    @Bean
    public TilesViewResolver viewResolver() {
        return new TilesViewResolver();
    }

    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions("WEB-INF/template/tiles.xml");
        return tilesConfigurer;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }
}
