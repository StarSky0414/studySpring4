package mail;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.AMQP.BasicProperties;

/**
 *
 * 公司:若尔丹软件开发公司
 * 类描述:获取消息
 * 作者:lizongti
 * 创建时间:2019年1月22日-下午8:09:24
 * 更新时间:
 */
public class Recv {
    private static final String QUEUE_NAME="ncp.piles.email-demo";
    public static void main(String[] args) throws IOException, TimeoutException {
        //获取链接
        Connection connection = ConnectionUtils.getConnection();
        //创建链接
        Channel channel = connection.createChannel();
        //队列声明
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        //监听队列
        channel.basicConsume(QUEUE_NAME, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
                    throws IOException {
                // TODO Auto-generated method stub
                System.out.println("接收到消息："+new String(body, "UTF-8"));
            }
        });
    }
}
