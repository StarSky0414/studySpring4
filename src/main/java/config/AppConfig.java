package config;

import interceptor.DemoInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import view.Jsp;


@EnableWebMvc
////Spring mvc 只扫描controller 子容器
//@ComponentScan(basePackageClasses = {controller.HelloController.class}
////,
////        includeFilters= { @ComponentScan.Filter(type=FilterType.ANNOTATION)},
////        useDefaultFilters = false
//)  //禁用默认的过虑规则
@ComponentScan(basePackages = {"bean", "controller", "exception","service"})
@EnableAsync
@Configuration
@EnableScheduling
public class AppConfig extends WebMvcConfigurerAdapter {
    @Value("${com.dudu.name}")
    private String name;

    public AppConfig() {
        System.out.println("自定义配置文件初始化..." + name);
    }

//    @Bean
//    public ViewResolver viewResolver(){
//        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
//        internalResourceViewResolver.setPrefix("/WEB-INF/classes/view/");
//        internalResourceViewResolver.setSuffix(".jsp");
//        internalResourceViewResolver.setCache(false);
//        internalResourceViewResolver.setOrder(100);
//        internalResourceViewResolver.setViewClass(Jsp.class);
////        internalResourceViewResolver.setViewNames("**/test/**");
//        internalResourceViewResolver.setExposeContextBeansAsAttributes(true);
//        return internalResourceViewResolver;
//    }


    @Bean
    public DemoInterceptor demoInterceptor() {
        return new DemoInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor());
    }

//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        super.addResourceHandlers(registry);
        // addResourceHandler  表示请求路径
        // addResourceLocations 表示实际路径
        registry.addResourceHandler("/photo/**").addResourceLocations("classpath:/photo/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/message/index");
    }



}