package lib.forClArc;

import com.nrslib.clArc.inject.ServiceProvider;
import com.nrslib.clArc.invoke.UseCaseInvoker;
import com.nrslib.clArc.invoke.UseCaseInvokerFactory;

public class PlayUseCaseInvokerFactory implements UseCaseInvokerFactory {
    @Override
    public UseCaseInvoker generate(Class implementClazz, ServiceProvider provider) {
        try {
            return new PlayUseCaseInvoker(implementClazz, provider);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
