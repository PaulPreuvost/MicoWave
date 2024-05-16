package com.GAB1NMACHINE.MicoWave.Entity;

import java.util.List;

public class MicroWave {
}


package com.LeagueApplication.entity;

import jakarta.persistence.*;

@Entity
public class Journee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "saison_id")
    private Saison saison;

    @Column(unique = true)
    private String libelle;

    @OneToMany(mappedBy = "journee", cascade = CascadeType.ALL)
    private List<Match> matches;

    public Journee(){}

    public void setLibelle(String libelle) { this.libelle = libelle; }

    public void setSaison(Saison saison) { this.saison = saison; }
}
