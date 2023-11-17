package com.guillemmv.gwalletflow.Entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author GuillemBSK
 */

@Entity
public class Income extends PanacheEntity{
    private int income_id;
    private BigDecimal amount;
    
    //TODO: Income date
    @CreationTimestamp 
    private LocalDate date;
    private String source;

    public Income() {
        Random identifier = new Random();
        this.income_id = identifier.nextInt(1000);
    }

    public int getIncome_id() {
        return income_id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getSource() {
        return source;
    }

    public void setIncome_id(int income_id) {
        this.income_id = income_id;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
