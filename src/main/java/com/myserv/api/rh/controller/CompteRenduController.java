package com.myserv.api.rh.controller;

import com.myserv.api.rh.model.CompteRendu;
import com.myserv.api.rh.model.Entretien;
import com.myserv.api.rh.services.CompteRenduService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Principal;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/v1/compterendu")
public class CompteRenduController {
    /*@Autowired
    private CompteRenduService compteRenduService;
    @PostMapping(value = "create" )
    public CompteRendu create(@RequestBody CompteRendu compteRendu) throws IOException {


        compteRenduService.createCompteRendu(compteRendu);
        return compteRendu;
    }*/

}
