package com.ikonnikova.banksystem.controller.dto;

import com.ikonnikova.banksystem.entity.Account;

import java.util.List;
import java.util.stream.Collectors;

public class AccountResponseDTO {

    private Long accountId;

    private String name;

    private String email;

    List<BillResponseDTO> bills;

    public AccountResponseDTO(Long accountId, String name, String email, List<BillResponseDTO> bills) {
        this.accountId = accountId;
        this.name = name;
        this.email = email;
        this.bills = bills;
    }

    public AccountResponseDTO(Account account) {
        accountId = account.getAccountId();
        name = account.getName();
        email = account.getEmail();
        bills = account.getBills().stream()
                .map(BillResponseDTO::new)
                .collect(Collectors.toList());
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<BillResponseDTO> getBills() {
        return bills;
    }

    public void setBills(List<BillResponseDTO> bills) {
        this.bills = bills;
    }

    public AccountResponseDTO() {
    }


}
