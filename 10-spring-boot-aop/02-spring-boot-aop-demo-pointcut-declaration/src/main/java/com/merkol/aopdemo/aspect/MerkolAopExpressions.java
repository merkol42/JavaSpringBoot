package com.merkol.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MerkolAopExpressions {
    // pointcut declaration
    @Pointcut("execution(public * com.merkol.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(public * com.merkol.aopdemo.dao.*.get*(..))")
    public void forGetterMethod() {}

    @Pointcut("execution(public * com.merkol.aopdemo.dao.*.set*(..))")
    public void forSetterMethod() {}

    @Pointcut("forDaoPackage() && !(forGetterMethod() || forSetterMethod())")
    public void forDaoPackageNoGetterSetter() {}
}
