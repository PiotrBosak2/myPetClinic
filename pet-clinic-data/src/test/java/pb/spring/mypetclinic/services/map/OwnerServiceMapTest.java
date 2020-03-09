package pb.spring.mypetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pb.spring.mypetclinic.model.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {
    public static final String LAST_NAME = "Kowalski";
    OwnerServiceMap ownerServiceMap;
    final long ownerId = 1L;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(),new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(ownerId).lastName(LAST_NAME).build());

    }

    @Test
    void findByLastName() {
        Owner ownerWithName = ownerServiceMap.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME,ownerWithName.getLastName());

    }

    @Test
    void findByLastNameNotFound(){
        Owner owner = ownerServiceMap.findByLastName("foo");
        assertNull(owner);
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(1,owners.size());

    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(ownerId);
        assertEquals(ownerId,owner.getId());
    }

    @Test
    void save() {
        Long ownerId2 = 2L;
        Owner owner2 = Owner.builder().id(ownerId2).build();
        Owner savedOwner = ownerServiceMap.save(owner2);
        assertEquals(ownerId2,savedOwner.getId());
    }

    @Test
    void saveNoId(){
        Owner savedOwner = ownerServiceMap.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0,ownerServiceMap.findAll().size());

        }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);
        assertEquals(0,ownerServiceMap.findAll().size());

    }
}