package com.sachida.barter.datasource.repository;

import com.sachida.barter.datasource.model.Publication;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PublicationRepository extends CrudRepository<Publication, String> {

        List<Publication> findAllByLocation(String location);

}