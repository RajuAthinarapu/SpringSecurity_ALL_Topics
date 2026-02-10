package com.Raju.SpringSecurity_ALLtopics.Service;

import com.Raju.SpringSecurity_ALLtopics.Model.Users;
import com.Raju.SpringSecurity_ALLtopics.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12); // this is for creating an instance of BCryptPasswordEncoder with a strength of 12. The strength parameter determines the computational cost of hashing the password, with higher values being more secure but also more resource-intensive. A strength of 12 is generally considered a good choice for most applications, providing a good balance between security and performance.

    public Users register(Users users){
        users.setPassword(encoder.encode(users.getPassword())); // this line is used to encode the password of the user before saving it to the database. The encoder.encode() method takes the raw password as input and returns the encoded version of the password, which is then set back to the user object using users.setPassword(). This ensures that the password is stored securely in the database, as it will be hashed and not stored in plain text.
        return repo.save(users);
    }
}
