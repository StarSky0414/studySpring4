package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    public HelloController() {
        System.out.println("====================================");
    }

//    @RequestMapping("/")
//    public String hello(){
//
//        return "main";
//    }

    @RequestMapping("/test/1")
    public String hello11(){
        return "test";
    }

    @RequestMapping(value = "/test/send")
    public ModelAndView sendMessageView(){
//        return "index.html";
        ModelAndView index = new ModelAndView("index");
        index.setViewName("test/send");
        return index;
    }
}
