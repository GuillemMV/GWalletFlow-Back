package com.guillemmv.gwalletflow.Entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author GuillemBSK
 */

@Entity
public class Expense extends PanacheEntityBase{
    
    @Id
    private int expense_id;
    private BigDecimal amount;
    
    //TODO: Expense date
    @CreationTimestamp
    private LocalDate date;
    private int category_id;
    private String description;

    public Expense() {
        Random identifier = new Random();
        this.expense_id = identifier.nextInt(1000);
    }

    public int getExpense_id() {
        return expense_id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getCategory_id() {
        return category_id;
    }

    public String getDescription() {
        return description;
    }

    public void setExpense_id(int expense_id) {
        this.expense_id = expense_id;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
