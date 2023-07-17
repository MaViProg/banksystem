package com.ikonnikova.banksystem.controller.dto;

import java.math.BigDecimal;

public class BillRequestDTO {

    private BigDecimal amount;

    private Boolean isDefault;

    public BigDecimal getAmount() {
        return amount;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public BillRequestDTO(BigDecimal amount, Boolean isDefault) {
        this.amount = amount;
        this.isDefault = isDefault;
    }
}
