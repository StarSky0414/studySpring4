package config;

import interceptor.DemoInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import org.apache.log4j.Logger;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Configuration
//@EnableAsync
@ComponentScan(value = "config")
public class RootConfig extends WebMvcConfigurerAdapter {
    private static Logger logger = Logger.getLogger(RootConfig.class);

    public RootConfig() {

    }
}