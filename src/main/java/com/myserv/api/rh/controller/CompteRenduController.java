package com.myserv.api.rh.controller;

import com.myserv.api.rh.model.*;
import com.myserv.api.rh.services.CompteRenduService;
import com.myserv.api.rh.services.FileImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class CompteRenduController {

    @Autowired
    private CompteRenduService compteRenduService;

    @Autowired
    private FileImageService fileImageService;

    @PostMapping(value = "/api/v1/compterendu/create" )
    public CompteRendu create(@RequestParam String idEntretien,
                              @RequestBody CompteRendu compteRendu){
        return compteRenduService.createCompteRendu(idEntretien,compteRendu);

    }
    @GetMapping("/api/v1/compterendu")
    public CompteRendu findbyid(@RequestParam String id ){

        return compteRenduService.getByIdEntretien(id);
    }

    @PutMapping(value = "/api/v1/compterendu/update" )
    public CompteRendu update(@RequestParam String idEntretien,
                              @RequestBody CompteRendu compteRendu){
        return compteRenduService.updateCompteRendu(idEntretien,compteRendu);

    }
    @PostMapping ("/api/v1/compterendu/uploadFile/{entretienId}")
    public ResponseEntity<CompteRendu> uploadImage(@PathVariable String entretienId, @RequestParam("file") MultipartFile file) {

        return fileImageService.uploadImage(entretienId,file);
    }
    @GetMapping("/api/v1/compterendu/downloadFile/{imageName}")
    public ResponseEntity<Resource> downloadImage(@PathVariable String imageName) {
        return fileImageService.downloadImage(imageName);
    }


}
