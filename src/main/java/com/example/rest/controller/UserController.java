package com.example.rest.controller;

import com.example.rest.model.dto.UserDto;
import com.example.rest.model.form.UserForm;
import com.example.rest.model.entity.User;
import com.example.rest.repository.UserRepository;
import com.example.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserDto register(@RequestBody @Valid UserForm userForm) {
        return userService.createUser(userForm);
    }

    @GetMapping
    public List<UserDto> list() {
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable("id") Long id) {
        return userService.findUserById(id);
    }

    @PutMapping("/{id}")
    public UserDto updateById(@RequestBody UserForm form, @PathVariable("id") Long id) {
        return userService.updateById(form, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
       userService.deleteById(id);
    }
}
