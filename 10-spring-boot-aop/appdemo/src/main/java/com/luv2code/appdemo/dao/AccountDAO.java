package com.luv2code.appdemo.dao;

import com.luv2code.appdemo.Account;

public interface AccountDAO {
    void addAccount(Account theAccount, boolean vipFlag);

    boolean doWork();


}
