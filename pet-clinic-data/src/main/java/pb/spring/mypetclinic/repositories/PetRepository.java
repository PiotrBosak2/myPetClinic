package pb.spring.mypetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pb.spring.mypetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
