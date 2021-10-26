package Sykodev.Steam.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Achat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String jeu;

    @Column
    private Date achat;

    @Column
    private double prix;

    @ManyToMany(mappedBy = "achatJeu")
    private Set<Steam> steams;
}
