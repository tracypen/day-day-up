package com.hp.up.business.service.impl;

import com.hp.up.business.service.MailService;
import com.hp.up.core.Entity.MailEntity;
import com.hp.up.core.Entity.User;
import freemarker.template.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by haopeng on 2017/10/26 9:17
 */
@Service
public class MailServiceImpl implements MailService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    JavaMailSender mailSender;

    @Autowired
    Configuration freemarkerConfiguration;

    @Override
    public void sendEmail(User obj,MailEntity mailEntity) {
        MimeMessagePreparator preparator = getMessagePreparator(obj,mailEntity);

        try {
            mailSender.send(preparator);
            logger.info("mail send sesuccss.");
        } catch (MailException ex) {
            logger.error(ex.getMessage(), ex);
        }

    }


    private MimeMessagePreparator getMessagePreparator(final User obj,final MailEntity mailEntity) {

        return new MimeMessagePreparator() {

            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
                helper.setFrom("245682819@qq.com");
                helper.setTo(mailEntity.getReceiverMailAccount());
                helper.setSubject(mailEntity.getTopic());
                Map<String, Object> model = new HashMap<String, Object>();
                model.put("user", obj);
                String text = geFreeMarkerTemplateContent(model,mailEntity.getTemplateName());
                helper.setText(text, true);
                 helper.addAttachment("github.png", new ClassPathResource("imgs/github.jpg"));
            }
        };
    }


    public String geFreeMarkerTemplateContent(Map<String, Object> model,String templateName) {
        StringBuffer content = new StringBuffer();
        try {
            content.append(FreeMarkerTemplateUtils.processTemplateIntoString(
                    freemarkerConfiguration.getTemplate(templateName), model));
            return content.toString();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception occured while processing fmtemplate:" + e.getMessage(), e);
        }
        return "";
    }


}
