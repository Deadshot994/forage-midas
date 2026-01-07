package com.jpmc.midascore.entity;

import jakarta.persistence.*;

@Entity
public class TransactionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserRecord sender;

    @ManyToOne
    private UserRecord recipient;

    private Double amount;

    private Double incentive;

    // Required by JPA
    protected TransactionRecord() {
    }

    public TransactionRecord(UserRecord sender,
                             UserRecord recipient,
                             Double amount,
                             Double incentive) {
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
        this.incentive = incentive;
    }

    public Long getId() {
        return id;
    }

    public UserRecord getSender() {
        return sender;
    }

    public UserRecord getRecipient() {
        return recipient;
    }

    public Double getAmount() {
        return amount;
    }

    public Double getIncentive() {
        return incentive;
    }
}
