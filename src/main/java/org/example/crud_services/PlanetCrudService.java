package org.example.crud_services;

import org.example.HibernateUtil;
import org.example.entities.Planet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;


public class PlanetCrudService {
    private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    public void create (Planet planet) {
        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(planet);
            transaction.commit();
        }
    }

    public Planet read(String id) {
        Planet planet;
        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            planet = session.get(Planet.class, id);
            planet.getTicketsToThisPlanet().size();
            planet.getTicketsFromThisPlanet().size();
            transaction.commit();
        }
        return planet;
    }

    public void update(Planet planet) {
        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(planet);
            transaction.commit();
        }
    }
    public void delete(Planet planet) {
        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.delete(planet);
            transaction.commit();
        }
    }
    public List<Planet> getAllPlanets(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Planet> planetList = session.createQuery("from Planet", Planet.class).list();

        //I didn't find the better way to avoid the LazyInitializationException
        for (Planet p : planetList) {
            p.getTicketsToThisPlanet().size();
            p.getTicketsFromThisPlanet().size();
        }

        transaction.commit();
        session.close();
        return planetList;
    }
}
