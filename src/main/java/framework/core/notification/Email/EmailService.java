package framework.core.notification.Email;

//import framework.core.configuration.EmailConfiguration;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;
import framework.core.configuration.*;

public class EmailService {



    public EmailService() {
    }

    private void sendMail(EmailMessage emailMessage) {

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", EmailConfiguration.host);
        prop.put("mail.smtp.port", EmailConfiguration.port);
        prop.put("mail.smtp.ssl.trust", EmailConfiguration.host);

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EmailConfiguration.username, EmailConfiguration.password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EmailConfiguration.from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailMessage.getTo()));
            message.setSubject(emailMessage.getSubject());


            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(emailMessage.getBody(), "text/html");

            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
//            attachmentBodyPart.attachFile(new File("pom.xml"));

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            multipart.addBodyPart(attachmentBodyPart);

            message.setContent(multipart);

            Transport.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String ... args) {
        EmailService emailService = new EmailService();
        EmailMessage emailMessage = new EmailMessage("cgebru@miu.edu","Test Mail", "test message");
        emailService.sendMail(emailMessage);
    }

}