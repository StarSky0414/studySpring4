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
 * 消费者 进行信道连接
 */

@Service
public class ConsumerConnection {

    private Connection connection;

    public static final Logger logger = Logger.getLogger(ConsumerConnection.class);

    /**
     *  {@code @PostConstruct} 是 {@code @Service} 初始化方法
     *  但是执行两次原因尚不清楚
     */
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
        // 初始化成功后还是进行与MQ服务器的连接
    }


    @Bean(name = "connection")
    public Connection getConnection(){
        return connection;
    }

    /**
     *  获取现有消息列表
     *  存在本地的List
     * @return 消息列表，叠加
     */
    public List<String> getChannelMessage() {
        List<String> consumerMessageLis = MyConsumer.getConsumerMessageList();
        return consumerMessageLis;
    }
}
