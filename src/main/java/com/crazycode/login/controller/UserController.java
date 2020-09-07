package com.crazycode.login.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.crazycode.login.entity.User;

@RestController
@RequestMapping("user")
public class UserController {

    private List<User> usersTemp = new ArrayList<>();
    private Long userId = 0l;

    @PostMapping
    public ResponseEntity<User> user(@RequestBody User user) {
        userId = userId + 1;
        user.setId(userId);
        usersTemp.add(user);
       return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> user() {
        return ResponseEntity.ok(usersTemp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> user(@PathVariable("id") Long id) {
        User user = null;
        for(int i = 0; i < usersTemp.size(); i++) {
            if(usersTemp.get(i).getId() == id) {
                user = usersTemp.get(i);
            }
        }
        return new ResponseEntity<>(user, user != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}
