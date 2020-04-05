package com.springworks.sanpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="types")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PetType extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Builder
    public PetType(Long id, String name){
        super(id);
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
