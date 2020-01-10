package com.example.oauth2demo.web.controller;

import com.alibaba.fastjson.JSON;
import com.example.oauth2demo.dto.User;
import com.example.oauth2demo.dto.UserQueryCondition;
import com.example.oauth2demo.exception.UserNotExistException;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping
    public User createUser(@Valid @RequestBody User user){
        log.info(JSON.toJSONString(user));
        log.info(""+user.getBirthDay());
        user.setId("1");
        return user;
    }

    @PutMapping("/{id:\\d+}")
    public User updateUser(@Valid @RequestBody User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors().stream().forEach(error -> {
                FieldError fieldError = (FieldError) error;
                String message = fieldError.getField()+" "+error.getDefaultMessage();
                log.error(message);
            });
        }

        log.info(JSON.toJSONString(user));
        log.info(""+user.getBirthDay());
        user.setId("1");
        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable String id){
        log.info(id);
    }

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> query(UserQueryCondition userQueryCondition, Pageable pageable){
        log.info(JSON.toJSONString(userQueryCondition));
        log.info(JSON.toJSONString(pageable));
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable String id){
        log.info("进入getInfo服务");
        User user = new User();
        user.setUsername("tom");
        return user;
//        throw new UserNotExistException("1");
    }
}
