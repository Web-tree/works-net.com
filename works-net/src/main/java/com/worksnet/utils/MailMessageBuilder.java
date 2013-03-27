package com.worksnet.utils;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;

import com.worksnet.model.User;

/**
 * @author maxim.levicky
 *         Date: 3/27/13
 *         Time: 10:36 AM
 */
public class MailMessageBuilder {
    @Autowired
    protected SimpleMailMessage mailMessage;

    public SimpleMailMessage buildEmailConfirmation(User user, String confirmLink, Locale locale) {
        SimpleMailMessage mailMessage = new SimpleMailMessage(this.mailMessage);
        mailMessage.setSubject("Works-net email confirmation.");
        mailMessage.setText("Confirm link: " + confirmLink);
        mailMessage.setTo(user.getEmail());
        return mailMessage;
    }
}
