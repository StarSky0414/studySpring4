package service.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *  死信队列
 */
@Service
public class DLXExchange {

    @Autowired
    private ConnectionFactory connectionFactory;

    // 死信队列的交换器
    public static final String DLX_EXCHANGE = "dlx_exchange";
    // 死信队列的队列名
    public static final String DLX_QUEUE="dlx_queue";
    // 死信队列的路由键
    public static final String DLX_ROUTING="dlx_routing";

    @PostConstruct
    public void Init() throws IOException, TimeoutException {
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(DLX_EXCHANGE,MQConfig.MQ_TYPE_DIRECT,true,false,null);
        channel.queueDeclare(DLX_QUEUE,true,false,false,null);
        channel.queueBind(DLX_QUEUE,DLX_EXCHANGE,DLX_ROUTING);
    }

}
