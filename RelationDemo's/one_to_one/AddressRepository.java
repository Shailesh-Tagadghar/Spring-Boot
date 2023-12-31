package com.example.demo.one_to_one;

import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer> {
//this is Address interface to create table into database and to interact with database 
}
