package com.example.mybatis.config;

import com.example.mybatis.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

// 这个很重要，注解这个类为配置类
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        //注册自己的拦截器并设置拦截的请求路径
        // 以下表示/plus/user/下的所有方法进入拦截器
        String [] addPathPatterns = {
             "/plus/user/**"
        };
        // 这个里边的表示不进入拦截器
        String [] excludePathPatterns = {
            "/plus/user/helloworld"
        };
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);
        //有多个多加几行
        super.addInterceptors(registry);
    }
}
