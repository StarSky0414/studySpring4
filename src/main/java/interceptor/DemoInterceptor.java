package interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoInterceptor extends HandlerInterceptorAdapter {

    private static Logger logger = Logger.getLogger(DemoInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        long currentTimeMillis = System.currentTimeMillis();
        System.out.println(currentTimeMillis);
        request.setAttribute("startTime",currentTimeMillis);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Long startTime = (Long) request.getAttribute("startTime");
        request.removeAttribute("startTime");
        long currentTimeMillis = System.currentTimeMillis();
        long time = currentTimeMillis - startTime;
        System.out.println("本次请求处理事件时间为："+ time);
        logger.info("本次请求处理事件时间为："+ time);
        request.setAttribute("time", time);
    }
}
