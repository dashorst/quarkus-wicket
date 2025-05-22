package io.quarkiverse.wicket.runtime.config;

import io.smallrye.config.WithDefault;

public interface WicketFilterConfiguration {
    /**
     * The path spec of the Wicket filter mapping.
     */
    @WithDefault("/*")
    String filterMapping();
}
