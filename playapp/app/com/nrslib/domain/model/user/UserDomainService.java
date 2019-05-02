package com.nrslib.domain.model.user;

import com.google.inject.Inject;

public class UserDomainService {
    @Inject
    private UserRepository userRepository;

    public boolean isDuplicated(User user) {
        return false;
    }
}
