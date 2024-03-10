package org.example.crud_services;

import org.example.HibernateUtil;
import org.example.entities.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


public class ClientCrudService {
    private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
    public void create (Client entity) {
        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        }
    }
    public Client read(Long id) {
        Client client;
        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            client = session.get(Client.class, id);
            transaction.commit();
        }
        return client;
    }
    public void update(Client client) {
        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(client);
            transaction.commit();
        }
    }
    public void delete(Client client) {
        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.delete(client);
            transaction.commit();
        }
    }
    public List<Client> getAllClients(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Client> clientList = session.createQuery("from Client", Client.class).list();

        //I didn't find the better way to avoid the LazyInitializationException
        for (Client client : clientList) {
            client.getTickets().size();
        }

        transaction.commit();
        session.close();

        return clientList;
    }
}
