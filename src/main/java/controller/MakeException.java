package controller;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MakeException {

    @RequestMapping(value = "/error")
    public void error(@ModelAttribute("msg") String msg){
        throw new IllegalArgumentException("错误来自。@ModelAttribute"+msg);
    }
}
