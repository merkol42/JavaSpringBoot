package com.merkol.aopdemo.dao;

import com.merkol.aopdemo.Account;

import java.util.List;

public interface AccountDAO {

    void addAccount(Account account, boolean vipFlag);

    boolean doWork();

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);

    List<Account> findAccounts();

    List<Account> findAccounts(boolean tripWire);
}
