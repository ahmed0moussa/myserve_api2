package com.myserv.api.rh.repository;

import com.myserv.api.rh.model.QuestionTECH;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface QuestionTECHRepository extends MongoRepository<QuestionTECH, String> {
    @Query("{'specialite.id':  ?0}")
    List<QuestionTECH> findBySpecialiteId(String specialiteId);


}

