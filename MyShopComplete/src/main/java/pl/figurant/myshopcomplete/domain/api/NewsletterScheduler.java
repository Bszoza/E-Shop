package pl.figurant.myshopcomplete.domain.api;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@WebListener
public class NewsletterScheduler implements ServletContextListener {

    private ScheduledExecutorService scheduler;
    private MailSender mailSender = new MailSender();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(this::sendNewsletter, 0, 24, TimeUnit.HOURS);
    }

    private void sendNewsletter() {
        try {
            mailSender.sendNewsLetter();
        } catch (Exception e) {
            System.err.println("Błąd przy wysyłaniu newslettera: " + e.getMessage());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        if (scheduler != null) {
            scheduler.shutdown();
        }
    }
}
