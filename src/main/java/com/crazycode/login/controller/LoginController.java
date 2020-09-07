package com.crazycode.login.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.crazycode.login.entity.User;
import com.crazycode.login.entity.response.LoginResponse;

@RestController
@RequestMapping("login")
public class LoginController {

    @GetMapping
    public ResponseEntity<LoginResponse> login(@RequestBody User user) {
        LoginResponse loginResponse = new LoginResponse("12k3rjwehgjhwrg982h");
        return ResponseEntity.ok(loginResponse);
    }

}
