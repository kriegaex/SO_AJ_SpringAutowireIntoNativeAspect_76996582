package com.example.svc.accesscontrol;

import com.example.svc.service.TestService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.ResponseEntity;

@Aspect
@Configurable
public class AuthorizationAspect {

    @Autowired
    private TestService service;

    @Around("execution(* com.example.svc.controller.TestController.getHealth(..))")
    public ResponseEntity<?> authorize(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(service);
        String s = service.getStr();
        System.out.println(s);
        return (ResponseEntity<?>) joinPoint.proceed();
    }

}
