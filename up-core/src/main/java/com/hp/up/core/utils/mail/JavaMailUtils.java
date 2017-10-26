package com.hp.up.core.utils.mail;

import com.hp.up.core.Entity.MailEntity;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * @Author haopeng
 * @Date 2017/10/13 9:40
 */
public class JavaMailUtils {
    // 发件人的 邮箱(qq邮箱)
    public static final String SENDER_EMAIL_ACCOUNT = "245682819@qq.com";
    //此为SMTP客户端的授权码
    public static String SENDER_EMAIL_PASSWORD = "feygrbxsnnmwbieb";
    // 发件人邮箱的 SMTP 服务器地址
    public static String SENDER_EMAIL_SMTPHOST = "smtp.qq.com";

    public static boolean senMail(MailEntity mailEntity){

        // 1. 创建参数配置
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", SENDER_EMAIL_SMTPHOST);
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
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(SENDER_EMAIL_ACCOUNT, SENDER_EMAIL_PASSWORD);
                    }
                });
        session.setDebug(true);
        // 设置为debug模式, 可以查看详细的发送 log

        // 4. 根据 Session 获取邮件传输对象
        Transport transport = null;
        try {
            // 3. 创建一封邮件
            MimeMessage message = createMimeMessage(session, SENDER_EMAIL_ACCOUNT, mailEntity);

            transport = session.getTransport();

            // 5. 使用 邮箱账号 和 密码 连接邮件服务器
            transport.connect(SENDER_EMAIL_ACCOUNT, SENDER_EMAIL_PASSWORD);

            // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
            transport.sendMessage(message, message.getAllRecipients());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            // 7. 关闭连接
            try {
                transport.close();
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * 创建一封只包含文本的简单邮件
     *
     * @param session 和服务器交互的会话
     * @param sendMail 发件人邮箱
     * @return
     * @throws Exception
     */
    public static MimeMessage createMimeMessage(Session session, String sendMail, MailEntity mailEntity) throws Exception {
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);

        // 2. From: 发件人
        message.setFrom(new InternetAddress(sendMail, "QQ邮箱", "UTF-8"));

        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(mailEntity.getReceiverMailAccount(), "245682819@qq.com", "UTF-8"));

        // 4. Subject: 邮件主题
        message.setSubject(mailEntity.getTopic(), "UTF-8");

        // 5. Content: 邮件正文（可以使用html标签）
        message.setContent(mailEntity.getContent(), "text/html;charset=UTF-8");

        // 6. 设置发件时间
        message.setSentDate(new Date());

        // 7. 保存设置
        message.saveChanges();

        return message;
    }

}
