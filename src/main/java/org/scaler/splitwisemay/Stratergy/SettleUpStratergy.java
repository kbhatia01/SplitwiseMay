package org.scaler.splitwisemay.Stratergy;

import org.scaler.splitwisemay.model.Expense;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SettleUpStratergy {

    public List<Expense> settleUp(List<Expense> expenses);
}
