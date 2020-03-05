package pb.spring.mypetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pb.spring.mypetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
