package com.ikonnikova.banksystem.controller;

import com.ikonnikova.banksystem.controller.dto.TransferRequestDTO;
import com.ikonnikova.banksystem.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    private final TransferService transferService;

    @Autowired
    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    /**
     * Метод по трансферу денег на другой счет
     *
     * @param transferRequestDTO
     * @return
     */
    @PostMapping("/transfers")
    public Object transfer(@RequestBody TransferRequestDTO transferRequestDTO) {
        return transferService.transfer(transferRequestDTO.getAccountIdFrom(),
                transferRequestDTO.getAccountIdTo(),
                transferRequestDTO.getAmount());

    }
}
