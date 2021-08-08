package com.example.inst.controller;

import com.example.inst.model.User;
import com.example.inst.model.exceptions.DuplicateDataException;
import com.example.inst.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody User user) throws DuplicateDataException {
        userService.register(user);
        return ResponseEntity.ok().build();
    }


}
