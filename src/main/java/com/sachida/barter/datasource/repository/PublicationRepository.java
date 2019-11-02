package com.sachida.barter.datasource.repository;

import com.sachida.barter.datasource.model.Publication;
import com.sachida.barter.datasource.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PublicationRepository extends CrudRepository<Publication, String> {

}