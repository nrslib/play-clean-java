package com.nrslib.clArc;

import com.nrslib.clArc.inject.ServiceCollection;
import com.nrslib.clArc.invoke.UseCaseInvokerFactory;
import com.nrslib.usecases.core.InputData;
import com.nrslib.usecases.core.UseCase;

public class UseCaseBusBuilder {
    private ServiceCollection services;
    private UseCaseBus bus = new UseCaseBus();

    public UseCaseBusBuilder(ServiceCollection services){
        this.services = services;
    }

    public <TInputData extends InputData, TInteractor extends UseCase> void register(Class<TInputData> inputDataClazz, Class<TInteractor> interactorClazz){
        services.addTransient(interactorClazz);
        bus.register(inputDataClazz, interactorClazz);
    }

    public UseCaseBus build(UseCaseInvokerFactory invokerFactory){
        bus.setup(services.buildServiceProvider(), invokerFactory);
        return bus;
    }
}
