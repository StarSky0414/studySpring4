package service.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
@DependsOn ({"connection"})
public class ConsumerMessage {

    Logger logger = Logger.getLogger(ConsumerMessage.class);

    @Autowired
    private Connection connection;

    private Channel channel;
    /**
     * 获取信道
     */
    @PostConstruct
    public void getChannelMessageAuto() {
        try {
            // 创建一个信道
            channel = connection.createChannel();
            // 最大的一次性获取64条未读消息
            channel.basicQos(64);
            // 设定要获取队列的名称，以及 DefaultConsumer 的实现类
            DefaultConsumer defaultConsumer = new  MyConsumer(channel);
            channel.basicConsume(MQConfig.QUEUE_NAME, defaultConsumer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("RabbitMQ消费者获取1个信道，开始监听");
    }


}
