package com.merkol.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // this is where we add all of our related advices for logging

    // let's start with an @Before advine

    // * .. () same c++
    // argüman belirtildiğinde absolute path olmalı Account değil com.merkol.aopdemo.Account gibi
    // ("execution(public * com.merkol.aopdemo.dao.*.*(..)) public herhangi bir dönüş tipinde dao paketi içindeki tüm classların tüm methodları
    // herhangi sayıda parametre
    @Before("execution(public * com.merkol.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n========>> Executing @Before advice on updateAccount()");
    }
}
