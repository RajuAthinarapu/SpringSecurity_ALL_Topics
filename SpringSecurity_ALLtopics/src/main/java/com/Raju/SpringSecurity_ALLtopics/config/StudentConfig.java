package com.Raju.SpringSecurity_ALLtopics.config;


import jakarta.websocket.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class StudentConfig {


    @Autowired
    private UserDetailsService userDetailsService;

   @Bean                                                                                                    // this is for defining a bean in the Spring application context. A bean is an object that is managed by the Spring container and can be injected into other components of the application. In this case, we are defining a bean of type SecurityFilterChain, which is used to configure the security settings for the application.
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {                                          // this is for configuring the security filter chain, which is a series of filters that are applied to incoming HTTP requests to enforce security policies. The SecurityFilterChain is responsible for processing authentication and authorization for each request.
    return http
      .csrf(Customizer ->Customizer.disable())                                    // this is for disabling CSRF (Cross-Site Request Forgery) protection, which is a security measure that helps prevent unauthorized actions on a web application. Disabling CSRF can be useful in certain scenarios, such as when building a stateless REST API, but it should be done with caution as it can expose the application to security vulnerabilities.
      .authorizeHttpRequests(request ->request.anyRequest().authenticated()) // this is for authorizing HTTP requests, which means that any request made to the server must be authenticated. This is a common security measure to ensure that only authorized users can access the resources on the server.
      .httpBasic(Customizer.withDefaults())                                                                            // this is for basic authentication, which means that the client must provide a username and password with each request. The server will validate the credentials and grant access if they are correct. This is a simple authentication mechanism that is often used for testing or in scenarios where security is not a concern.
      .sessionManagement(Session-> Session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // this is for stateless session management, which means that the server will not create or maintain any session for the client. Each request must contain all the necessary information for authentication and authorization, typically through tokens like JWT (JSON Web Tokens). This is often used in RESTful APIs where the server does not need to keep track of user sessions..build();
       //.formLogin(Customizer.withDefaults());                                                                    // this is for form-based authentication, which means that the client will be presented with a login form where they can enter their username and password. The server will validate the credentials and grant access if they are correct. This is a common authentication mechanism for web applications.
       .build();
   }

    //   @Bean
//    public UserDetailsService userdetailsService(){ // this is for defining a bean of type UserDetailsService, which is an interface that provides a way to retrieve user details for authentication and authorization purposes. In this case, we are using an in-memory implementation of UserDetailsService, which means that the user details will be stored in memory and will not persist across application restarts.
//      UserDetails user1= User //
//              .withDefaultPasswordEncoder() // this is for encoding the password using a default password encoder. This is not recommended for production use, as it is not secure, but it can be useful for testing or demonstration purposes.
//              .username("shiva")
//              .password("shiva123")
//              .roles("ADMIN")
//              .build();
//
//      UserDetails user2 = User
//              .withDefaultPasswordEncoder()
//              .username("ramu")
//              .password("ramu123")
//              .roles("USER")
//              .build();
//       return new InMemoryUserDetailsManager(user1,user2); // this is for creating an instance of InMemoryUserDetailsManager and passing the user details (user1 and user2) to it. The InMemoryUserDetailsManager will manage the user details in memory and provide them for authentication and authorization purposes when requested by the security filter chain.
//   }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return provider;
    }



















//
//    public interface AuthenticationManager {
//        Authentication authenticate(Authentication authentication);
//    }



// this is for creating a login controller that handles login requests. The controller will use the AuthenticationManager to authenticate the user's credentials and set the authentication in the security context if the login is successful. If the login fails, it will return an error message. This is a common pattern for handling user authentication in a Spring Security application.
//    @RestController
//    public class LoginController {
//
//        @Autowired
//        private AuthenticationManager authenticationManager;
//
//        @PostMapping("/login")
//        public String login(@RequestBody LoginRequest request) {
//            try {
//                // Create authentication token
//                UsernamePasswordAuthenticationToken authToken =
//                        new UsernamePasswordAuthenticationToken(
//                                request.getUsername(),
//                                request.getPassword()
//                        );
//
//                // Authenticate
//                Authentication auth = authenticationManager.authenticate(authToken);
//
//                // Set in security context
//                SecurityContextHolder.getContext().setAuthentication(auth);
//
//                return "Login successful!";
//            } catch (AuthenticationException e) {
//                return "Login failed: " + e.getMessage();
//            }
//        }
//    }


}
