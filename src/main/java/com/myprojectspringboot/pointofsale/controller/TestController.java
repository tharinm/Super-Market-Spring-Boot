package com.myprojectspringboot.pointofsale.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/v1/test")
public class TestController {


    @GetMapping("/get-text-1")
    public String getMyTest(){
        String myTest="This is my first spring boot app";
        System.out.println(" "+myTest);
        return myTest;
    }

    @GetMapping("/get-text-2")
    public String  getMyTest2(){
        String myTest="This is my first spring boot app print 2";
        System.out.println(" "+myTest);
        return myTest;
    }
}
