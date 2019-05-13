package lib.forClArc;

import com.avaje.ebean.Ebean;
import com.nrslib.clArc.inject.ServiceProvider;
import com.nrslib.clArc.invoke.UseCaseInvoker;
import com.nrslib.usecases.core.InputData;
import com.nrslib.usecases.core.OutputData;
import play.db.ebean.Transactional;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Stream;

public class PlayUseCaseInvoker implements UseCaseInvoker {
    private final Class implementClazz;
    private final ServiceProvider provider;
    private final Method handleMethod;
    private final boolean hasTransaction;

    PlayUseCaseInvoker(Class implementClazz, ServiceProvider provider) {
        this.implementClazz = implementClazz;
        this.provider = provider;
        Stream<Method> methods = Arrays.stream(implementClazz.getMethods());
        handleMethod = methods.filter(x -> x.getName().equals("handle")).findFirst().get();
        hasTransaction = this.implementClazz.getAnnotation(Transactional.class) != null;
    }

    @Override
    public <TOutputData extends OutputData> TOutputData invoke(InputData<TOutputData> inputData) {
        Object interactor = provider.getService(implementClazz);

        Object outputData;
        if(hasTransaction) {
            outputData = Ebean.execute(() -> invoke(interactor, inputData));
        }else{
            outputData = invoke(interactor, inputData);
        }

        return (TOutputData) outputData;
    }

    private <TOutputData extends OutputData> TOutputData invoke(Object interactor, InputData<TOutputData> inputData){
        Object result;
        try {
            result = handleMethod.invoke(interactor, inputData);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return (TOutputData)result;
    }
}
