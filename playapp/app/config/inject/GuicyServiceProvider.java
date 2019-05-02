package config.inject;

import com.nrslib.clArc.inject.ServiceProvider;
import play.api.Play;

public class GuicyServiceProvider implements ServiceProvider {
    @Override
    public <T> T getService(Class<T> clazz)
    {
        return Play.current().injector().instanceOf(clazz);
    }
}
