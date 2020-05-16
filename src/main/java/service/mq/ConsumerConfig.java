package service.mq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.ejb.Schedule;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.slf4j.Logger;

//@Service
//@Scope("prototype")
public class ConsumerConfig extends DefaultConsumer  {

//    @Autowired
//    ConsumerConnection consumerConnection;
//
    private static List<String> consumerMessageList = new ArrayList<>();
    private static Logger logger = LoggerFactory.getLogger(ConsumerConfig.class);

    private Channel channel;

    public ConsumerConfig(Channel channel) {
        super(channel);
        this.channel = channel;
    }

    public void getConsumerMessage(){
        try {
            channel.basicConsume(MQConfig.QUEUE_NAME,this);
        } catch (IOException e) {
            e.printStackTrace();
        }
//            TimeUnit.SECONDS.sleep(5);
//            channel.close();

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
