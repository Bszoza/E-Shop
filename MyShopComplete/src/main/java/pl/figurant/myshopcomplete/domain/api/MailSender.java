package pl.figurant.myshopcomplete.domain.api;


import java.util.List;
import java.util.Properties;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import pl.figurant.myshopcomplete.domain.user.UserDao;

public class MailSender {
    private static final String EMAIL_FROM = "figurantshop@gmail.com";
    private static final String APP_PASS = "zdcq wvoc ishc aqbx";

    public void sendCompanyOrderConfirmation(CompanyOrderInfo order) throws Exception {
        Message message = new MimeMessage(getEmailSession());
        message.setFrom(new InternetAddress(EMAIL_FROM));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(order.getEmail()));
        message.setSubject("Potwierdzenie zamówienia");
        message.setText("Dane zamówienia:\n " + order.toString());
        Transport.send(message);
    }

    public void sendPrivateOrderConfirmation(PrivateOrderInfo order) throws Exception {
        Message message = new MimeMessage(getEmailSession());
        message.setFrom(new InternetAddress(EMAIL_FROM));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(order.getEmail()));
        message.setSubject("Potwierdzenie zamówienia");
        message.setText("Dane zamówienia:\n " + order.toString());
        Transport.send(message);
    }

    public void sendAccountConfirmation(UserRegistration user, String basePath, String code) throws Exception {
        // Konstrukcja pełnego linku weryfikacyjnego
        String verificationLink = basePath + "/signup?verificationCode=" + code;

        // Tworzenie wiadomości e-mail
        Message message = new MimeMessage(getEmailSession());
        message.setFrom(new InternetAddress(EMAIL_FROM));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
        message.setSubject("Potwierdzenie konta");
        message.setText("Witaj " + user.getName() + ",\n\n"
                + "Dziękujemy za rejestrację w naszym sklepie! Aby aktywować swoje konto, wpisz poniższy kod:\n\n"
                + code + "\n" + "Jeśli zamknąłeś strone wejdź na ten link(Konto zostanie aktywowane): " + verificationLink + "\n\n"
                + "Pozdrawiamy,\nZespół sklepu");
        Transport.send(message);
    }

    public void sendNewsLetter() throws Exception {
        List<String> emails;
        UserDao userDao = new UserDao();
        emails = userDao.getEmails();
        for (String email : emails) {
            Message message = new MimeMessage(getEmailSession());
            message.setFrom(new InternetAddress(EMAIL_FROM));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Newsletter");
            message.setText("Sprawdź nasze najnowsze przeceny!\nTrwają do 30.05.2025 ");
            Transport.send(message);
        }
    }

    private static Session getEmailSession() {
        return Session.getInstance(getGmailProperties(), new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL_FROM, APP_PASS);
            }
        });
    }

    private static Properties getGmailProperties() {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        return prop;
    }
}
