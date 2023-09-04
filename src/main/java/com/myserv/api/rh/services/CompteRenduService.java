package com.myserv.api.rh.services;

import com.myserv.api.rh.model.*;
import com.myserv.api.rh.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteRenduService {
    @Autowired
    private EntretienRepository entretienRepository;

    @Autowired
    private CompteRenduRepository compteRenduRepository;

    @Autowired
    private InfocandidateRepository infocandidateRepository;

    @Autowired
    private RepenseQrhRepository repenseQRHRepository;

    @Autowired
    private RepenseQtechRepository repenseQtechRepository;
    public CompteRendu createCompteRendu(String idEntretien,CompteRendu compteRenduToSave){
        CompteRendu compteRendu=new CompteRendu();
        Entretien entretien=compteRenduToSave.getEntretien();
        Infocandidate infocandidate=compteRenduToSave.getInfocandidate();
        RepenseQRH repenseQRH=compteRenduToSave.getRepenseQRH();
        Entretien existingEntretien = entretienRepository.findById(idEntretien).orElseThrow();
        List<RepenseQTECH> repenseQTECHList=compteRenduToSave.getRepenseQTECHList();
        // Update fields with values from Entretien
        existingEntretien.setFirstName(entretien.getFirstName());
        existingEntretien.setLastName(entretien.getLastName());
        existingEntretien.setDatecreation(entretien.getDatecreation());
        existingEntretien.setDatemodif(entretien.getDatemodif());
        existingEntretien.setTime(entretien.getTime());
        existingEntretien.setFeedback(entretien.getFeedback());
        existingEntretien.setSpecialite(entretien.getSpecialite());
        existingEntretien.setCommentaire(entretien.getCommentaire());
        existingEntretien.setRecruteur(entretien.getRecruteur());
        entretienRepository.save(existingEntretien);
        compteRendu.setEntretien(existingEntretien);
        infocandidateRepository.save(infocandidate);
        compteRendu.setInfocandidate(infocandidate);
        repenseQRHRepository.save(repenseQRH);
        compteRendu.setRepenseQRH(repenseQRH);
        //quistion tech
        if (repenseQTECHList != null && !repenseQTECHList.isEmpty()) {

            repenseQtechRepository.saveAll(repenseQTECHList);
            compteRendu.setRepenseQTECHList(repenseQTECHList);
        }



        return compteRenduRepository.save(compteRendu);
    }
    public CompteRendu getByIdEntretien(String entretienId){
        return compteRenduRepository.findByEntretienId(entretienId);
    }
    public CompteRendu updateCompteRendu(String entretienId,CompteRendu compteRenduToSave){
        Entretien entretien=compteRenduToSave.getEntretien();
        Infocandidate infocandidate=compteRenduToSave.getInfocandidate();
        RepenseQRH repenseQRH=compteRenduToSave.getRepenseQRH();
        Entretien existingEntretien = entretienRepository.findById(entretienId).orElseThrow();
        CompteRendu compteRendu=compteRenduRepository.findByEntretienId(entretienId);
        Infocandidate existingInfocandidate=compteRendu.getInfocandidate();
        RepenseQRH existingRepenseQRH=compteRendu.getRepenseQRH();

        // Update values from Entretien
        existingEntretien.setFirstName(entretien.getFirstName());
        existingEntretien.setLastName(entretien.getLastName());
        existingEntretien.setDatecreation(entretien.getDatecreation());
        existingEntretien.setDatemodif(entretien.getDatemodif());
        existingEntretien.setTime(entretien.getTime());
        existingEntretien.setFeedback(entretien.getFeedback());
        existingEntretien.setSpecialite(entretien.getSpecialite());
        existingEntretien.setCommentaire(entretien.getCommentaire());
        existingEntretien.setRecruteur(entretien.getRecruteur());
        entretienRepository.save(existingEntretien);
        compteRendu.setEntretien(existingEntretien);
        // Update values from infocandidate
        existingInfocandidate.setPhone(infocandidate.getPhone());
        existingInfocandidate.setAddress(infocandidate.getAddress());
        existingInfocandidate.setEmail(infocandidate.getEmail());
        existingInfocandidate.setPermit(infocandidate.getPermit());
        existingInfocandidate.setAge(infocandidate.getAge());
        existingInfocandidate.setStatus(infocandidate.getStatus());
        existingInfocandidate.setDiplome(infocandidate.getDiplome());
        existingInfocandidate.setYearsOfExperience(infocandidate.getYearsOfExperience());
        existingInfocandidate.setSalary(infocandidate.getSalary());
        existingInfocandidate.setPreavis(infocandidate.getPreavis());
        existingInfocandidate.setVISA(infocandidate.getVISA());
        existingInfocandidate.setMobilite(infocandidate.getMobilite());
        existingInfocandidate.setAutredsBoites(infocandidate.getAutredsBoites());
        existingInfocandidate.setImage(infocandidate.getImage());
        infocandidateRepository.save(existingInfocandidate);
        compteRendu.setInfocandidate(existingInfocandidate);
        // Update values from repenseQRH
        existingRepenseQRH.setFrenchLevel(repenseQRH.getFrenchLevel());
        existingRepenseQRH.setEnglishlevel(repenseQRH.getEnglishlevel());
        existingRepenseQRH.setQualities(repenseQRH.getQualities());
        existingRepenseQRH.setFaults(repenseQRH.getFaults());
        existingRepenseQRH.setQ2(repenseQRH.getQ2());
        existingRepenseQRH.setQ3(repenseQRH.getQ3());
        existingRepenseQRH.setQ4(repenseQRH.getQ4());
        existingRepenseQRH.setQ5(repenseQRH.getQ5());
        repenseQRHRepository.save(existingRepenseQRH);
        compteRendu.setRepenseQRH(existingRepenseQRH);
        List<RepenseQTECH> repenseQTECHList = compteRenduToSave.getRepenseQTECHList();
        repenseQtechRepository.saveAll(repenseQTECHList); // Update all RepenseQTECH objects
        compteRendu.setRepenseQTECHList(repenseQTECHList);
        return compteRenduRepository.save(compteRendu);
    }
}
