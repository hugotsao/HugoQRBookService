package com.hugo.hugoqrbookservice.controllers;

import com.hugo.hugoqrbookservice.MongoUserDetailsService;
import com.hugo.hugoqrbookservice.model.JwtRequest;
import com.hugo.hugoqrbookservice.model.JwtResponse;
import com.hugo.hugoqrbookservice.util.JwtUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
public class JwtAuthenticationController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    MongoUserDetailsService userDetailsService;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/api/authentication")
    public ResponseEntity authenticateController(
            @RequestBody JwtRequest request
    ) {
        this.authenticate(request.getUsername(), request.getPassword());
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }
    private void authenticate(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            log.error("The user account {} is disabled", username);
        } catch (UsernameNotFoundException | BadCredentialsException e) {
            log.error("Error when authorizing user {}.", username);
        }

    }
}
