package service.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * 消费者
 */

@Service
public class ConsumerConnection {

    @Autowired
    private MyConsumer myConsumer;

    private Connection connection;

    public static final Logger logger = Logger.getLogger(ConsumerConnection.class);
    private Channel channel;

    @PostConstruct
    public void init() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setPort(MQConfig.PORT);
        connectionFactory.setHost(MQConfig.IP);
        connectionFactory.setUsername(MQConfig.NAME);
        connectionFactory.setPassword(MQConfig.PASSWORD);
        try {
            connection = connectionFactory.newConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        logger.info("RabbitMQ消费者初始化完成！");
        getChannelMessageAuto();
    }

    /**
     * 获取信道
     *
     * @return
     */
//    @Scheduled(fixedRate = 60000)
//    @Async
    public void getChannelMessageAuto() {
        channel = null;
        try {
            channel = connection.createChannel();
            channel.basicQos(64);
            channel.basicConsume(MQConfig.QUEUE_NAME,myConsumer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("RabbitMQ消费者获取1个信道，开始监听");

//        ConsumerConfig consumerConfig = new ConsumerConfig(channel);
//        consumerConfig.getConsumerMessage();
    }

    @Bean
    Channel getChannel(){
        return channel;
    }

    public List<String> getChannelMessage(){
        List<String> consumerMessageLis = MyConsumer.getConsumerMessageList();
        return consumerMessageLis;
    }
}
