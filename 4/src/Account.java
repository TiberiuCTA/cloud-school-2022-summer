import java.util.*;

public class Account {
    private int id;
    private String iban;
    private Currency currency;
    private double amount;
    private Date createdDate;
    private double interest;


    public Account(int id, String iban, Currency currency, double amount, Date createdDate, double interest) {
        this.id = id;
        this.iban = iban;
        this.currency = currency;
        this.amount = amount;
        this.createdDate = createdDate;
        this.interest = interest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }
}
