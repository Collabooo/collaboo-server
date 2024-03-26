package com.example.collaboo.controller;// UserController.java
import com.example.collaboo.dto.UserDTO;
import com.example.collaboo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users/join")
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
        return ResponseEntity.ok("회원가입이 완료되었습니다. 월 5천원씩 내시면 모든 기능을 자유롭게 이용하실 수 있습니다!");
    }
}
