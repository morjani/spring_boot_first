package com.avb.media.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
public class LigneFactureKey implements Serializable {

    @Serial
    private static final long serialVersionUID = -1896111600183386336L;

    @Column(name="facture_id")
    private Integer factureId;

    @Column(name="produit_id")
    private Integer produitId;
}
