package com.example.group.artifact.jwtutils;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    String jwtToken;

    public JwtResponse() {
        
    }
    
    public JwtResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
    
}
