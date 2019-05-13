package com.nrslib.domain.application.user;

import com.google.inject.Inject;
import com.nrslib.domain.model.user.User;
import com.nrslib.domain.model.user.UserId;
import com.nrslib.domain.model.user.UserName;
import com.nrslib.domain.model.user.UserRepository;
import com.nrslib.usecases.user.add.UserAddInputData;
import com.nrslib.usecases.user.add.UserAddOutputData;
import com.nrslib.usecases.user.add.UserAddUseCase;
import play.db.ebean.Transactional;

import java.util.UUID;

@Transactional
public class UserAddInteractor implements UserAddUseCase {

    @Inject
    private UserRepository userRepository;

    @Override
    public UserAddOutputData handle(UserAddInputData inputData) {
        String uuid = UUID.randomUUID().toString();

        User user = new User(
                new UserId(uuid),
                new UserName(inputData.getUserName()),
                inputData.getRole()
        );

        userRepository.save(user);

        return new UserAddOutputData(uuid);
    }
}
