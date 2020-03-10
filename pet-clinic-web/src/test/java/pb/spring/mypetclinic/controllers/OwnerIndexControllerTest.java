package pb.spring.mypetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pb.spring.mypetclinic.model.Owner;
import pb.spring.mypetclinic.services.OwnerService;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerIndexControllerTest {
    @Mock
     OwnerService ownerService;
    @InjectMocks
    OwnerIndexController controller;

    Set<Owner> ownerSet;
    MockMvc mvc;

    @BeforeEach
    void setUp() {
         ownerSet = new HashSet<>();
         ownerSet.add(Owner.builder().id(1L).build());
         ownerSet.add(Owner.builder().id(2L).build());
         mvc = MockMvcBuilders
                 .standaloneSetup(controller)
                 .build();
    }

    @Test
    void listOwners() throws Exception {
        when(ownerService.findAll()).thenReturn(ownerSet);
        mvc.perform(get("/owners/"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners",hasSize(2)));
    }

    @Test
    void findOwners() throws Exception {
        mvc.perform(get("/owners/find"))
                .andExpect(view().name("notImplemented"));


    }
}