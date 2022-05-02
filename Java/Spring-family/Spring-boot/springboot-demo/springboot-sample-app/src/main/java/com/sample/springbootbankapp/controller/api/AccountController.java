package com.sample.springbootbankapp.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Warun
 * @createdOn 18-10-2021
 **/
@RestController
//@RequestMapping("/api/warun")
public class AccountController {

    @GetMapping(value = "/test")
    public String test() {
        =new String();

        return "This is Warun! Welcome to world";
    }

    @RequestMapping(value = "/")
    public String test1() {

        return "************";
    }




}
