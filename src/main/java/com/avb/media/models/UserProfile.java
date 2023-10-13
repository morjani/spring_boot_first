package com.avb.media.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.processing.Generated;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "profiles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile implements Serializable {
    @Serial
    private static final long serialVersionUID = 3011722602475085768L;

    @Id
    @GeneratedValue
    private Integer id;

    private String avatar;

    private String telephone;

    @OneToOne()
    @JoinColumn(name = "user_id")
    private UserEntity user;


}
