package pb.spring.mypetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

    public Visit(){

    }

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public Visit(LocalDate date, String description, Pet pet) {
        this.date = date;
        this.description = description;
        this.pet = pet;
    }

}
