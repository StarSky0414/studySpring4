package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/message")
public class SendMessage {

    @RequestMapping(value = "/send")
    public ModelAndView sendMessageView(){
//        return "index.html";
        return new ModelAndView("index");
    }
}
