package io.quarkiverse.wicket.runtime.config;

import org.apache.wicket.protocol.http.WicketFilter;

import io.quarkus.runtime.annotations.ConfigPhase;
import io.quarkus.runtime.annotations.ConfigRoot;
import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;

@ConfigMapping(prefix = "quarkus.wicket")
@ConfigRoot(phase = ConfigPhase.BUILD_AND_RUN_TIME_FIXED)
public interface WicketConfiguration {
    /**
     * The name of the Wicket application class.
     */
    @WithDefault("io.quarkiverse.wicket.runtime.QuarkusWicketApplication")
    String applicationClassName();

    /**
     * The configuration for the {@link WicketFilter}
     * 
     * @return the filter configuration
     */
    WicketFilterConfiguration filter();
}
