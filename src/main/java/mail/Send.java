package mail;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {
    private static final String QUEUE_NAME="ncp.piles.email-demo";

    public static void main(String[] args) throws IOException, TimeoutException {
        //获取一个链接
        Connection connection = ConnectionUtils.getConnection();
        //获取一个通道
        Channel channel = connection.createChannel();
        //创建队列声明
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        String msg = "hello simple!";
        channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
        System.out.println("-- send msg: "+msg);

        channel.close();
    }
}