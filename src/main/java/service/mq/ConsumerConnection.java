package service.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
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

//    @Autowired
//    private ConsumerConfig consumerConfig;

    private Connection connection;

    public static final Logger logger = Logger.getLogger(ConsumerConnection.class);

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
        Channel channel = null;
        try {
            channel = connection.createChannel();
            channel.basicQos(64);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("RabbitMQ消费者获取1个信道，开始监听");

        ConsumerConfig consumerConfig = new ConsumerConfig(channel);
        consumerConfig.getConsumerMessage();
    }

    public List<String> getChannelMessage(){
        List<String> consumerMessageLis = ConsumerConfig.getConsumerMessageList();
        return consumerMessageLis;
    }
}
