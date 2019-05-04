package config.inject;

import com.nrslib.clArc.UseCaseBus;
import com.nrslib.clArc.UseCaseBusBuilder;
import com.nrslib.clArc.inject.ServiceCollection;
import com.nrslib.domain.model.user.UserRepository;
import com.nrslib.lib.json.objectLoader.JsonsLoader;
import com.nrslib.stubs.users.*;
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

import java.io.File;
import java.util.HashMap;

public class DebugDependencyConfig implements DependencyConfig {
    private HashMap<Class<? extends InputData>, Class<? extends UseCase<? extends InputData<? extends OutputData>, ? extends OutputData>>> usecaseClazzes
            = new HashMap<Class<? extends InputData>, Class<? extends UseCase<? extends InputData<? extends OutputData>, ? extends OutputData>>>() {
        {
            put(UserAddInputData.class, StubUserAddInteractor.class);
            put(UserDeleteInputData.class, StubUserDeleteInteractor.class);
            put(UserGetDetailInputData.class, StubUserGetDetailInteractor.class);
            put(UserGetListInputData.class, StubUserGetListInteractor.class);
            put(UserUpdateInputData.class, StubUserUpdateInteractor.class);
        }
    };

    public HashMap<Class<? extends InputData>, Class<? extends UseCase<? extends InputData<? extends OutputData>, ? extends OutputData>>> usecases() {
        return usecaseClazzes;
    }

    @Override
    public void register(ServiceCollection collection) {
        registerUseCase(collection);
        registerRepositories(collection);
        registerForDebug(collection);
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

    private void registerForDebug(ServiceCollection collection) {
        String rootPath = new File(".").getAbsoluteFile().getParent();
        JsonsLoader jsonsLoader = new JsonsLoader(rootPath + "/app/com/nrslib/stubs/jsons");
        collection.addInstance(JsonsLoader.class, jsonsLoader);
    }
}
