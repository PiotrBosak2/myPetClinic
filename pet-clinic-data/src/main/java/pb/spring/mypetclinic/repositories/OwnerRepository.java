package pb.spring.mypetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pb.spring.mypetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner,Long> {

    Owner findByLastName(String lastName);
}
