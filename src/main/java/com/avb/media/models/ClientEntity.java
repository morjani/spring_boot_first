package com.avb.media.models;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import javax.annotation.processing.Generated;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientEntity implements Serializable{

    @Serial
    private static final long serialVersionUID = 4461058080433947905L;

    @Id()
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;

    @Column(name = "client_telephone")
    private String telephone;

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL,fetch  = FetchType.LAZY)
    private List<FactureEntity> factures;

}
