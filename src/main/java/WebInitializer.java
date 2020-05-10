//import org.apache.log4j.Level;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.ContextLoaderListener;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletContextListener;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration;
//
//public class WebInitializer implements WebApplicationInitializer {
//
//    public void onStartup(ServletContext servletContext) throws ServletException {
//
//        System.out.println("//////////////////////////////////////");
////        AnnotationConfigWebApplicationContext rootContext =
////                new AnnotationConfigWebApplicationContext();
////        rootContext.register(config.RootConfig.class);
////
////        // Manage the lifecycle of the root application context
////        container.addListener(new ContextLoaderListener(rootContext));
//        AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = new AnnotationConfigWebApplicationContext();
//        annotationConfigWebApplicationContext.register(MyMVCConfig.class);
//        annotationConfigWebApplicationContext.setServletContext(servletContext);
//
//        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(annotationConfigWebApplicationContext));
//        dispatcher.addMapping("/");
//        dispatcher.setLoadOnStartup(1);
//
//    }
//}
