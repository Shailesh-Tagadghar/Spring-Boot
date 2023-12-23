package com.restapi_dbconnect.repositories;

import org.springframework.data.repository.CrudRepository;

import com.restapi_dbconnect.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
