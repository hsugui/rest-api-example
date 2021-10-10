package com.example.rest.service;

import com.example.rest.model.dto.UserDto;
import com.example.rest.model.entity.User;
import com.example.rest.model.form.UserForm;
import com.example.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserDto createUser(UserForm form) {
        User user = convertToBusiness(form);
        user = userRepository.save(user);
        return convertToDto(user);
    }

    public List<UserDto> findAllUsers(){
        List<User> all = userRepository.findAll();
        return convertListToDto(all);
    }

    public UserDto findUserById(Long id) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            return convertToDto(optional.get());
        }
        return null;
    }

    public UserDto updateById(UserForm form, Long id) {
        Optional<User> op = userRepository.findById(id);
        if (op.isPresent()) {
            User obj = op.get();
            if (form.getName() != null) {
                obj.setName(form.getName());
            }
            if (form.getEmail() != null) {
                obj.setEmail(form.getEmail());
            }
            if (form.getCpf() != null) {
                obj.setCpf(form.getCpf());
            }
            if (form.getBirthDate() != null) {
                obj.setBirthDate(form.getBirthDate());
            }
            userRepository.save(obj);
            return convertToDto(obj);
        }
        return null;
    }

    public void deleteById(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }


    private User convertToBusiness(UserForm form) {
        User user = new User();
        user.setName(form.getName());
        user.setEmail(form.getEmail());
        user.setCpf(form.getCpf());
        user.setBirthDate(form.getBirthDate());
        return user;
    }

    private UserDto convertToDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setCpf(user.getCpf());
        dto.setBirthDate(user.getBirthDate());
        return dto;
    }

    private static List<UserDto> convertListToDto(List<User> users) {
        return users.stream().map(UserDto::new).collect(Collectors.toList());
    }

}
