package pb.spring.mypetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import pb.spring.mypetclinic.model.Pet;

import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PetServiceMapTest {
    public static final String NAME = "doggy";
    public static final long id = 1L;
    Pet testPet;

    PetServiceMap service;

    @BeforeEach
    void setUp() {
        testPet = new Pet();
        testPet.setName(NAME);
        testPet.setId(id);
        service = new PetServiceMap();
        service.save(testPet);
    }

    @Test
    void findAll() {
        Set<Pet> pets = service.findAll();
        assertNotNull(pets);
        assertEquals(1,pets.size());


    }

    @Test
    void findById() {
        Pet pet = service.findById(id);
        assertNotNull(pet);
        assertEquals(id,pet.getId());
    }

    @Test
    void save() {
        Long l = 2L;
        Pet pet = new Pet();
        pet.setId(l);
        Pet savedPet = service.save(pet);
        assertEquals(l,savedPet.getId());
    }

    @Test
    void delete() {
        service.delete(testPet);
        assertEquals(0,service.findAll().size());
    }

    @Test
    void deleteById() {
        service.deleteById(id);
        assertEquals(0,service.findAll().size());
    }
}