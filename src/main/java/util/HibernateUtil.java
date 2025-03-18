package util;

import model.Staff;
import model.Banker;
import model.Person;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        Configuration configuration = new Configuration();
        Properties properties = new Properties();
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/testdbv1");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "admin123");
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");

        configuration.setProperties(properties);

        configuration.addAnnotatedClass(Banker.class);
        configuration.addAnnotatedClass(Staff.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
