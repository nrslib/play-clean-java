package com.nrslib.domain.application.user;

import com.google.inject.Inject;
import com.nrslib.domain.model.user.UserId;
import com.nrslib.domain.model.user.UserRepository;
import com.nrslib.usecases.user.common.UserData;
import com.nrslib.usecases.user.getDetail.UserGetDetailInputData;
import com.nrslib.usecases.user.getDetail.UserGetDetailOutputData;
import com.nrslib.usecases.user.getDetail.UserGetDetailUseCase;

import java.util.Optional;

public class UserGetDetailInteractor implements UserGetDetailUseCase {
    @Inject
    private UserRepository userRepository;

    @Override
    public UserGetDetailOutputData handle(UserGetDetailInputData inputData) {
        String inputId = inputData.getUserId();
        UserId targetId = new UserId(inputId);

        Optional<UserData> optUserData = userRepository.find(targetId)
                .map(x -> new UserData(x.getId().getValue(), x.getName().getValue(), x.getRole()));

        return new UserGetDetailOutputData(optUserData);
    }
}
