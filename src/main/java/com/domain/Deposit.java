package com.domain;


import java.util.*;
import java.util.Objects;

public class Deposit {
    private int id;
    private int amount;
    private int term;
    private String currency;
    private List<Bank> banks;

    public Deposit() {
    }

    private Deposit(Builder builder) {
        this.id = builder.id;
        this.amount = builder.amount;
        this.term = builder.term;
        this.currency = builder.currency;
        this.banks = builder.banks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<Bank> getBanks() {
        return banks;
    }

    public void setBanks(List<Bank> banks) {
        this.banks = banks;
    }

    public static Builder builder() {
        return new Builder();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deposit deposit = (Deposit) o;
        return id == deposit.id &&
                amount == deposit.amount &&
                term == deposit.term &&
                Objects.equals(currency, deposit.currency) &&
                Objects.equals(banks, deposit.banks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, term, currency, banks);
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "id=" + id +
                ", amount=" + amount +
                ", term=" + term +
                ", currency='" + currency + '\'' +
                ", bankOffers=" + banks +
                '}';
    }

    public static class Builder {
        private Integer id;
        private Integer amount;
        private Integer term;
        private String currency;
        private List<Bank> banks;

        private Builder() {
        }

        public Deposit build() {
            return new Deposit(this);
        }

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withAmount(Integer amount) {
            this.amount = amount;
            return this;
        }

        public Builder withTerm(Integer term) {
            this.term = term;
            return this;
        }

        public Builder withCurrency(String currency) {
            this.currency = currency;
            return this;
        }

        public Builder withAccounts(List<Bank> banks) {
            this.banks = banks;
            return this;
        }

    }


}
