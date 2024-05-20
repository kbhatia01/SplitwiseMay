package org.scaler.splitwisemay.commands;

import org.scaler.splitwisemay.Dtos.settleUpGroupRequestDto;
import org.scaler.splitwisemay.Dtos.settleUpUserRequestDto;
import org.scaler.splitwisemay.Dtos.settleUpUserResponseDto;
import org.scaler.splitwisemay.controller.SettleUpController;

import java.util.List;

public class SettleUpUserCommand implements command{

    private SettleUpController settleUpController;

    SettleUpUserCommand(SettleUpController settleUpController){
        this.settleUpController = settleUpController;
    }
    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));
        if(words.size()==2 && words.get(0).equals("SettleUpUser")){
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {

        List<String> words = List.of(input.split(" "));
        Long UserId = Long.valueOf(words.get(1));

        settleUpUserRequestDto request = new settleUpUserRequestDto();
        request.setUserId(UserId);

        settleUpUserResponseDto responseDto = settleUpController.settleUser(request);


    }
}
