package com.avb.media.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "ligne_facture")
@Data
@ToString
public class LigneFactureEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 6198158848628878575L;

    @EmbeddedId
    private LigneFactureKey id;

    @ManyToOne
    @MapsId("FactureId")
    @JoinColumn(name = "facture_id")
    private FactureEntity facture;

    @ManyToOne
    @MapsId("ProduitId")
    @JoinColumn(name = "produit_id")
    private ProduitEntity produit;

    @Column(nullable = false)
    private double quantitie;
}
