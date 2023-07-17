package com.ikonnikova.banksystem.controller;

import com.ikonnikova.banksystem.controller.dto.PaymentRequestDTO;
import com.ikonnikova.banksystem.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    /**
     * Метод по спианию денег со счета
     *
     * @param paymentRequestDTO
     * @return
     */
    @PostMapping("/payments/pay")
    public Object pay(@RequestBody PaymentRequestDTO paymentRequestDTO) {
        return paymentService.pay(paymentRequestDTO.getAccountId(),
                paymentRequestDTO.getAmount());
    }

    /**
     * Метод по добавлению денег на счет
     *
     * @param paymentRequestDTO
     * @return
     */
    @PostMapping("/payments/add")
    public Object add(@RequestBody PaymentRequestDTO paymentRequestDTO) {
        return paymentService.add(paymentRequestDTO.getAccountId(),
                paymentRequestDTO.getAmount());
    }
}
