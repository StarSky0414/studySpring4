package mail;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

public class SendMail {

    public static void main(String[] args) {

    }


    private  void sendMail(){
        boolean isSSL = true;
        String host = "smtp.exmail.qq.com";
        int port = 465;
        String from = "starsky@thethreestooges.cn";
        String to = "254143170@qq.com";
        boolean isAuth = true;
        final String username = "starsky@thethreestooges.cn";
        final String password = "BXljy52113141";

        Properties props = new Properties();
        props.put("mail.smtp.ssl.enable", isSSL);
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", isAuth);

        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("主题");
            message.setText("内容");

            Transport.send(message);
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        System.out.println("发送完毕！");
    }
}