package com.example.cabuser.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserCotroller {


    public void checkDriverLocation(@RequestParam("drivername") String name){

    }


}
