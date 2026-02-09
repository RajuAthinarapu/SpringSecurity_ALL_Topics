package com.Raju.SpringSecurity_ALLtopics.Repo;

import com.Raju.SpringSecurity_ALLtopics.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

public interface UserRepo extends JpaRepository<Users,Integer> {

    Users findByUsername(String username) ; //
}