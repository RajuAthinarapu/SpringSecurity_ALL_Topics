package com.Raju.SpringSecurity_ALLtopics.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.stereotype.Repository;

@Repository
@Entity //
public class Users { // this is user class which is used to store the user details in the database
    @Id
    private Integer id;
    private String username;
    private String password;

    public Users() { //
    }

    public Users(Integer id, String name, String password) { //
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer ID) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
