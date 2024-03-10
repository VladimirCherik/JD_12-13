package org.example.entities;

import lombok.*;
import javax.persistence.*;
import java.util.List;
import static javax.persistence.CascadeType.*;


@Entity
@Table(name = "planet")
@Data

@NoArgsConstructor
@AllArgsConstructor
public class Planet {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;


    @OneToMany(mappedBy = "toPlanet", cascade = {PERSIST, MERGE, REMOVE, DETACH})
    private List<Ticket> ticketsToThisPlanet;

    @OneToMany(mappedBy = "fromPlanet", cascade = {PERSIST, MERGE, REMOVE, DETACH})
    private List<Ticket> ticketsFromThisPlanet;


    @Override
    public String toString() {
        return "\nPlanet\n{" +
                "id='" + id + '\'' +
                ", \nname='" + name + '\'' +
                ", \nticketsToThisPlanet=" + ticketsToThisPlanet.size() +
                ", \nticketsFromThisPlanet=" + ticketsFromThisPlanet.size() +
                "}";
    }
}
