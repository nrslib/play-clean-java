package com.nrslib.domain.application.user;

import com.google.inject.Inject;
import com.nrslib.domain.model.user.User;
import com.nrslib.domain.model.user.UserRepository;
import com.nrslib.usecases.user.common.UserData;
import com.nrslib.usecases.user.getList.UserGetListInputData;
import com.nrslib.usecases.user.getList.UserGetListOutputData;
import com.nrslib.usecases.user.getList.UserGetListUseCase;

import java.util.List;
import java.util.stream.Collectors;

public class UserGetListInteractor implements UserGetListUseCase {
    @Inject
    private UserRepository userRepository;

    public UserGetListOutputData handle(UserGetListInputData inputData) {
        List<User> users = userRepository.findAll();

        List<UserData> userData = users.stream()
                .map(x -> new UserData(x.getId().getValue(), x.getName().getValue()))
                .collect(Collectors.toList());

        return new UserGetListOutputData(userData);
    }
}
