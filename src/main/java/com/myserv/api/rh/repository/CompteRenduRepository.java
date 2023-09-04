package com.myserv.api.rh.repository;


import com.myserv.api.rh.model.CompteRendu;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRenduRepository extends MongoRepository<CompteRendu, String> {
    @Query("{ 'entretien.id': ?0 }")
    CompteRendu findByEntretienId(String entretienId);
}
