package com.ikonnikova.banksystem.entity;

import com.ikonnikova.banksystem.controller.dto.BillRequestDTO;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;

    private BigDecimal amount;

    private Boolean isDefault;


    public Bill(BillRequestDTO billRequestDTO) {
        amount = billRequestDTO.getAmount();
        isDefault = billRequestDTO.getDefault();
    }
    public Bill(BigDecimal amount, Boolean isDefault) {
        this.amount = amount;
        this.isDefault = isDefault;
    }

    public Bill() {
    }

    public Long getBillId() {
        return billId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billId=" + billId +
                ", amount=" + amount +
                ", isDefault=" + isDefault +
                '}';
    }
}
