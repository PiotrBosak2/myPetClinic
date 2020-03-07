package pb.spring.mypetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pb.spring.mypetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
