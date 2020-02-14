package pb.spring.mypetclinic.services;

import org.springframework.data.repository.CrudRepository;
import pb.spring.mypetclinic.model.Owner;



public interface OwnerService extends CrudService <Owner,Long> {

    Owner findByLastName(String lastName);


}
