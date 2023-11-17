package com.guillemmv.gwalletflow.Entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 *
 * @author GuillemBSK
 */

@Entity
public class Category extends PanacheEntityBase{
    
    @Id
    private int category_id;
    private String name;
    private String description;

    public Category() {
    }

    public int getCategory_id() {
        return category_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
