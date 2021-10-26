package Sykodev.Steam.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "steam")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Steam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String bibliotheque;

    @Column
    private String aide;

    @ManyToOne
    private Client client;

    @ManyToMany
    private Set<Jeu> jeux;

    @ManyToMany
    private Set<Achat> achatJeu;

    @ManyToMany
    private Set<Remboursement> remboursementJeu;

    }


