package com.bank.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Transaction {
    @Id @GeneratedValue
    private Long id;
    private Long accountId;
    private Double amount;
    private String type; // ✅ ADD THIS LINE
    private LocalDateTime timestamp = LocalDateTime.now();

    public Transaction() {}

    // Updated constructor
    public Transaction(Long accountId, Double amount, String type) {
        this.accountId = accountId;
        this.amount = amount;
        this.type = type;
    }

    public Long getId() { return id; }
    public Long getAccountId() { return accountId; }
    public void setAccountId(Long accountId) { this.accountId = accountId; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public String getType() { return type; } // ✅ ADD THIS GETTER
    public void setType(String type) { this.type = type; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
