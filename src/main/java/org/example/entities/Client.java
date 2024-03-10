package org.example.entities;

import lombok.*;
import javax.persistence.*;
import java.util.List;



@Entity
@Table(name = "client")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    @Override
    public String toString() {
        return "\nClient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tickets=" + tickets.size() +
                '}';
    }
}
