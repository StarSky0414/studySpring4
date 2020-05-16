package service.mq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;

@Service
public class MyConsumer extends DefaultConsumer  {

    private static List<String> consumerMessageList = new ArrayList<>();
    private static Logger logger = LoggerFactory.getLogger(MyConsumer.class);
    private Channel channel;

    public MyConsumer(Channel channel) {
        super(channel);
        this.channel = channel;
    }

    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
        super.handleDelivery(consumerTag, envelope, properties, body);
        logger.info("获取一条消息{}",new String(body));
        System.out.println("获取一条消息"+new String(body));
        consumerMessageList.add(new String(body));
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        channel.basicAck(envelope.getDeliveryTag(),false);
    }

    public static List<String> getConsumerMessageList() {
        return consumerMessageList;
    }
}
