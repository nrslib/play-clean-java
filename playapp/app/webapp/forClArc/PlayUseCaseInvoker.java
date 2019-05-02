package webapp.forClArc;

import com.nrslib.clArc.inject.ServiceProvider;
import com.nrslib.clArc.invoke.UseCaseInvoker;
import com.nrslib.usecases.core.InputData;
import com.nrslib.usecases.core.OutputData;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Stream;

public class PlayUseCaseInvoker implements UseCaseInvoker {
    private final Class implementClazz;
    private final ServiceProvider provider;
    private final Method handleMethod;

    PlayUseCaseInvoker(Class implementClazz, ServiceProvider provider) throws NoSuchMethodException {
        this.implementClazz = implementClazz;
        this.provider = provider;
        Stream<Method> methods = Arrays.stream(implementClazz.getMethods());
        handleMethod = methods.filter(x -> x.getName().equals("handle")).findFirst().get();
    }

    @Override
    public <TOutputData extends OutputData> TOutputData invoke(InputData<TOutputData> inputData)
    {
        Object interactor = provider.getService(implementClazz);

        Object outputData = null;
        try {
            outputData = handleMethod.invoke(interactor, inputData);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return (TOutputData) outputData;
    }
}
