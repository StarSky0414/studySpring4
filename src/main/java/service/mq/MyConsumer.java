package service.mq;

import com.rabbitmq.client.*;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;

public class MyConsumer extends DefaultConsumer {

    private static List<String> consumerMessageList = new ArrayList<>();
    private static Logger logger = LoggerFactory.getLogger(MyConsumer.class);
    private Channel channel;

    /**
     * {@link DefaultConsumer} 继承时候强制实现的构造方法
     */
    public MyConsumer(Channel channel) {
        super(channel);
        this.channel = channel;
    }

    /**
     * 参数详细数据在 {@link Consumer#handleDelivery}.
     * 具体的是对消息内容的处理
     *
     * @param consumerTag 消息的ID
     * @param envelope    封装的对象
     * @param properties  发送者信息
     * @param body        消息体
     * @throws IOException IO异常
     */
    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//        super.handleDelivery(consumerTag, envelope, properties, body);
        logger.info("获取一条消息{}", new String(body));
        System.out.println("获取一条消息" + new String(body));
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
