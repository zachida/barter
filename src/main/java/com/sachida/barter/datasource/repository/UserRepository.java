package com.sachida.barter.datasource.repository;

import com.sachida.barter.datasource.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {

    Optional<User> findByName(String name);

    Optional<User> findByDni(String name);

    Optional<User> findByMail(String name);

}
