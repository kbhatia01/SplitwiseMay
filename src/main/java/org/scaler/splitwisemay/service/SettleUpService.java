package org.scaler.splitwisemay.service;


import org.scaler.splitwisemay.Stratergy.SettleUpStratergy;
import org.scaler.splitwisemay.model.Expense;
import org.scaler.splitwisemay.model.ExpenseUser;
import org.scaler.splitwisemay.model.Group;
import org.scaler.splitwisemay.model.User;
import org.scaler.splitwisemay.repository.ExpenseRepo;
import org.scaler.splitwisemay.repository.ExpenseUserRepo;
import org.scaler.splitwisemay.repository.GroupRepo;
import org.scaler.splitwisemay.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SettleUpService {

    private UserRepository userRepository;
    private ExpenseUserRepo expenseUserRepo;
    private SettleUpStratergy settleUpStratergy;

    private GroupRepo groupRepo;

    private ExpenseRepo expenseRepo;
    SettleUpService(
            UserRepository userRepository,
            ExpenseUserRepo expenseUserRepo,
            SettleUpStratergy settleUpStratergy,
            GroupRepo groupRepo,
            ExpenseRepo expenseRepo
    ){
        this.userRepository = userRepository;
        this.expenseUserRepo = expenseUserRepo;
        this.settleUpStratergy = settleUpStratergy;
        this.groupRepo = groupRepo;
        this.expenseRepo = expenseRepo;
    }

    public List<Expense> settleUpUser(Long userId){
        // 1. fetch user details and validate the user..
        Optional<User> optionalUser = userRepository.findById(userId);

        if(optionalUser.isEmpty()){
            throw new RuntimeException("User Not present..");
        }
        User u = optionalUser.get();


        // 2. getting all the expenses related to the user.

        List<ExpenseUser> expenseUsers = expenseUserRepo.findAllByUser(u);
        Set<Expense> expenseSet = new HashSet<>();

        for(ExpenseUser expenseUser: expenseUsers){
            expenseSet.add(expenseUser.getExpense());
        }



        // 3. iterate all the expenses and find who ouws what..
        // 4. find the transactions to be done..

        List<Expense> expenses = settleUpStratergy.settleUp(expenseSet.stream().toList());
        // 5. return the transactions..

        return expenses;
    }

    public List<Expense> settleUpGroup(Long groupId){

        // 1. validate the group
        Optional<Group> groupOptional = groupRepo.findById(groupId);

        if(groupOptional.isEmpty()){
            throw new RuntimeException("Group not found..");
        }

        Group g = groupOptional.get();
        // 2. extract all expense of group
        List<Expense> expenses = expenseRepo.findAllByGroup(g);
        // 3. iterate all the expenses and find who ouws what..
        // 4. find the transactions to be done..

        List<Expense> transactions = settleUpStratergy.settleUp(expenses);
        // return transaction..

        return transactions;


    }
}
