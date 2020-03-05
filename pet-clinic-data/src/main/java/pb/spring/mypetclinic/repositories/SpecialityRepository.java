package pb.spring.mypetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pb.spring.mypetclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
