package com.footballequalizer.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "USERS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    @NotNull
    private SexStatus sex;

    @Column(unique = true)
    @NotNull
    private String emailAddress;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private final int points = 0;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "skills_points_id", referencedColumnName = "id")
    private SkillsPoints skillsPoints;

    @ManyToMany(mappedBy = "userList")
    private final Set<Team> teamList = new HashSet<>();
}
