package com.ikonnikova.banksystem.controller;

import com.ikonnikova.banksystem.controller.dto.AccountRequestDTO;
import com.ikonnikova.banksystem.controller.dto.AccountResponseDTO;
import com.ikonnikova.banksystem.entity.Bill;
import com.ikonnikova.banksystem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public AccountResponseDTO getById(@PathVariable Long accountId) {
        return new AccountResponseDTO(accountService.getById(accountId));
    }

    @PostMapping("/accounts")
    public Long create(@RequestBody AccountRequestDTO accountRequestDTO) {
        return accountService.save(accountRequestDTO.getName(),
                accountRequestDTO.getEmail(), accountRequestDTO.getBills()
                        .stream().map(Bill::new)
                        .collect(Collectors.toList()));
    }
}
