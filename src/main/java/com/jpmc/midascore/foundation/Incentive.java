package com.jpmc.midascore.foundation;

import jakarta.persistence.criteria.CriteriaBuilder;

public class Incentive {

    private float amount;

    public Incentive() {

    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
