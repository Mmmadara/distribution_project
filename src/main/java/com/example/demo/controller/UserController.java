package com.example.demo.controller;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


//    @PostMapping("/user/{userid}")
//    public ResponseEntity<User> addUserData(@RequestBody UserDTO userDTO,
//                                            @PathVariable("userid") String userId){
//        return new ResponseEntity<>(
//                userService.addUserData(userDTO, Long.parseLong(userId)), HttpStatus.OK);
//    }



    @GetMapping("/userlist")
    public ResponseEntity<List<User>> allUsers(){
        return new ResponseEntity<>(userService.allUsers(), HttpStatus.OK);
    }

}