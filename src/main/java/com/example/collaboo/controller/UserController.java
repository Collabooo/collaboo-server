package com.example.collaboo.controller;// UserController.java
import com.example.collaboo.domain.User;
import com.example.collaboo.dto.UserDTO;
import com.example.collaboo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users/join")
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) {
        try {
            userService.createUser(userDTO);
            return ResponseEntity.ok("회원가입이 완료되었습니다");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("이미 존재하는 이메일 입니다. 다른 이메일을 입력해주시기 바랍니다.");
        }
    }

    @PostMapping("users/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody UserDTO userDTO) {
        User user = userService.login(userDTO.getEmail(), userDTO.getPassword());
        if (user != null) {
            // 로그인 성공 메시지와 함께 사용자 ID 반환
            Map<String, Object> response = new HashMap<>();
            //response.put("userId", user.getUserId());
            response.put("message", "로그인이 완료되었습니다. 월 만 원씩 내시면 모든 기능을 자유롭게 이용하실 수 있습니다!");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            // 로그인 실패 시 에러 메시지 반환
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("message", "이메일 또는 비밀번호가 올바르지 않습니다.");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

}
