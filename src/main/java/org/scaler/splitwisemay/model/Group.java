package org.scaler.splitwisemay.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity(name = "userGroup")
@Data
public class Group extends BaseModel{
    private String name;

    @ManyToMany
    private List <User> members;
    @OneToMany
    private List <Expense> expenses;

    @ManyToOne
    private User createdBy;
}

// Group  1 : M   Expense
