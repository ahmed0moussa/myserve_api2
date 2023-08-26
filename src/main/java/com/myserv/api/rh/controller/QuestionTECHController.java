package com.myserv.api.rh.controller;

import com.myserv.api.rh.model.QuestionTECH;
import com.myserv.api.rh.model.Specialite;
import com.myserv.api.rh.repository.QuestionTECHRepository;
import com.myserv.api.rh.services.QuestionTECHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class QuestionTECHController {
    @Autowired
    private QuestionTECHService questionTECHService;

    @PostMapping("/api/v1/questionTECH/create")
    public QuestionTECH create(@RequestBody QuestionTECH questionTECH,@RequestParam String specialiteId){

        questionTECHService.createQuestion(questionTECH,specialiteId);

        return questionTECH;
    }

    @GetMapping("/api/v1/questionTECH/getBySpecialite")
    public List<QuestionTECH> getBySpecialite(@RequestParam String specialiteId){
        return questionTECHService.findBySpecialite(specialiteId);

    }

}
