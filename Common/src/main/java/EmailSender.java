import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class EmailSender {
    private String to;
   private String from;
   private String host;
   private Session session;

    public EmailSender(String to) {
        this.to = to;
        this.from = Constants.EMAIL_SENDER;
        this.host = Constants.HOST;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getHost() {
        return host;
    }

    public void setHost() {
        this.host = Constants.HOST;
    }

    public void setSession() {
        Properties properties = System.getProperties();
        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        // Get the Session object.// and pass username and password
        this.session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Constants.EMAIL_SENDER, Constants.PASSWORD);
            }
        });
    }

    public void sendMessage(String filepath) {
        // Used to debug SMTP issues
        session.setDebug(true);
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));
            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // Set Subject: header field
            message.setSubject("Результаты вычислений");
            // Now set the actual message
            Multipart multipart = new MimeMultipart();
            MimeBodyPart attachmentPart = new MimeBodyPart();
            MimeBodyPart textPart = new MimeBodyPart();
            File f = new File(filepath);
            attachmentPart.attachFile(f);
            textPart.setText("Результаты вычислений во вложении");
            multipart.addBodyPart(textPart);
            multipart.addBodyPart(attachmentPart);
            message.setContent(multipart);
            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void  wrapperSendMail(String filepath){
        String email = Enter.enterEmail();
        if(!email.isEmpty()){
            EmailSender emailSender= new EmailSender(email);
            emailSender.setSession();
            emailSender.sendMessage(filepath);
        }else{
            System.out.println("email не валиден, результаты не будут отправлены");
        }
    }
}