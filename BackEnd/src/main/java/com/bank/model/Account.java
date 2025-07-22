package com.bank.model;

import jakarta.persistence.*;

@Entity
public class Account {
    @Id @GeneratedValue
    private Long id;
    private String owner;
    private Double balance = 0.0;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }
    public Double getBalance() { return balance; }
    public void setBalance(Double balance) { this.balance = balance; }
}
