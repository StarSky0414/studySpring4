package controller;

import bean.Message;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.mq.ConsumerConfig;
import service.mq.ConsumerConnection;
import service.mq.Producter;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;


@Controller
@RequestMapping(value = "/message")
public class SendMessage {

    @Autowired
    private Producter producter;

    @Autowired
    private ConsumerConnection consumerConnection;

    @Autowired
    private ConsumerConnection consumer;

    private static Logger logger = Logger.getLogger(SendMessage.class);

    @RequestMapping(value = "/index")
    public String MessageView(){
        return "index";
    }

    @RequestMapping(value = "/send")
    public String sendMessageView(@ModelAttribute("message") Message message) {
        logger.info(message.toString());
//        consumer.getChannelMessageAuto();
        if (StringUtils.hasText(message.getMessageInfo())){
            try {
                producter.publishMessage(message.getMessageInfo());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("messageInfo","OK!");
        }
        List<String> consumerMessageList = consumer.getChannelMessage();
        logger.info(consumerMessageList);
        return "index";
    }
}
