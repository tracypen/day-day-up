package com.hp.up.business.test;

import java.util.Date;
import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @Author haopeng
 * @Date 2017/10/13 9:17
 */
public class JavaMailTest {
    // 发件人的 邮箱(qq邮箱)
    public static String senderEmailAccount = "245682819@qq.com";
    //此为SMTP客户端的授权码
    public static String senderEmailPassword = "vsinsvabodpfbgjc";
    // 发件人邮箱的 SMTP 服务器地址
    public static String senderEmailSMTPHost = "smtp.qq.com";
    // 收件人邮箱（替换为自己知道的有效邮箱）
    public static String receiverMailAccount = "18802953162@163.com";


    public static void main(String[] args) throws Exception {

        // 1. 创建参数配置
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", senderEmailSMTPHost);
        props.setProperty("mail.smtp.auth", "true");
        // SMTP 服务器的端口
        final String smtpPort = "465";
        props.setProperty("mail.smtp.port", smtpPort);
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.port", smtpPort);

        // 2. 根据配置创建会话对象, 用于和邮件服务器交互
        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(senderEmailAccount, senderEmailPassword);
                    }
                });
        session.setDebug(true);                                 // 设置为debug模式, 可以查看详细的发送 log

        // 4. 根据 Session 获取邮件传输对象
        Transport transport = null;
        try {
            // 3. 创建一封邮件
            MimeMessage message = createMimeMessage(session, senderEmailAccount, receiverMailAccount);

            transport = session.getTransport();

            // 5. 使用 邮箱账号 和 密码 连接邮件服务器
            transport.connect(senderEmailAccount, senderEmailPassword);

            // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
            transport.sendMessage(message, message.getAllRecipients());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 7. 关闭连接
            transport.close();
        }

    }

    /**
     * 创建一封只包含文本的简单邮件
     *
     * @param session 和服务器交互的会话
     * @param sendMail 发件人邮箱
     * @param receiveMail 收件人邮箱
     * @return
     * @throws Exception
     */
    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail) throws Exception {
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);

        // 2. From: 发件人
        message.setFrom(new InternetAddress(sendMail, "QQ邮箱", "UTF-8"));

        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "245682819@qq.com", "UTF-8"));

        // 4. Subject: 邮件主题
        message.setSubject("Best wishes", "UTF-8");

        // 5. Content: 邮件正文（可以使用html标签）
        message.setContent("早上好！", "text/html;charset=UTF-8");

        // 6. 设置发件时间
        message.setSentDate(new Date());

        // 7. 保存设置
        message.saveChanges();

        return message;
    }


}
