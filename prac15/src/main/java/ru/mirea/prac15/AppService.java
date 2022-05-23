package ru.mirea.prac15;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Service
public class AppService {
    @Autowired
    private final SessionFactory sessionFactory;
    private Session session;

    public AppService() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
        if (session == null) initSession();
    }

    @PostConstruct
    void initSession() {
        session = sessionFactory.openSession();
    }

    @PreDestroy
    public void unSession() {
        session.close();
    }

    Session getSession() {
        return session;
    }
}