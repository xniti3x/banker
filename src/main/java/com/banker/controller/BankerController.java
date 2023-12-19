package com.banker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banker.dto.Token;
import com.banker.service.BankerService;


@RestController
public class BankerController {

   @Autowired private BankerService serviceBanker;

    @GetMapping("/login")
    public Token getNewToken(){

        return serviceBanker.login();

    }
}
