package com.tabdaul.tabanewsapp.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author MOSAED ALOTAIBI (MASAAD)
 * @created 10/29/2022 at 19:03
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "PRIVILEGE")
public class Privilege {

    @Id
    @SequenceGenerator(
            name = "privilege_id",
            sequenceName = "privilege_id"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "privilege_id")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "privilege_name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "privilege", orphanRemoval = true)
    private Set<UserPrivileges> users;

    public Privilege(Long id, String name, Set<UserPrivileges> users) {
        this.id = id;
        this.name = name;
        this.users = new HashSet<>();
    }
}
