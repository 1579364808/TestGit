package com.example.boot.config;

import com.example.boot.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: LiuLei
 * @date: 2022/9/3 18:26
 * @description:
 */



/*1.编写一个拦截器实现HandlerInterceptor接口
2.拦截器注册到容器中(实现WebMvcCongiguer的addInterceptor)
3.指定拦截规则【如果是拦截所有，静态资源也会被拦截】*/

@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")//所有请求都被拦截   包括静态资源
                .excludePathPatterns("/", "/login","/css/**","/fonts/**","/images/**","/js/**");
    }
}
