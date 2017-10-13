package com.hp.up.core.Entity;

/**
 * @Author haopeng
 * @Date 2017/10/13 9:52
 */
public class MailEntity {
   //收件人账户
    private String receiverMailAccount;
    //邮件主题
    private String topic;
    //邮件内容
    private String content;

    public MailEntity() {
    }

    public MailEntity(String topic, String content,String receiverMailAccount) {
        this.topic = topic;
        this.content = content;
        this.receiverMailAccount = receiverMailAccount;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReceiverMailAccount() {
        return receiverMailAccount;
    }

    public void setReceiverMailAccount(String receiverMailAccount) {
        this.receiverMailAccount = receiverMailAccount;
    }

    @Override
    public String toString() {
        return "MailEntity{" +
                "receiverMailAccount='" + receiverMailAccount + '\'' +
                ", topic='" + topic + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
