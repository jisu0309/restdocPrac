package com.example.restdocPrac.controller;

import com.example.restdocPrac.model.Header;
import com.example.restdocPrac.model.User;
import com.example.restdocPrac.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public Header<User> create(@RequestBody User requestUser){
        User user = userService.create(requestUser);

        if(user != null){
            return Header.OK(user);
        }
        return Header.Error();
    }

    @GetMapping("/{id}")
    public Header<User> read(@PathVariable(name = "id") Long id){
        User user = userService.read(id);

        if(user != null){
            return Header.OK(user);
        }
        return Header.Error();
    }

    @PutMapping
    public Header<User> update(@RequestBody User requestUser){
        User user = userService.update(requestUser);


        if(user != null){
            return Header.OK(user);
        }
        return Header.Error();
    }

    @DeleteMapping("/{id}")
    public Header<User> delete(@PathVariable(name = "id") Long id){
        boolean isDelete = userService.delete(id);

        if(isDelete){
            return Header.OK();
        }
        return Header.Error();
    }





}
