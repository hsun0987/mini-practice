package com.example.mini_practice.user.controller;

import com.example.mini_practice.user.db.UserEntity;
import com.example.mini_practice.user.db.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    private final UserRepository userRepository;

    @GetMapping("/find-all")
    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    @GetMapping("/name")
    public void autoSave(
            @RequestParam String name
    ){
        var user = UserEntity.builder()
                .name(name)
                .build();

        userRepository.save(user);
    }

}
