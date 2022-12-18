package com.example.group.artifact.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.group.artifact.jwtutils.JwtRequestModal;
import com.example.group.artifact.jwtutils.JwtResponse;
import com.example.group.artifact.jwtutils.JwtTokenManager;
import com.example.group.artifact.services.AuthService;

@RestController
@RequestMapping("/api/auth")
public class JwtResource {

    @Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired
    AuthService authService;
    
    @Autowired
    JwtTokenManager jwtTokenManager;
    
    @PostMapping("")
    public ResponseEntity<JwtResponse> createToken(@RequestBody JwtRequestModal jwtRequest) throws Exception {
        try {
            authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
        } catch(Exception e) {
            throw new Exception("Wrong credentials ", e);
        }
        System.out.println("befor load user by username");
        final UserDetails userDetails = authService.loadUserByUsername(jwtRequest.getUsername());
        System.out.println("after load user by username"+userDetails);
        final String token = jwtTokenManager.generateJwtToken(userDetails);
        JwtResponse response = new JwtResponse(token);
        return ResponseEntity.ok(new JwtResponse("Bearer "+response.getJwtToken()));
    }
    
    @GetMapping("")
    public ResponseEntity<String> getToken() throws Exception {        
        return ResponseEntity.ok("YOU ARE WELCOME");
    }
}
