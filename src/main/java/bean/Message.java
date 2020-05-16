package bean;

public class Message {

    private String messageInfo;

    public String getMessageInfo() {
        return messageInfo;
    }

    public void setMessageInfo(String messageInfo) {
        this.messageInfo = messageInfo;
    }


    @Override
    public String toString() {
        return "Message{" +
                "messageInfo='" + messageInfo + '\'' +
                '}';
    }
}
