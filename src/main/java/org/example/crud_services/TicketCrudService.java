package org.example.crud_services;

import org.example.HibernateUtil;
import org.example.entities.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;


public class TicketCrudService {
    private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    public void create (Ticket entity) {
        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        }
    }
    public Ticket read(Long id) {
        Ticket ticket;
        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            ticket = session.get(Ticket.class, id);
            transaction.commit();
        }
        return ticket;
    }
    public void update(Ticket ticket) {
        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(ticket);
            transaction.commit();
        }
    }
    public void delete(Ticket ticket) {
        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.delete(ticket);
            transaction.commit();
        }
    }

    public List<Ticket> getAllTickets(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Ticket> ticketList = session.createQuery("from Ticket", Ticket.class).list();

        //I didn't find the better way to avoid the LazyInitializationException
        for (Ticket ticket : ticketList) {
            ticket.getClient().toString();
            ticket.getFromPlanet().toString();
            ticket.getToPlanet().toString();
        }

        transaction.commit();
        session.close();
        return ticketList;
    }
}
