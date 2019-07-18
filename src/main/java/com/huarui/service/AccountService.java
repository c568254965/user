package com.huarui.service;

import com.huarui.dao.AccountMapper;
import com.huarui.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sloan on 2019/7/13.
 */

@Service("accountService")
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;

    public Account findAccountById(Long id){

        return accountMapper.findAccountById(id);
    }
}
