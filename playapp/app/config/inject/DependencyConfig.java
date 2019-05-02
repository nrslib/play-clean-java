package config.inject;

import com.nrslib.clArc.inject.ServiceCollection;

public interface DependencyConfig {
    void register(ServiceCollection collection);
}
