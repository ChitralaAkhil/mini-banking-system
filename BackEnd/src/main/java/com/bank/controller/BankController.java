package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.Account;
import com.bank.model.Transaction;
import com.bank.service.BankService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class BankController {
    @Autowired private BankService svc;

    @PostMapping("/register")
    public Account register(@RequestParam String owner) { return svc.register(owner); }

    @PostMapping("/deposit")
    public Account deposit(@RequestParam Long id, @RequestParam Double amt) { return svc.deposit(id, amt); }

    @PostMapping("/withdraw")
    public Account withdraw(@RequestParam Long id, @RequestParam Double amt) { return svc.withdraw(id, amt); }

    @GetMapping("/balance")
    public Double balance(@RequestParam Long id) { return svc.history(id).stream().mapToDouble(Transaction::getAmount).sum(); }

    @GetMapping("/history")
    public List<Transaction> history(@RequestParam Long id) { return svc.history(id); }
}
