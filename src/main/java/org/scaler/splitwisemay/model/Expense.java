package org.scaler.splitwisemay.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Expense extends BaseModel{
    private String description;
    private int amount;

    @ManyToOne
    private User createdBy;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;

    @ManyToOne
    private Group group;

    @OneToMany
    List<ExpenseUser> expenseUsers;
}
