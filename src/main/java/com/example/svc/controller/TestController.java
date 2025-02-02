package com.example.svc.controller;

import com.example.svc.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService service;

    @RequestMapping(
            value = "/health/ping",
            method = RequestMethod.GET
    )
    public ResponseEntity<?> getHealth()
    {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
