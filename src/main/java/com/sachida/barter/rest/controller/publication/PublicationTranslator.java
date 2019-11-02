package com.sachida.barter.rest.controller.publication;

import com.sachida.barter.datasource.model.Publication;
import com.sachida.barter.datasource.model.Status;
import com.sachida.barter.rest.api.publication.PublicationDTO;
import com.sachida.barter.rest.api.publication.PublicationRequestDTO;

public class PublicationTranslator {

    public static Publication translateToEntity(PublicationRequestDTO requestDTO, String userId){
        Publication publication = new Publication();
        publication.setUserId(Long.parseLong(userId));
        publication.setLocation(requestDTO.getLocation());
        publication.setStatus(Status.valueOf(requestDTO.getStatus().toUpperCase()));
        publication.setPrice(requestDTO.getPrice());
        publication.setVisible(requestDTO.getVisible());
        return  publication;
    }

    public static PublicationDTO translateToDTO(Publication publication){
        PublicationDTO publicationDTO = new PublicationDTO();
        publicationDTO.setUserId(publication.getUserId());
        publicationDTO.setLocation(publication.getLocation());
        publicationDTO.setStatus(publication.toString());
        publicationDTO.setPrice(publication.getPrice());
        publicationDTO.setVisible(publication.getVisible());
        return  publicationDTO;
    }
}
