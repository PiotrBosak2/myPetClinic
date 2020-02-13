package pb.spring.mypetclinic.services;

import org.springframework.data.repository.CrudRepository;
import pb.spring.mypetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(String lastName);

     Owner findById(Long Id);

     Owner save(Owner owner);

     Set<Owner> findAll();
}
