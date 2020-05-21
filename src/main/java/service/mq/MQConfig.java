package service.mq;

import com.rabbitmq.client.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * mq的参数设定
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

    public static final String MQ_TYPE_FANOUT = "fanout";
    public static final String MQ_TYPE_DIRECT = "direct";

    // 最长时间参数
    public static final String KEY_PARAMETER_TTL = "x-message-ttl";
    // 备用交换器
    public static final String ALTERNATE_EXCHANGE = "alternate-exchange";
    // 死信队列
    public static final String DLX_EXCHANGE = "x-dead-letter-exchange";
    public static final String DLX_ROUTING = "x-dead-letter-routing-key";

    @Bean
    public ConnectionFactory getProductConnection() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(MQConfig.IP);
        connectionFactory.setPort(MQConfig.PORT);
        connectionFactory.setUsername(MQConfig.NAME);
        connectionFactory.setPassword(MQConfig.PASSWORD);
        return connectionFactory;
    }
//
//    /**
//     *  设定超时时间
//     * @param time 超时时间，单位是毫秒
//     * @return 目前参数列表
//     */
//    public Map<String, Object> setTTL(int time){
//        map.put(KEY_PARAMETER_TTL,time);
//        return map;
//    }
//
//    /**
//     *  设定备用交换路由
//     * @param aeExchangeName 备用交换路由名称
//     * @return 目前参数列表
//     */
//    public Map<String, Object> setAEExchange(String aeExchangeName){
//        map.put("alternate-exchange",aeExchangeName);
//        return map;
//    }

//
//    public Map<String, Object> getParmMap() {
//        return map;
//    }
}
