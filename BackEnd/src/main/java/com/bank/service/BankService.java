package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.model.Account;
import com.bank.model.Transaction;
import com.bank.repository.AccountRepository;
import com.bank.repository.TransactionRepository;

@Service
public class BankService {
    @Autowired private AccountRepository accRepo;
    @Autowired private TransactionRepository txRepo;

    public Account register(String owner) {
        Account acc = new Account();
        acc.setOwner(owner);
        return accRepo.save(acc);
    }

    public Account deposit(Long id, Double amt) {
        Account acc = accRepo.findById(id).orElseThrow();
        acc.setBalance(acc.getBalance() + amt);
        accRepo.save(acc);
        txRepo.save(new Transaction(id, amt,"DEPOSIT"));
        return acc;
    }

    public Account withdraw(Long id, Double amt) {
        Account acc = accRepo.findById(id).orElseThrow();
        if (acc.getBalance() < amt) throw new RuntimeException("Insufficient funds");
        acc.setBalance(acc.getBalance() - amt);
        accRepo.save(acc);
        txRepo.save(new Transaction(id, -amt,"WITHDRAW"));
        return acc;
    }

    public List<Transaction> history(Long id) {
        return txRepo.findByAccountId(id);
    }
}
