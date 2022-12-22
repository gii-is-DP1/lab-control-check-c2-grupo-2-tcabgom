package org.springframework.samples.petclinic.care;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.samples.petclinic.pet.Visit;
import org.springframework.web.bind.annotation.ModelAttribute;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "care_provisions")
public class CareProvision {   

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Pattern(regexp = "^Care rated with [0-9] stars.*$")
    String userRating;

    @ManyToOne(optional = true)
    Visit visit;

    @ManyToOne(optional = false)
    @NotNull
    Care care;   
}
