package com.domain;

import java.util.Objects;

public class Bank {

    private int id;
    private boolean replenish;
    private boolean withdraw;

    public Bank() {

    }

    public Bank(int id, boolean replenish, boolean withdraw) {
        this.id = id;
        this.replenish = replenish;
        this.withdraw = withdraw;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isReplenish() {
        return replenish;
    }

    public void setReplenish(boolean replenish) {
        this.replenish = replenish;
    }

    public boolean isWithdraw() {
        return withdraw;
    }

    public void setWithdraw(boolean withdraw) {
        this.withdraw = withdraw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return id == bank.id &&
                replenish == bank.replenish &&
                withdraw == bank.withdraw;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, replenish, withdraw);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", replenish=" + replenish +
                ", withdraw=" + withdraw +
                '}';
    }
}
