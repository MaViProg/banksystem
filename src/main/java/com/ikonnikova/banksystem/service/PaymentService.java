package com.ikonnikova.banksystem.service;

import com.ikonnikova.banksystem.entity.Account;
import com.ikonnikova.banksystem.entity.Bill;
import com.ikonnikova.banksystem.utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentService {

    private final AccountService accountService;

    @Autowired
    public PaymentService(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * Списание со счета
     *
     * @param accountId
     * @param paymentAmount
     * @return
     */
    public Object pay(Long accountId, BigDecimal paymentAmount) {
        Account account = accountService.getById(accountId);
        Bill defaultBill = AccountUtils.findDefaultBill(account);
        defaultBill.setAmount(defaultBill.getAmount().subtract(paymentAmount));
        accountService.update(account);
        return "Success";
    }

    /**
     * Добавление на счет
     *
     * @param accountId
     * @param paymentAmount
     * @return
     */
    public Object add(Long accountId, BigDecimal paymentAmount) {
        Account account = accountService.getById(accountId);
        Bill defaultBill = AccountUtils.findDefaultBill(account);
        BigDecimal newAmount = defaultBill.getAmount().add(paymentAmount);
        defaultBill.setAmount(newAmount);
        accountService.update(account);
        return "Success";
    }

}
