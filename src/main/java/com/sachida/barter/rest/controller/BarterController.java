package com.sachida.barter.rest.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Api
public class BarterController {

    @PostMapping("barter")
    @ApiOperation(value = "Truequear dos publicaciones")
    public String barterPublications(@RequestBody String body) {
        return body;
        /*User_id, publication_id de ambos, ir a buscar la publicacion, hacer validaciones, que sean diferentes usuaruios
        precio en el mismo rango,
        marcar como BARTERED las publicaciones.
         */
    }
}
