package com.ikonnikova.banksystem.controller.dto;

import java.util.List;

public class AccountRequestDTO {

    private String name;

    private String email;

    private List<BillRequestDTO> bills;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<BillRequestDTO> getBills() {
        return bills;
    }

    public AccountRequestDTO(String name, String email, List<BillRequestDTO> bills) {
        this.name = name;
        this.email = email;
        this.bills = bills;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBills(List<BillRequestDTO> bills) {
        this.bills = bills;
    }
}
