package com.Raju.SpringSecurity_ALLtopics.Service;

import com.Raju.SpringSecurity_ALLtopics.Model.UserPrincipal;
import com.Raju.SpringSecurity_ALLtopics.Model.Users;
import com.Raju.SpringSecurity_ALLtopics.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {//this class is used to implement the UserDetailsService interface and override the loadUserByUsername method to load the user details by username and return the user details object

    @Autowired
    private UserRepo repo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { //this method is used to load the user details by username and return the user details object
        Users user = repo.findByUsername(username);
    if(user==null){
        System.out.println("user not found");
        throw new UsernameNotFoundException("user not found");
    }

        return new UserPrincipal(user);
    }

}
