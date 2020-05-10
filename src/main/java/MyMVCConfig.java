//
//import org.apache.log4j.Level;
//import org.apache.log4j.Logger;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.FilterType;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.springframework.web.servlet.view.JstlView;
//
//@EnableWebMvc
//@ComponentScan(basePackageClasses ={MyMVCConfig.class})
//@Configuration
//public class MyMVCConfig {
//
//    @Bean
//    public InternalResourceViewResolver viewResolver(){
//
//        Logger logger = Logger.getLogger("LoggerLog");
//        logger.setLevel(Level.ERROR);
//
//        logger.info("aaaaaaaaaaaa");
//
//        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
//        internalResourceViewResolver.setPrefix("/WEB-INF/classes/view/");
//        internalResourceViewResolver.setSuffix(".jsp");
//        internalResourceViewResolver.setViewClass(JstlView.class);
//        return internalResourceViewResolver;
//
//    }
//
//}
