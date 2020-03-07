package pb.spring.mypetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "vets")
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_speciality",joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities = new HashSet<>();


    public Vet() {

    }

    public Vet(String firstName, String lastName) {
        super(firstName, lastName);
    }

}
