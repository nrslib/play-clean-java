package com.nrslib.domain.model.user;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    public void save(User user);
    public void remove(User user);
    public List<User> findAll();
    public Optional<User> find(UserId id);
}
