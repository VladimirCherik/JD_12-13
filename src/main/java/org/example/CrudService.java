package org.example;

import org.example.entities.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.io.Serializable;
import java.util.List;

public class CrudService<T> {
    private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
    private final Class<T> entityClass;
    public CrudService(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    public void create (T entity) {
        Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
                session.save(entity);
            transaction.commit();
        session.close();
    }
    public T read(Serializable id) {
        T entity;

        Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
                entity = session.get(entityClass, id);
            transaction.commit();
        session.close();

        return entity;
    }
    public void update(T entity) {
        Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
                session.update(entity);
            transaction.commit();
        session.close();
    }
    public void delete(T entity) {
        Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
                session.delete(entity);
            transaction.commit();
        session.close();
    }
    public List<Ticket> getAllTickets(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Ticket> ticketList = session.createQuery("from Ticket", Ticket.class).list();

        transaction.commit();
        session.close();

        return ticketList;
    }
}
