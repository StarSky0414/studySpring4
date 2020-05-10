package mail;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ConnectionUtils {

    /**
     *
     * 方法功能说明：获取MQ的链接
     * 参数说明：
     * @return
     * 作者：Administrator
     * 创建时间:2019年1月22日-下午7:51:48
     * @throws TimeoutException
     * @throws IOException
     *
     *
     */
    public static Connection getConnection() throws IOException, TimeoutException {
        //定义一个链接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置服务地址
//        factory.setHost("localhost");
        factory.setHost("192.168.174.30");
        //设定端口
        factory.setPort(5672);
//        //设定vhost
//        factory.setVirtualHost("vhost");
//        factory.set
        //设定用户名
        factory.setUsername("rabbitmq");
        //设定密码
        factory.setPassword("6y&U*I");
        return factory.newConnection();
    }
}
