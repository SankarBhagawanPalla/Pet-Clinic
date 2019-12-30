package com.springworks.sanpetclinic.repositories;

import com.springworks.sanpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
