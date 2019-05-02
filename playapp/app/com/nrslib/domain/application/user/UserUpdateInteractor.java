package com.nrslib.domain.application.user;

import com.google.inject.Inject;
import com.nrslib.domain.model.user.User;
import com.nrslib.domain.model.user.UserId;
import com.nrslib.domain.model.user.UserName;
import com.nrslib.domain.model.user.UserRepository;
import com.nrslib.usecases.user.update.UserUpdateInputData;
import com.nrslib.usecases.user.update.UserUpdateOutputData;
import com.nrslib.usecases.user.update.UserUpdateUseCase;

public class UserUpdateInteractor implements UserUpdateUseCase {
    @Inject
    private UserRepository userRepository;

    @Override
    public UserUpdateOutputData handle(UserUpdateInputData inputData) {
        UserId targetId = new UserId(inputData.getId());
        User target = userRepository.find(targetId).get();

        UserName newName = new UserName(inputData.getName());
        target.changeName(newName);

        userRepository.save(target);

        return new UserUpdateOutputData();
    }
}
