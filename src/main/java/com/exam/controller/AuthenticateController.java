package com.exam.controller;

import com.exam.config.JwtUtil;
import com.exam.entites.JwtRequest;
import com.exam.entites.JwtResponse;
import com.exam.entites.User;
import com.exam.helper.UserFoundException;
import com.exam.services.impl.UserDetailssServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthenticateController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailssServiceImpl userDetailssService;

    @Autowired
    private JwtUtil jwtUtil;

//    generate Token

    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try{
            authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
        }
        catch (UserFoundException e) {
            throw new Exception("Username Found");
        } catch (Exception e) {
            e.printStackTrace();
        }

        UserDetails userDetails = this.userDetailssService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }


    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }
        catch (DisabledException e) {
            throw new Exception("User Disabled");
        }
        catch (BadCredentialsException e) {
            throw new Exception("Invalid BadCredentialsException");
        }
    }


    //return current user
    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal) {
        return (User)this.userDetailssService.loadUserByUsername(principal.getName());
    }
}
