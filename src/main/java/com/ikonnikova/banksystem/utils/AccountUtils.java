package com.ikonnikova.banksystem.utils;

import com.ikonnikova.banksystem.entity.Account;
import com.ikonnikova.banksystem.entity.Bill;
import com.ikonnikova.banksystem.exception.NotDefaultBillException;

public class AccountUtils {

    public static Bill findDefaultBill(Account accountFrom) {
        return accountFrom.getBills()
                .stream()
                .filter(Bill::getDefault)
                .findAny()
                .orElseThrow(() -> new NotDefaultBillException("Unable to find default bill for account with id: "
                        + accountFrom.getAccountId()));
    }
}
