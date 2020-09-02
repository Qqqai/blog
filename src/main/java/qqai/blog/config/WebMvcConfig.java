package qqai.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import qqai.blog.interceptor.UserInterceptor;

import java.util.Arrays;

/**
 * 描述：mvc配置
 *
 * @author qqai
 * @createTime 2020-08-30 14:18
 */

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private UserInterceptor userInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userInterceptor).addPathPatterns("/**")
                .excludePathPatterns(Arrays
                        .asList("/css/**","/editormd/**","/images/**",
                                "/prism/**","/qrcode/**","/tocbot/**","/waypoints/**",
                                "/favicon.ico", "/showdown.min.js"));
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
////        WebMvcConfigurer.super.addResourceHandlers(registry);
//    }
}
