package com.errorcenter.api.controllers;

import com.errorcenter.api.dto.UserRegisterDTO;
import com.errorcenter.api.models.EventLog;
import com.errorcenter.api.models.User;
import com.errorcenter.api.services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/register")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity save(@Valid @RequestBody UserRegisterDTO dto) {
        UserRegisterDTO newUser = userService.save(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
