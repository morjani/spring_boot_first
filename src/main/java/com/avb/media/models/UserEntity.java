package com.avb.media.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 7328729124877815488L;

    @Id
    private Integer userId;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String passdword;

    @ManyToMany
    @JoinTable(name = "user_roles",joinColumns = @JoinColumn(name="userId"),
            inverseJoinColumns = @JoinColumn(name="roleId")
    )
    private List<UserEntity> users;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private UserProfile profile;

}
