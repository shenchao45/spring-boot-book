package com.shenchao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by shenchao on 2017/2/21.
 */
@Configuration
@EnableWebMvc
@ComponentScan
public class MvcConfig {
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver resourceViewResolver = new InternalResourceViewResolver("/WEB-INF/classes/views/", ".jsp");
        resourceViewResolver.setViewClass(JstlView.class);
        return resourceViewResolver;
    }
}
