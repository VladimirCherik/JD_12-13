package org.example;

import org.example.crud_services.ClientCrudService;
import org.example.crud_services.PlanetCrudService;
import org.example.crud_services.TicketCrudService;
import org.example.entities.Client;
import org.example.entities.Planet;
import org.example.entities.Ticket;



public class Main {
    public static void main(String[] args) {

        ClientCrudService clientCrud = new ClientCrudService();
        PlanetCrudService planetCrud = new PlanetCrudService();
        TicketCrudService ticketCrud = new TicketCrudService();

        /// the first part of the task
        Client newClient = new Client();
        newClient.setName("TestName");
        clientCrud.create(newClient);
        System.out.println("Client Test Name (11) = " + clientCrud.read(11L).getName());
        ///
        Client readClient = clientCrud.read(1L);
        System.out.println("Client number 1 : " + readClient.getName());
        readClient.setName("NewPeter");
        clientCrud.update(readClient);
        readClient = clientCrud.read(1L);
        System.out.println("Client number 1 after updating: " + readClient.getName() + "\n");
//
//
        /// the second part of the task
        Planet newPlanet = new Planet();
        newPlanet.setId("VEN");
        newPlanet.setName("Venus");
        planetCrud.create(newPlanet);
        System.out.println("New Planet was created = " + planetCrud.read("VEN"));
        ///
        Planet nepPlanet = planetCrud.read("NEP");
        nepPlanet.setName("NewNeptune");
        planetCrud.update(nepPlanet);
        System.out.println("Neptune after updating = " + planetCrud.read("NEP") + "\n");
        System.out.println("_________________________________________________________________");


        /// the third part of the task
        Ticket newTicket = new Ticket();
        newTicket.setClient(clientCrud.read(1L));
        newTicket.setFromPlanet(planetCrud.read("MAR"));
        newTicket.setToPlanet(planetCrud.read("NEP"));
        ticketCrud.create(newTicket);
        System.out.println("The ticket that has been created = " + ticketCrud.read(11L));
        ticketCrud.delete(newTicket);
        System.out.println("Number of all tickets after deleting = " + ticketCrud.getAllTickets().size());
        ///
        Ticket ticket = ticketCrud.read(1L);
        System.out.println(ticket + "\n");
        ticket.setToPlanet(planetCrud.read("SAT"));
        ticketCrud.update(ticket);
        System.out.println("TICKET AFTER UPDATING \"toPlanet\": \n" + ticket + "\n");



        //To get all entities
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("AllClients() = " + clientCrud.getAllClients());
        System.out.println("AllPlanets() = " + planetCrud.getAllPlanets());
        System.out.println("AllTickets() = " + ticketCrud.getAllTickets());


        HibernateUtil.getInstance().close();
    }
}