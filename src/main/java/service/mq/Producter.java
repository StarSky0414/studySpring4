package service.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 生产者
 */
@Service
public class Producter {



    private Channel channel;
    @Autowired
    private ProducterReturnListener producterReturnListener;

    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    private AlternateExchange alternateExchange;

    @PostConstruct
    public void init() {
        try {
//            channel = alternateExchange.setProducterConnection();
//            使用相同信道
            Connection connection = connectionFactory.newConnection();
            channel = connection.createChannel();
            // 创建一个交换器
            channel.exchangeDeclare(MQConfig.EXCHANGE_NAME, "direct", true, false, alternateExchange.getParameter());
            // 创建一个队列
            channel.queueDeclare(MQConfig.QUEUE_NAME, true, false, false, null);
            // 绑定交换器与队列
            channel.queueBind(MQConfig.QUEUE_NAME, MQConfig.EXCHANGE_NAME, MQConfig.ROUTING_KEY);
            channel.addReturnListener(producterReturnListener);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public void publishMessage(String message) throws IOException{
        // 将队列设置为持久化之后，还需要将消息也设为可持久化的，MessageProperties.PERSISTENT_TEXT_PLAIN
        // mandatory 是没有路由消息时候返回，也就是消息没有到队列中
        // immediate 是没有消费者时候返回，并且消息不会存入队列中，在3.0后不使用该参数
        channel.basicPublish(MQConfig.EXCHANGE_NAME, MQConfig.ROUTING_KEY_ERROR, true,MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
    }

}
