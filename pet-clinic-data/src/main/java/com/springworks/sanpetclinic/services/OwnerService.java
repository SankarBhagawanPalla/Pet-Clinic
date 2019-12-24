package com.springworks.sanpetclinic.services;

import com.springworks.sanpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long> {

    Owner findByLastName(String lastName);

}
