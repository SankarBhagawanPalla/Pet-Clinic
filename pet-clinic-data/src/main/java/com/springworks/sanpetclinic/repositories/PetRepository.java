package com.springworks.sanpetclinic.repositories;

import com.springworks.sanpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
