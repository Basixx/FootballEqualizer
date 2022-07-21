package com.footballequalizer.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "TEAMS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    @Column(unique = true)
    private Long id;

    @Column(name = "MATCH_DATE")
    private LocalDateTime matchDate;

    @ManyToMany(targetEntity = User.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "TEAMS_HAVE_USERS",
               joinColumns =        {@JoinColumn(name = "TEAM_ID", referencedColumnName = "ID")},
               inverseJoinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")})
    private final Set<User> userList = new HashSet<>();
}
