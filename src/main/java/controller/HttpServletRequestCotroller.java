package controller;


import bean.People;
import bean.PeopleXML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/hs")
public class HttpServletRequestCotroller {

    @Autowired
    private PeopleXML peopleXML;

    @RequestMapping()
    public  String index(HttpServletRequest httpServletRequest) {
        return "url" + httpServletRequest.getRequestURL() + " can access";
    }

    @RequestMapping(value = "/xml",produces = MediaType.APPLICATION_XML_VALUE+";charset=UTF-8")
    public PeopleXML indexXml (HttpServletRequest httpServletRequest){
        return new PeopleXML();
    }


    @RequestMapping(value = "/json",produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    public People indexJson (HttpServletRequest httpServletRequest){
        return new People();
    }


}
