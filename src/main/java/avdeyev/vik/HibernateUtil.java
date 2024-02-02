package avdeyev.vik;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Создаем объект конфигурации Hibernate и загружаем конфигурацию из hibernate.cfg.xml
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

            // Если вы используете аннотации для маппинга сущностей, то можно добавить их сюда
            // configuration.addAnnotatedClass(YourEntity.class);

            // Создаем и возвращаем фабрику сессий
            return configuration.buildSessionFactory();
        } catch (Throwable ex) {
            // Обработка ошибок, если что-то пошло не так
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Закрытие фабрики сессий при завершении работы приложения
        getSessionFactory().close();
    }
}
