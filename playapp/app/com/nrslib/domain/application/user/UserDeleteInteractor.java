package com.nrslib.domain.application.user;

import com.google.inject.Inject;
import com.nrslib.domain.model.user.UserId;
import com.nrslib.domain.model.user.UserRepository;
import com.nrslib.usecases.user.delete.UserDeleteInputData;
import com.nrslib.usecases.user.delete.UserDeleteOutputData;
import com.nrslib.usecases.user.delete.UserDeleteUseCase;

public class UserDeleteInteractor implements UserDeleteUseCase {
    @Inject
    private UserRepository userRepository;

    @Override
    public UserDeleteOutputData handle(UserDeleteInputData inputData) {
        UserId targetId = new UserId(inputData.getId());

        userRepository
                .find(targetId)
                .ifPresent(x -> userRepository.remove(x));

        return new UserDeleteOutputData();
    }
}
