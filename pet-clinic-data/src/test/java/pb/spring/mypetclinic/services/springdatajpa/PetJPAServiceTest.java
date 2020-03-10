package pb.spring.mypetclinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pb.spring.mypetclinic.model.Pet;
import pb.spring.mypetclinic.repositories.PetRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PetJPAServiceTest {
    @Mock
   private  PetRepository repository;

    public static final String NAME = "doggy";
    public static final long id = 1L;
    Pet pet;

    @InjectMocks
    PetJPAService service;

    @BeforeEach
    void setUp() {
        pet = new Pet();
        pet.setName(NAME);
        pet.setId(id);

    }

    @Test
    void findAll() {
        Set<Pet> setWhenReturn = new HashSet<>();
        Pet pet1 = new Pet();
        Pet pet2 = new Pet();
        pet1.setName("name");
        setWhenReturn.add(pet1);
        setWhenReturn.add(pet2);

        when(repository.findAll()).thenReturn(setWhenReturn);
        Set<Pet> pets = service.findAll();
        assertNotNull(pets);
        assertEquals(2,pets.size());
        verify(repository,times(1)).findAll();

    }

    @Test
    void findById() {
        when(repository.findById(id)).thenReturn(Optional.of(pet));
        Pet pet1 = service.findById(id);
        assertNotNull(pet1);
        assertEquals(id,pet1.getId());
        verify(repository,times(1)).findById(anyLong());
    }

    @Test
    void save() {
        Pet petToSave = new Pet();
        petToSave.setId(1L);
        petToSave.setName("dog");
        when(repository.save(any())).thenReturn(pet);
        Pet pet1 = service.save(petToSave);
        assertNotNull(pet1);
        assertEquals(id,pet1.getId());
        assertEquals(NAME,pet1.getName());
        verify(repository,times(1)).save(any());
    }

    @Test
    void delete() {
        service.delete(pet);
        assertEquals(0,service.findAll().size());
        verify(repository,times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(id);
        Pet pet = service.findById(id);
        assertNull(pet);
        verify(repository,times(1)).deleteById(anyLong());
    }
}