package my.springboot.myspringmvc;

import my.springboot.myspringmvc.interceptor.Interceprot1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class InterceprorApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(InterceprorApplication.class, args);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器到spring mvc机制，然后它会返回一个拦截器注册
        InterceptorRegistration ir = registry.addInterceptor(new Interceprot1());
        //指定拦截匹配模式，限制拦截器拦截请求
        ir.addPathPatterns("/interceptor/*");
    }
}
