package com.myserv.api.rh.model;



import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class UserDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Set<Roles> roles;

    // Constructors, getters, and setters as needed
}
