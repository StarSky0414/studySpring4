package service.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 *  备用交换器
 *  说明：
 *
 */
@Service
public class AlternateExchange {

    @Autowired
    private MQConfig mqConfig;

    @Autowired
    private ConnectionFactory connectionFactory;

    public static final String AE_EXCHANGE = "ae_exchange";
    public static final String AE_QUEUE_NAME = "ae_queue_name";
    public static final String AE_ROUTING_KEY = "ae_routing_key";


    @PostConstruct
    public void setProducterConnection() throws IOException, TimeoutException {
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();


        channel.exchangeDeclare(AE_EXCHANGE,"fanout",true,false,null);
        channel.queueDeclare(AE_QUEUE_NAME,true,false,false,null);
        channel.queueBind(AE_QUEUE_NAME,AE_EXCHANGE,"");
//        return channel;
    }
}
