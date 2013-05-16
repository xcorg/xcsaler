package utils;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import play.Play;
import play.libs.Mail;

/**
 * 邮件发送工具类
 * 
 * @author
 * 
 */
public class EmailUtil {

    public static void sendEmail(String msg, String mailTos, String title) {
        HtmlEmail email = new HtmlEmail();
        try {
            email.addTo(mailTos); // 收件人
            email.setFrom(Play.configuration.getProperty("email.from")); // 发件人
            email.setCharset("utf-8");
            email.setSubject(title);
            email.setHtmlMsg(msg);
            // email.setTextMsg(msg);
            Mail.send(email);
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
