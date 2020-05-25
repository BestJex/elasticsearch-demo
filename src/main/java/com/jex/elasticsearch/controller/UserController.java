package com.jex.elasticsearch.controller;


import com.jex.elasticsearch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date 2020/4/16 10:43
 * @author jex
 */
@RequestMapping("/search/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/queryLikeFormUser")
    public Object queryLikeFormUser(@RequestParam String searchKey) {
        return userService.queryLikeFromUser(searchKey);
    }


}
