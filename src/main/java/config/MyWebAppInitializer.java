package config;

import config.AppConfig;
import config.RootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.faces.component.html.HtmlBody;
import javax.servlet.Filter;


public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //获取跟容器的配置类  （Spring配置文件） 父容器
    @Override
    protected Class<?>[] getRootConfigClasses() {
        // TODO Auto-generated method stub
        return new Class<?>[] {RootConfig.class};
    }
    // 获取web容器的配置类 （Spring mvc配置文件） 创建子容器
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {HTMLConfig.class,AppConfig.class};
    }
    //获取DispatcherServlet的映射信息
    @Override
    protected String[] getServletMappings() {
        // /* 拦截所有亲求； 连*.jsp页面都拦截； jsp页面是Tomcat的jsp引擎解析的
        return new String[] {"/"}; //拦截所有请求 包括静态资源
    }

}