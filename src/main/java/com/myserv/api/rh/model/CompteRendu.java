package com.myserv.api.rh.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data

@Setter
@Getter
@Document
public class CompteRendu {

    @Id
    private String id ;

    @Indexed(name = "entretien")
    private Entretien entretien;

    @Indexed(name = "infocandidate")
    private Infocandidate infocandidate ;

    @Indexed(name = "repenseQRH")
    private RepenseQRH repenseQRH;

    @Indexed(name = "repenseQTECH")
    private List<RepenseQTECH> repenseQTECHList;

}
