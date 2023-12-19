package com.banker.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.banker.dto.Credentionals;
import com.banker.dto.Token;

@Service
public class BankerService {

     @Value("${bank.transaction.url}")
    private String url;

    @Value("${bank.transaction.secret_id}")
    private String secret_id;

    @Value("${bank.transaction.secret_key}")
    private String secret_key;

    private final String NEW_TOKEN = "token/new/";

    public Token login(){
    
         RestTemplate restTemplate = new RestTemplate();

        Credentionals cre = Credentionals.builder()
         .secret_id(secret_id)
         .secret_key(secret_key)
         .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Content-Type", "application/json");

       
        HttpEntity<Credentionals> entity = new HttpEntity<>(cre,headers);
        ResponseEntity<Token> result = restTemplate.exchange(url+NEW_TOKEN, HttpMethod.POST, entity, Token.class);
        System.out.println(result.toString());
        return result.getBody();
    }        
}
