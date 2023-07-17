package com.ikonnikova.banksystem.service;

import com.ikonnikova.banksystem.entity.Account;
import com.ikonnikova.banksystem.entity.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static com.ikonnikova.banksystem.utils.AccountUtils.findDefaultBill;

@Service
public class TransferService {

    private final AccountService accountService;

    @Autowired
    public TransferService(AccountService accountService) {
        this.accountService = accountService;
    }

    public Object transfer(Long accountIdFrom, Long accountIdTo, BigDecimal amount) {
        Account accountFrom = accountService.getById(accountIdFrom);
        Account accountTo = accountService.getById(accountIdTo);
        Bill billFrom = findDefaultBill(accountFrom);
        Bill billTo = findDefaultBill(accountTo);
        billFrom.setAmount(billFrom.getAmount().subtract(amount));
        billTo.setAmount(billTo.getAmount().add(amount));
        accountService.update(accountFrom);
        accountService.update(accountTo);
        return "Success";
    }

}
