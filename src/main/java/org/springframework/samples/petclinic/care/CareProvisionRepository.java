package org.springframework.samples.petclinic.care;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.pet.PetType;

public interface CareProvisionRepository extends CrudRepository<CareProvision, Integer> {
    List<CareProvision> findAll();        
    Optional<CareProvision> findById(int id);
    CareProvision save(CareProvision p);

    @Query(value = "SELECT c FROM Care c")
	List<Care> findAllCares();

    //@Query(value = "SELECT c FROM Care c WHERE c.compatiblePetTypes IN pt AND c IS NOT MEMBER OF ac.incompatibleCares")
    //List<Care> findCompatibleCares(@Param(value = "pt") PetType petType, @Param(value = "ac") Care additionalCare);

    @Query(value = "SELECT c FROM Care c WHERE c.name = :n")
    Care findCareByName(@Param(value = "n") String name);

    //@Query(value = "SELECT c FROM CareProvision WHERE c.visit = :v")
    //List<CareProvision> findCaresProvidedByVisitId(@Param(value = "v") Integer visitId);

    //Page<CareProvision> findAllPaginatedCareProvisions(Pageable p);
}
