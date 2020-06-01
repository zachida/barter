package com.sachida.barter.rest.controller.publication;

import com.google.common.collect.Lists;
import com.sachida.barter.datasource.model.Bid;
import com.sachida.barter.datasource.model.Publication;
import com.sachida.barter.rest.api.publication.*;
import com.sachida.barter.rest.controller.bid.BidTranslator;
import com.sachida.barter.service.BidService;
import com.sachida.barter.service.PublicationService;
import com.sachida.barter.service.UserService;
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
    private BidService bidService;
    private UserService userService;

    @PostMapping("{userId}/publication")
    @ApiOperation(value = "Add publication for user")
    public PublicationDTO addPublication(@PathVariable String userId, @RequestBody PublicationRequestDTO publication) {

        userService.checkIfExistUserId(userId);

        return PublicationTranslator.translateToDTO(publicationService.save(PublicationTranslator.translateToEntity(publication, userId)));
    }

    @PutMapping("{userId}/publication/{publicationId}")
    @ApiOperation(value = "Add publication for user")
    public PublicationDTO modifyPublication(@PathVariable String userId, @PathVariable String publicationId, @RequestBody PublicationModificationDTO modification) {
        userService.checkIfExistUserId(userId);
        Publication publication = publicationService.get(publicationId);

        Publication modified = publicationService.modify(PublicationTranslator.modifyEntity(publication, modification));
        return PublicationTranslator.translateToDTO(modified);
        /*verificar que la publicacion, no este en bid con nadie. De ser asi, cancelar los bid*/
    }

    @PostMapping("{userId}/publication/{publicationId}/bid")
    @ApiOperation(value = "Aca una persona, le ofrece su publicacion a otro usuario. Recibe de body {user_id, publication_id}")
    public BidDTO bidPublication(@PathVariable String userId, @PathVariable String publicationId, @RequestBody BidRequestDTO bidRequest) {
        userService.checkIfExistUserId(userId);

        //con el bidRequest, tenemos que ir al usuario, a la publicacion y bidear eso
        Bid response = bidService.bid(BidTranslator.translateToEntity(bidRequest, userId, publicationId));
        return BidTranslator.translateToDTO(response);
    }

    @PostMapping("{userId}/publication/{publicationId}/bid/{bidId}")
    @ApiOperation(value = "el dueño de la publicacion, cancela el bid que no le guto")
    public void cancelBid(@PathVariable String userId, @PathVariable String publicationId, @PathVariable String bidId, @RequestBody String body) {
        userService.checkIfExistUserId(userId);
        /*solamente 2 users pueden cancelarlo, el que lo hace, o el que lo recibe*/
    }

    @GetMapping("{userID}/publication/{publicationID}")
    @ApiOperation(value = "el usuario ve las publicaciones por id")
    public PublicationDTO getPublication(@PathVariable String userId, @PathVariable String publicationID)
    {
        userService.checkIfExistUserId(userId);

        return PublicationTranslator.translateToDTO(publicationService.get(publicationID));
    }

    @GetMapping("{userId}/bids")
    @ApiOperation(value = "el usuario ve todo los bids que hice a las publicaciones")
    public void findBids(@PathVariable String userId) {
        userService.checkIfExistUserId(userId);
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

    @Autowired
    public void setBidService(BidService bidService) {
        this.bidService = bidService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
