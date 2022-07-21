package com.footballequalizer.domain;

import lombok.*;

import javax.persistence.*;

@Entity(name = "SKILLS_POINTS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SkillsPoints {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    @Column(unique = true)
    private Long id;

    private final int sprintPoints = 0;
    private final int jumpPoints = 0;
    private final int ballControlPoints = 0;
    private final int shotPoints = 0;
    private final int beepTestPoints = 0;

    @OneToOne(mappedBy = "skillsPoints")
    private User user;
}
