package com.merkol.aopdemo.aspect;

import com.merkol.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Around("execution(* com.merkol.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // print out method we are advising on
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("====>> Executing @Around on method: " + method);

        // get begin timestamp
        long begin = System.currentTimeMillis();
        // execute the method
        Object result = null;

        try {
            proceedingJoinPoint.proceed();
        }
        catch (Exception exc) {
            // log the exception
            System.out.println(exc.getMessage());

            // rethrow exception
            throw exc;
        }

        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display
        long duration = end - begin;
        System.out.println("====>>> Duration: " + duration / 1000.0 + " seconds");

        return result;
    }

    @After("execution(* com.merkol.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("====>> Executing @After (Finally) on method: " + method);

    }


    @AfterThrowing(
            pointcut = "execution(* com.merkol.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable theExc) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("====>> Executing @AfterThrowing on method: " + method);

        // log the exception
        System.out.println("====>> The exception is: " + theExc);
    }

    @AfterReturning(
            pointcut = "execution(* com.merkol.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("====>> Executing @AfterReturning on method: " + method);

        // print out the results of the method call
        System.out.println("====>> result is " + result);

        // modify result data
        convertAccountNameToUpperCase(result);

        System.out.println("====>> result is " + result);
    }

    private void convertAccountNameToUpperCase(List<Account> result) {
        // loop through accounts
        for (Account temp : result) {
            String upperName = temp.getName().toUpperCase();

            // update
            temp.setName(upperName);
        }
    }


    // * .. () same c/c++ unix systems
    // argüman belirtildiğinde absolute path olmalı Account değil com.merkol.aopdemo.Account gibi
    // ("execution(public * com.merkol.aopdemo.dao.*.*(..)) public herhangi bir dönüş tipinde dao paketi içindeki tüm classların tüm methodları
    // herhangi sayıda parametre
    @Before("com.merkol.aopdemo.aspect.MerkolAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("========>> Executing @Before advice on method");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("method : " + methodSignature);

        // display method arguments
        Object[] args = theJoinPoint.getArgs();

        for (Object tempArg : args) {
            System.out.println(tempArg);

            if (tempArg instanceof Account theAccount) {
                System.out.println("account name: " + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());
            }
        }
    }


}
