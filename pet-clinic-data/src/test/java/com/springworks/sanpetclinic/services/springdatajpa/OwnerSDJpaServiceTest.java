package com.springworks.sanpetclinic.services.springdatajpa;

import com.springworks.sanpetclinic.model.Owner;
import com.springworks.sanpetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Smith";
    @Mock
    OwnerRepository ownerRepository;
    @InjectMocks
    OwnerSDJpaService service;
    @BeforeEach
    void setUp() {
    }

    @Test
    void findByLastName() {
        Owner returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        Owner owner = service.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME, owner.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());
        when(ownerRepository.findAll()).thenReturn(owners);
        Set<Owner> returned = service.findAll();
        assertNotNull(returned);
        assertEquals(2, returned.size() );
    }

    @Test
    void findById() {
        Owner owner = Owner.builder().id(1L).build();
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));
        Owner returned = service.findById(1L);
        assertNotNull(returned);
        assertEquals(1L, returned.getId());
    }
    @Test
    void findByIdNotNull() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner returned = service.findById(1L);
        assertNull(returned);
    }

    @Test
    void save() {
        Owner owner = Owner.builder().id(1L).build();
        when(ownerRepository.save(any())).thenReturn(owner);
        Owner returned = service.save(owner);
        assertNotNull(returned);
    }

    @Test
    void delete() {
        Owner owner = Owner.builder().id(1L).build();
        service.delete(owner);
        verify(ownerRepository,times(1)).delete(owner);
    }

    @Test
    void deleteById() {

        service.deleteById(1L);
        verify(ownerRepository, times(1)).deleteById(1L);
    }
}