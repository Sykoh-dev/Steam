package Sykodev.Steam.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "jeu")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Jeu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private double prix;

    @Column
    private double espaceDisque;

    @Column
    private Date dateDeParution;

    @Column
    private String editeur;

    @Column
    private String evaluation;

    @ManyToMany(mappedBy = "jeux")
    private Set<Steam> steams;

}
