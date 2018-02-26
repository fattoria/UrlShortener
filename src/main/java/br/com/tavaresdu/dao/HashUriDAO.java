package br.com.tavaresdu.dao;

import javax.transaction.Transactional;

import br.com.tavaresdu.model.HashUri;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
//import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
public class HashUriDAO {
    private Session currentSession;

    private Transaction currentTransaction;

    public HashUriDAO() {
    }

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(br.com.tavaresdu.model.HashUri.class);
        configuration.configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public void persist(HashUri hashuri) {
        getCurrentSession().save(hashuri);
    }

    public void update(HashUri hashuri) {
        getCurrentSession().update(hashuri);
    }

    public HashUri findById(int id) {
        HashUri hashuri = (HashUri) getCurrentSession().get(HashUri.class, id);
        return hashuri;
    }

    public void delete(HashUri hashuri) {
        getCurrentSession().delete(hashuri);
    }

    public List<HashUri> findAll() {
        List<HashUri> hashuris = (List<HashUri>) getCurrentSession()
                .createQuery("from hash_uri order by id").list();
        return hashuris;
    }
}