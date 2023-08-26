package com.myserv.api.rh.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document()
public class CompteRendu {
    @Id
    private String id ;

    @Indexed(name = "infocandidate")
    private Infocandidate infocandidate;

    @Indexed(name = "repenseQRH")
    private RepenseQRH repenseQRH;

    @Indexed(name = "repenseQTECH")
    private RepenseQTECH repenseQTECH;




}
