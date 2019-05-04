package config.inject;

import com.nrslib.clArc.UseCaseBus;
import com.nrslib.clArc.UseCaseBusBuilder;
import com.nrslib.clArc.inject.ServiceCollection;
import com.nrslib.domain.application.user.*;
import com.nrslib.domain.model.user.UserRepository;
import com.nrslib.usecases.core.InputData;
import com.nrslib.usecases.core.OutputData;
import com.nrslib.usecases.core.UseCase;
import com.nrslib.usecases.user.add.UserAddInputData;
import com.nrslib.usecases.user.delete.UserDeleteInputData;
import com.nrslib.usecases.user.getDetail.UserGetDetailInputData;
import com.nrslib.usecases.user.getList.UserGetListInputData;
import com.nrslib.usecases.user.update.UserUpdateInputData;
import gateways.user.EBeanUserRepository;
import lib.forClArc.PlayUseCaseInvokerFactory;

import java.util.HashMap;

public class ProductDependencyConfig implements DependencyConfig {
    private HashMap<Class<? extends InputData>, Class<? extends UseCase<? extends InputData<? extends OutputData>, ? extends OutputData>>> usecaseClazzes
            = new HashMap<Class<? extends InputData>, Class<? extends UseCase<? extends InputData<? extends OutputData>, ? extends OutputData>>>() {
        {
            put(UserAddInputData.class, UserAddInteractor.class);
            put(UserDeleteInputData.class, UserDeleteInteractor.class);
            put(UserGetDetailInputData.class, UserGetDetailInteractor.class);
            put(UserGetListInputData.class, UserGetListInteractor.class);
            put(UserUpdateInputData.class, UserUpdateInteractor.class);
        }
    };

    public HashMap<Class<? extends InputData>, Class<? extends UseCase<? extends InputData<? extends OutputData>, ? extends OutputData>>> usecases() {
        return usecaseClazzes;
    }

    @Override
    public void register(ServiceCollection collection) {
        registerUseCase(collection);
        registerRepositories(collection);
    }

    private void registerUseCase(ServiceCollection collection) {
        UseCaseBusBuilder builder = new UseCaseBusBuilder(collection);
        usecases().forEach(builder::register);

        UseCaseBus bus = builder.build(new PlayUseCaseInvokerFactory());
        collection.addInstance(UseCaseBus.class, bus);
    }

    private void registerRepositories(ServiceCollection collection){
        collection.addTransient(UserRepository.class, EBeanUserRepository.class);
    }
}
