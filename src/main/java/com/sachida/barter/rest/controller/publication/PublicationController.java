package com.sachida.barter.rest.controller.publication;

import com.google.common.collect.Lists;
import com.sachida.barter.datasource.model.Publication;
import com.sachida.barter.rest.api.publication.PublicationDTO;
import com.sachida.barter.rest.api.publication.PublicationRequestDTO;
import com.sachida.barter.service.PublicationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping
@Api
public class PublicationController {

    private PublicationService publicationService;

    @PostMapping("{userId}/publication")
    @ApiOperation(value = "Add publication for user")
    public PublicationDTO addPublication(@PathVariable String userId, @RequestBody PublicationRequestDTO publication) {
        Publication response = publicationService.save(PublicationTranslator.translateToEntity(publication, userId));
        return PublicationTranslator.translateToDTO(response);
    }

    @PutMapping("{userId}/publication")
    @ApiOperation(value = "Add publication for user")
    public PublicationDTO modifyPublication(@PathVariable String userId, @RequestBody String publication) {
        return null; //TODO
        /*verificar que la publicacion, no este en bid con nadie. De ser asi, cancelar los bid*/
    }

    @PostMapping("{userId}/publication/{publicationId}/bid")
    @ApiOperation(value = "Aca una persona, le ofrece su publicacion a otro usuario. Recibe de body {user_id, publication_id}")
    public void bidPublication(@PathVariable String userId, @PathVariable String publicationId, @RequestBody String body) {
    }

    @PostMapping("{userId}/publication/{publicationId}/bid/{bidId}")
    @ApiOperation(value = "el dueño de la publicacion, cancela el bid que no le guto")
    public void cancelBid(@PathVariable String userId, @PathVariable String publicationId, @PathVariable String bidId, @RequestBody String body) {
        /*solamente 2 users pueden cancelarlo, el que lo hace, o el que lo recibe*/
    }

    @GetMapping("{userId}/bids")
    @ApiOperation(value = "el usuario ve todo los bids que hice a las publicaciones")
    public void findBids(@PathVariable String userId) {
    }

    @GetMapping("{userId}/publication/{publicationId}/offers")
    @ApiOperation(value = "Listado de ofertas que le hicieron a mi publicacion")
    public List<Publication> publicationOffers(@PathVariable String userId, @PathVariable String publicationId) {
        return Lists.newArrayList(); //TODO
    }


    @GetMapping("/publications/find/{location}")
    @ApiOperation(value = "Listado de publicaciones por location")
    public List<PublicationDTO> findPublicationsByLocation(@PathVariable String location) {
        return publicationService.findPublicationsByLocation(location)
                .stream()
                .map(PublicationTranslator::translateToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/publications/find")
    @ApiOperation(value = "Listado de publicaciones")
    public List<Publication> findPublications(@PathVariable String publicationRequest) {
        return Lists.newArrayList(); //TODO
        /*poder buscaar por palabras*/
    }


    @Autowired
    public void setPublicationService(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

}
