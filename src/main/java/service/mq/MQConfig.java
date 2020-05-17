package service.mq;

import com.rabbitmq.client.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  mq的参数设定
 */
@Configuration
public class MQConfig {
    public static String IP = "luojunyuan.com";
    public static String EXCHANGE_NAME = "exchange_name";
    public static String QUEUE_NAME = "queue_name";
    public static String ROUTING_KEY = "routing_key";
    // 生产者测试消息不可达使用的参数
    public static String ROUTING_KEY_ERROR = "routing_key_error";
    public static int PORT = 5672;
    public static String NAME = "MQTest";
    public static String PASSWORD = "MQTest";


    @Bean
    public ConnectionFactory getProductConnection(){
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(MQConfig.IP);
        connectionFactory.setPort(MQConfig.PORT);
        connectionFactory.setUsername(MQConfig.NAME);
        connectionFactory.setPassword(MQConfig.PASSWORD);
        return  connectionFactory;
    }
}
