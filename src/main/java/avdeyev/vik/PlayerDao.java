package avdeyev.vik;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public class PlayerDao {

    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public Optional<Player> findById(Long id) {
        Session session = sessionFactory.openSession();
        Player player = session.find(Player.class, id);
        session.close();
        return Optional.ofNullable(player);
    }


    public static void save(Player player) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.persist(player);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void delete(Player player) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.remove(player);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Поиск через HQLQuery

    public static List<Player> findAll() {
        Session session = sessionFactory.openSession();
        List<Player> list = session.createQuery("from Player", Player.class).list();
        session.close();
        return list;
    }


    public static List<Player> findAllByBirthDateGreater(LocalDate date) {
        Session session = sessionFactory.openSession();
        Query<Player> query = session.createQuery("select p from Player p where p.birthDate>=:date", Player.class); // добавляем алиас p
        query.setParameter("date",date);
        List<Player> list = query.list();
        session.close();
        return list;
    }


}
