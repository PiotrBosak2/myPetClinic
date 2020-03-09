package pb.spring.mypetclinic.services.springdatajpa;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pb.spring.mypetclinic.model.Owner;
import pb.spring.mypetclinic.repositories.OwnerRepository;
import pb.spring.mypetclinic.repositories.PetRepository;
import pb.spring.mypetclinic.repositories.PetTypeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class OwnerJPAServiceTest {
    public static final String LAST_NAME = "Kowalski";
    public long ownerId = 1L;
    @Mock
    private OwnerRepository ownerRepository;

    @Mock
    private PetRepository petRepository;

    @Mock
    private PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerJPAService service;

    Owner returnOwner;

    @BeforeEach
    void setUp() {

        returnOwner = Owner.builder().id(ownerId).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner smith = service.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, smith.getLastName());

        verify(ownerRepository).findByLastName(any());


    }

    @Test
    void findAll() {
        Set<Owner> returnOwnerSet = new HashSet<>();
        returnOwnerSet.add(Owner.builder().id(2L).build());
        returnOwnerSet.add(Owner.builder().id(3L).build());
        when(ownerRepository.findAll()).thenReturn(returnOwnerSet);
        Set<Owner> owners = service.findAll();

        assertNotNull(owners);
        assertEquals(2,owners.size());




    }

    @Test
    void findById() {
        when(ownerRepository.findById(ownerId)).thenReturn(Optional.of(returnOwner));
        Owner owner = service.findById(ownerId);
        assertNotNull(owner);
        assertEquals(ownerId,owner.getId());

    }

    @Test
    void findByIdNotFound(){
        when(ownerRepository.findById(ownerId)).thenReturn(Optional.empty());
        Owner owner = service.findById(ownerId);
        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();
        when(ownerRepository.save(any())).thenReturn(returnOwner);
        Owner owner = service.save(ownerToSave);

        assertNotNull(owner);
        assertEquals(ownerId,owner.getId());


    }

    @Test
    void delete() {
        service.delete(returnOwner);
        verify(ownerRepository,times(1)).delete(any());
        //check if that is called 1 time

    }

    @Test
    void deleteById() {
        service.deleteById(ownerId);
        verify(ownerRepository,times(1)).deleteById(anyLong());
    }
}