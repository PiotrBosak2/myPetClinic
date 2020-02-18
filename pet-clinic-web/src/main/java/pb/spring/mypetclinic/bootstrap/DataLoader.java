package pb.spring.mypetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pb.spring.mypetclinic.model.Owner;
import pb.spring.mypetclinic.model.PetType;
import pb.spring.mypetclinic.model.Vet;
import pb.spring.mypetclinic.services.OwnerService;
import pb.spring.mypetclinic.services.PetTypeService;
import pb.spring.mypetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private  final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petService;

    //@Autowired   for constructor not needed
    public DataLoader(OwnerService ownerService, VetService vetService,PetTypeService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogType = petService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCatType = petService.save(cat);








        Owner owner1 = new Owner();

        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();

        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("twoj");
        owner3.setLastName("stary");

        ownerService.save(owner3);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);




        System.out.println("Loaded Vets....");
    }
}
