package com.myserv.api.rh.services;

import com.myserv.api.rh.model.CompteRendu;
import com.myserv.api.rh.model.Entretien;
import com.myserv.api.rh.model.Specialite;
import com.myserv.api.rh.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompteRenduService {
 /*
    @Autowired
    private EntretienRepository entretienRepository;

    @Autowired
    private CompteRenduRepository compteRenduRepository;

    @Autowired
    private InfocandidateRepository infocandidateRepository;

    @Autowired
    private RepenseQrhRepository repenseQRHRepository;

    @Autowired
    private RepenseQtechRepository repenseQtecRepository;


    public CompteRendu createCompteRendu(CompteRendu compteRendu){

        Entretien entretien=compteRendu.getEntretien();
        String idEntretien=entretien.getId();
        Entretien entretien2 = entretienRepository.findById(idEntretien).orElseThrow();
        entretienRepository.save(entretien2);





    return compteRenduRepository.save(compteRendu);
    }*/

}
