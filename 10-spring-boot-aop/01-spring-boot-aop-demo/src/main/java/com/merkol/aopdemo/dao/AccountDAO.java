package com.merkol.aopdemo.dao;

import com.merkol.aopdemo.Account;

public interface AccountDAO {

    void addAccount(Account account, boolean vipFlag);

    boolean doWork();
}
