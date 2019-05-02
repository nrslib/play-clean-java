import com.google.inject.AbstractModule;
import com.nrslib.clArc.inject.ServiceCollection;
import com.nrslib.clArc.inject.ServiceProvider;
import com.typesafe.config.Config;
import config.inject.DebugDependencyConfig;
import config.inject.DependencyConfig;
import config.inject.GuicyServiceProvider;
import config.inject.ProductDependencyConfig;
import play.Configuration;
import play.Environment;

public class Module extends AbstractModule implements ServiceCollection {
    private final Configuration configuration;

    public Module(Environment environment, Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> void addTransient(Class<T> clazz) {
        bind(clazz);
    }

    @Override
    public <T, TInstance extends T> void addTransient(Class<T> clazzFrom, Class<TInstance> clazzTo) {
        bind(clazzFrom).to(clazzTo);
    }

    @Override
    public <T> void addSingleton(Class<T> clazz) {
        bind(clazz).asEagerSingleton();
    }

    @Override
    public <T, TInstance extends T> void addInstance(Class<T> clazz, TInstance instance) {
        bind(clazz).toInstance(instance);
    }

    @Override
    public ServiceProvider buildServiceProvider() {
        return new GuicyServiceProvider();
    }

    @Override
    protected void configure() {
        DependencyConfig dependencyConfig = dependencyConfig();
        dependencyConfig.register(this);
    }

    private DependencyConfig dependencyConfig(){
        switch (configuration.getString("project.di")){
            case "debug": return new DebugDependencyConfig();
            case "product": return new ProductDependencyConfig();
            default: throw new RuntimeException();
        }
    }
}
