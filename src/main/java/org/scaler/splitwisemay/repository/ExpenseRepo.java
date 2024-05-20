package org.scaler.splitwisemay.repository;

import org.scaler.splitwisemay.model.Expense;
import org.scaler.splitwisemay.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepo extends JpaRepository<Expense, Long> {

    List<Expense> findAllByGroup(Group g);
}
