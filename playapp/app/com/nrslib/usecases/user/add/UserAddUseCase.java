package com.nrslib.usecases.user.add;

import com.nrslib.usecases.core.UseCase;
import play.db.ebean.Transactional;

@Transactional
public interface UserAddUseCase extends UseCase<UserAddInputData, UserAddOutputData> {
}
