package com.merkol.aopdemo.dao;

import com.merkol.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;
    private String serviceCode;

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        // simulate an exception
        if (tripWire == true) {
            throw new RuntimeException("Şakire çay yook!!!");
        }

        List<Account> myAccounts = new ArrayList<>();

        // create a sample accounts
        Account temp1 = new Account("John", "Silver");
        Account temp2 = new Account("loki", "Gold");

        // add them to our accounts list
        myAccounts.add(temp1);
        myAccounts.add(temp2);

        return myAccounts;
    }

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": doWork()");
        return true;
    }

    public String getName() {
        System.out.println(getClass() + ": getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
