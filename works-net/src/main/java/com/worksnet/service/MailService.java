package com.worksnet.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.worksnet.model.User;
import com.worksnet.utils.MailMessageBuilder;

/**
 * @author maxim.levicky
 *         Date: 3/27/13
 *         Time: 10:23 AM
 */
@Service
public class MailService {
    @Autowired
    protected MailSender mailSender;

    @Autowired
    protected MailMessageBuilder messageBuilder;

    public void sendEmailConfirmation(User user, Locale locale) {
        sendMail(messageBuilder.buildEmailConfirmation(user, "some url", locale)); //TODO: make link generation
    }

    public void sendMail(SimpleMailMessage message) {
        mailSender.send(message);
    }

    public MailSender getMailSender() {
        return mailSender;
    }

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }
}
