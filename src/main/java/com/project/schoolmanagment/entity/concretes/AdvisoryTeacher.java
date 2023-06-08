package com.project.schoolmanagment.entity.concretes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdvisoryTeacher {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JsonProperty
    private UserRole userRole;

    @OneToOne
    private Teacher teacher;


}
