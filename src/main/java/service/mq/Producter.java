package service.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
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

    private Connection connection;

    @PostConstruct
    public void init() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(MQConfig.IP);
        connectionFactory.setPort(MQConfig.PORT);
        connectionFactory.setUsername(MQConfig.NAME);
        connectionFactory.setPassword(MQConfig.PASSWORD);
        try {
            connection = connectionFactory.newConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public void publishMessage(String message) throws IOException, TimeoutException {
        if (connection == null) {
            init();
        }

        Channel channel = connection.createChannel();
        // 创建一个交换器
        channel.exchangeDeclare(MQConfig.EXCHANGE_NAME, "direct", true, false, null);
        // 创建一个队列
        channel.queueDeclare(MQConfig.QUEUE_NAME, true, false, false, null);
        // 绑定交换器与队列
        channel.queueBind(MQConfig.QUEUE_NAME, MQConfig.EXCHANGE_NAME, MQConfig.ROUTING_KEY);
        // 将队列设置为持久化之后，还需要将消息也设为可持久化的，MessageProperties.PERSISTENT_TEXT_PLAIN
        channel.basicPublish(MQConfig.EXCHANGE_NAME, MQConfig.ROUTING_KEY, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
        channel.close();
    }


}
