package com.hugo.hugoqrbookservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Collections;
import java.util.Map;

@RestController
public class UsersController {
    @GetMapping("/api/user/get")
    public Principal getUserPrincipal(Principal user) {
        return user;
    }
    @GetMapping("/api/token/get")
    public Map<String,String> token(HttpSession session) {
        return Collections.singletonMap("token", session.getId());
    }
}