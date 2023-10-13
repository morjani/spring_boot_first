package com.avb.media.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 241748712148434970L;
    @Id
    private Integer roleId;
    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name = "user_roles",joinColumns = @JoinColumn(name="roleId"),
            inverseJoinColumns = @JoinColumn(name="userId")
    )
    private List<RoleEntity> roles;

}
