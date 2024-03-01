package org.example;

import org.example.entities.Client;
import org.example.entities.Planet;
import org.example.entities.Ticket;


public class Main {
    public static void main(String[] args) {
        /// the first part of the task
        CrudService<Client> clientCrudService = new CrudService<>(Client.class);
        Client newClient = new Client();
        newClient.setName("TestName");
        clientCrudService.create(newClient);
        System.out.println("Client Test Name (11) = " + clientCrudService.read(11L).getName());
        ///
        Client readClient = clientCrudService.read(1L);
        System.out.println("Client number 1 : " + readClient.getName());
        readClient.setName("NewPeter");
        clientCrudService.update(readClient);
        readClient = clientCrudService.read(1L);
        System.out.println("Client number 1 after updating: " + readClient.getName() + "\n");


        /// the second part of the task
        CrudService<Planet> planetCrudService = new CrudService<>(Planet.class);
        Planet newPlanet = new Planet();
        newPlanet.setId("VEN");
        newPlanet.setName("Venus");
        planetCrudService.create(newPlanet);
        System.out.println("New Planet was created = " + planetCrudService.read("VEN"));
        ///
        Planet nepPlanet = planetCrudService.read("NEP");
        nepPlanet.setName("NewNeptune");
        planetCrudService.update(nepPlanet);
        System.out.println("Neptune after updating = " + planetCrudService.read("NEP") + "\n");


        /// the third part of the task
        CrudService<Ticket> ticketCrudService = new CrudService<>(Ticket.class);
        Ticket newTicket = new Ticket();
        newTicket.setClient(clientCrudService.read(1L));
        newTicket.setFromPlanet(planetCrudService.read("MAR"));
        newTicket.setToPlanet(planetCrudService.read("NEP"));
        ticketCrudService.create(newTicket);
        System.out.println("AllTickets = " + ticketCrudService.getAllTickets().size());
        ticketCrudService.delete(newTicket);
        System.out.println("AllTickets after deleting = " + ticketCrudService.getAllTickets().size() + "\n");
        ///
        Ticket ticket = ticketCrudService.read(1L);
        System.out.println(ticket + "\n");
        ticket.setToPlanet(planetCrudService.read("SAT"));
        ticketCrudService.update(ticket);
        System.out.println("AFTER UPDATING \"toPlanet\": \n" + ticket);

        HibernateUtil.getInstance().close();
    }
}