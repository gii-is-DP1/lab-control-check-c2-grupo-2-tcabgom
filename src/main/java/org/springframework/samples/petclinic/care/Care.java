package org.springframework.samples.petclinic.care;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.PetType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cares")
public class Care extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotEmpty
    @Size(min = 3, max = 40)
    @Column(unique = true)
    String name;

    @Min(value = 1)
    @Max(value = 120)
    int careDuration;

    @ManyToMany(cascade = CascadeType.ALL)
    @NotEmpty
    @JoinTable(
        name = "care_pet_type",
        joinColumns = @JoinColumn(name="care_id"),
        inverseJoinColumns = @JoinColumn(name= "pet_type_id"))
    Set<PetType> compatiblePetTypes;

    @ManyToMany(cascade = CascadeType.ALL)
    @NotEmpty
    @JoinTable(
        name = "care_incompatibilities",
        joinColumns = @JoinColumn(name="base_care_id"),
        inverseJoinColumns = @JoinColumn(name= "incompatible_care_id"))
    Set<Care> incompatibleCares;
}
