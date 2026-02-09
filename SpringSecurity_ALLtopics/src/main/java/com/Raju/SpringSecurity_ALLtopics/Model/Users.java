package com.Raju.SpringSecurity_ALLtopics.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.stereotype.Repository;

@Repository
@Entity //
public class Users { // this is user class which is used to store the user details in the database
    @Id
    private Integer ID;
    private String username;
    private String PASSWORD;

    public Users() {
    }

    public Users(Integer id, String name, String password) {
        this.ID = ID;
        this.username = username;
        this.PASSWORD = PASSWORD;
    }

    public Integer getId() {
        return ID;
    }

    public void setId(Integer ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return PASSWORD;
    }

    public void setPassword(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }
}
