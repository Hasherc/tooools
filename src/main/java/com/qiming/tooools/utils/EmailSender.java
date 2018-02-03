package com.qiming.tooools.utils;


import com.qiming.tooools.model.Email;
import com.qiming.tooools.model.Event;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.util.Map;

/**
 * @tooools
 * @Description:
 * @Author: qming_c
 * @Date: 2018-02-03-21:48
 */
@Component
public class EmailSender {

    private Logger logger = Logger.getLogger(EmailSender.class);


    @Autowired
    Configuration configuration;

    @Value("${spring.mail.port}")
    private  int port;

    @Value("${spring.mail.protocol}")
    private String protocol;

    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.password}")
    private String password;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.default-encoding}")
    private String defaultEncoding;

    @Value("${spring.mail.properties.default-mail-to}")
    private String defaultTo;

    @Value("${spring.freemarker.suffix}")
    private String suffix;



    public void sendEmail(Event event){
        Map<String, Object> map = event.getEventProperties();
        Email email = (Email) map.get("email");
        try {
            HtmlEmail htmlEmail = new HtmlEmail();
            htmlEmail.setSubject(email.getSubject());
            htmlEmail.setHostName(host);
            htmlEmail.setSmtpPort(port);
            htmlEmail.setSSLOnConnect(true);
            htmlEmail.setCharset(defaultEncoding);
            htmlEmail.setFrom(username, email.getFromName(), defaultEncoding);
            htmlEmail.setMsg(getHtmlMessage(email.getTemplateName(),email.getModel()));
            htmlEmail.setAuthentication(username, password);

            if (email.getTo() != null){
                htmlEmail.addTo(email.getTo());
            }else {
                htmlEmail.addTo(defaultTo);
            }

            System.out.println(htmlEmail.send());
        } catch (EmailException e) {
            logger.error("邮件发送错误"+e);
            e.printStackTrace();
        }
    }

    private String getHtmlMessage(String templateName,  Map<String, Object> map){
        try {
            Template template = configuration.getTemplate(templateName + suffix);
            return FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
        } catch (IOException e) {
            logger.error("获取模版文件出错" + e);
        } catch (TemplateException e) {
            logger.error("模版" + templateName + "解析出错"+ e);
        }
        return "";

    }
}
