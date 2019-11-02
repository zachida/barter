package com.sachida.barter.service;

import com.sachida.barter.datasource.model.Publication;
import com.sachida.barter.datasource.repository.PublicationRepository;
import com.sachida.barter.rest.api.exception.BarterNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;

@Service
public class PublicationService {

    private PublicationRepository publicationRepository;

    public Publication save(Publication publication){
        return publicationRepository.save(publication);
    }

    public List<Publication> findPublicationsByLocation(String location){
        return publicationRepository.findAllByLocation(location);
    }

    public Publication get(String publicationId) {
        return publicationRepository.findById(publicationId)
                .orElseThrow(()-> new BarterNotFoundException (String.format("%s is not a saved publication", publicationId)));
    }

    @Autowired
    public void setPublicationRepository(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }
}
