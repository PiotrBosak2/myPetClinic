package pb.spring.mypetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pb.spring.mypetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet,Long> {

}
