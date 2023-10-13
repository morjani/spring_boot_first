package com.avb.media.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "produit")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduitEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 2392334712194826584L;

    @Id
    private Integer id;

    @Column(nullable = false)
    private String ref;

    @Column(nullable = false)
    private BigDecimal prix;

    @Column(nullable = false)
    private double quantity_stock;

    @OneToMany(mappedBy = "produit",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<LigneFactureEntity> ligneFactures;




}
