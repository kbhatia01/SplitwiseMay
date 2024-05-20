package org.scaler.splitwisemay.repository;

import org.scaler.splitwisemay.model.ExpenseUser;
import org.scaler.splitwisemay.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseUserRepo extends JpaRepository<ExpenseUser, Long> {

    List<ExpenseUser> findAllByUser(User u);
}
