package org.example.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ticket")
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "from_planet_id", nullable = false)
    private Planet fromPlanet;

    @ManyToOne
    @JoinColumn(name = "to_planet_id", nullable = false)
    private Planet toPlanet;

    @Override
    public String toString() {
        return "TICKET:\n" +
                "id = " + id +",\n"+
                "createdAt = " + createdAt +",\n"+
                "client = " + client.getName() +",\n"+
                "fromPlanetId = " + fromPlanet.getName() +",\n"+
                "toPlanetId = " + toPlanet.getName() + ".";
    }



}
