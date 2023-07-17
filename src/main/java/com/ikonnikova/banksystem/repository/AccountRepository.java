package com.ikonnikova.banksystem.repository;

import com.ikonnikova.banksystem.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {


}
