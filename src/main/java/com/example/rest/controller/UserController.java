package com.example.rest.controller;

import com.example.rest.model.dto.UserDto;
import com.example.rest.model.form.UserForm;
import com.example.rest.model.form.UserUpdateForm;
import com.example.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
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
    public UserDto updateById(@RequestBody UserUpdateForm form, @PathVariable("id") Long id) {
        return userService.updateById(form, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
       userService.deleteById(id);
    }
}
