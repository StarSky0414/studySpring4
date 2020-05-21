package service.mq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.ReturnCallback;
import com.rabbitmq.client.ReturnListener;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * 生产者的消息返回监听
 * 用于将消息投递时候查看其返回状态
 * 提供两种方法一个是正常实现接口的{@link ReturnListener}
 * 另一个是{@link ReturnCallback} 是lambda表达式使用的。
 * <p>
 * 扩展：
 * {@link ReturnCallback} 该方法中使用了 函数式接口@FunctionalInterface 该注解主要是帮助编译器进行检查是否是函数式接口
 * 一般配合 lambda 表达式使用
 */
@Service
public class ProducterReturnListener implements ReturnListener {

    Logger logger = Logger.getLogger(ProducterReturnListener.class);

    /**
     * 监听的回调方法
     *
     * @param replyCode  队列响应给浏览器的状态码
     * @param replyText  状态码对应的文本信息
     * @param exchange   交换机的名称
     * @param routingKey 路由的key
     * @param properties 消息的相关属性
     * @param body       消息体的内容
     */
    @Override
    public void handleReturn(int replyCode, String replyText, String exchange, String routingKey, AMQP.BasicProperties properties, byte[] body) throws IOException {
        logger.info("队列响应给浏览器的状态码："+replyCode);
        logger.info("状态码对应的文本信息："+replyText);
        logger.info("交换机的名称："+exchange);
        logger.info("路由的key："+routingKey);
        logger.info("消息的相关属性："+properties.toString());
        logger.info("消息体的内容："+new String(body));
    }

}
