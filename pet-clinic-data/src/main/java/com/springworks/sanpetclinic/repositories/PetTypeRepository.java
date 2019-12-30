package com.springworks.sanpetclinic.repositories;

import com.springworks.sanpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
