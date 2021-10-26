package Sykodev.Steam.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String nom;

    @Column
    private String prenom;

    @Column
    private String mail;

    @Column
    private String adresse;



    @OneToMany(mappedBy = "client" )
    private Set<Steam> steams;

}
