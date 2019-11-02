package com.sachida.barter.service;

import com.sachida.barter.datasource.model.Publication;
import com.sachida.barter.datasource.repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationService {

    private PublicationRepository publicationRepository;

    public Publication save(Publication publication){
        return publicationRepository.save(publication);
    }

    public List<Publication> findPublicationsByLocation(String location){
        return publicationRepository.findAllByLocation(location);
    }

    @Autowired
    public void setPublicationRepository(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }
}
