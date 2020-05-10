package controller;


import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/mod")
public class ModelAttributeTestController {

    @RequestMapping(value = "/")
    public void getMod(){

    }

}
