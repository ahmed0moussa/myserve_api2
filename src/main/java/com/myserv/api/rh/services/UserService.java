package com.myserv.api.rh.services;

import com.myserv.api.rh.model.RoleType;
import com.myserv.api.rh.model.Roles;
import com.myserv.api.rh.model.User;
import com.myserv.api.rh.repository.RoleRepository;
import com.myserv.api.rh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

@Autowired
    UserRepository userRepository;

@Autowired
    private  UserRepository repository;
@Autowired
private RoleRepository roleRepository;
    public List<User> findAllUsers(){
        return userRepository.findAllUsersExceptAdmin("admin@admin.com");
    }

    public void deleteById(String id){
          userRepository.deleteById(id);
    }
    public void createadmine() {

        User userAdmin = new User();
        User savedUser = null;

        if (!roleRepository.existsByName(RoleType.ROLE_ADMIN)) {
            Roles roleAdmin = new Roles();
            roleAdmin.setName(RoleType.ROLE_ADMIN);
            Roles dpt = roleRepository.save(roleAdmin);


        }
        if (!roleRepository.existsByName(RoleType.ROLE_USER)) {
            Roles roleAdmin = new Roles();
            roleAdmin.setName(RoleType.ROLE_USER);
            Roles dpt = roleRepository.save(roleAdmin);


        }

        if (!repository.existsByEmail("admin@admin.com")) {
            userAdmin.setEmail("admin@admin.com");
            userAdmin.setFirstName("admin");
            userAdmin.setLastName("admin");
            userAdmin.setPassword(new BCryptPasswordEncoder().encode("admin.123"));
            Set<Roles> roles = new HashSet<>();
            Roles userRole = roleRepository.findByName(RoleType.ROLE_ADMIN).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
            userAdmin.setRoles(roles);

            savedUser=repository.save(userAdmin);
        }

    }



}
