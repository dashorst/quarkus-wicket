package io.quarkiverse.wicket.runtime;

import org.apache.wicket.Page;
import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.protocol.http.WebApplication;

import io.quarkiverse.wicket.runtime.arc.ArcInjector;
import io.quarkiverse.wicket.runtime.config.WicketConfiguration;
import io.quarkus.logging.Log;
import io.quarkus.runtime.LaunchMode;
import jakarta.inject.Inject;

/**
 * Base class for Wicket applications in Quarkus.
 * 
 * Configures the CDI integration with ArC.
 * 
 * Integrates Wicket's development mode with Quarkus' development mode.
 */
public abstract class QuarkusWicketApplication extends WebApplication {
    @Inject
    ArcInjector injector;

    @Inject
    WicketConfiguration config;

    Class<? extends Page> homePage = null;

    public QuarkusWicketApplication() {
        Log.infof("QuarkusWicketApplication constructor");

        // Setup the Wicket runtime behavior based on the configuration of Quarkus'
        // launch mode.
        setConfigurationType(switch (LaunchMode.current()) {
            case DEVELOPMENT -> RuntimeConfigurationType.DEVELOPMENT;
            default -> RuntimeConfigurationType.DEPLOYMENT;
        });
    }

    @Override
    protected void init() {

        // Setup the ArC CDI configuration
        injector.bind(this);

        getBehaviorInstantiationListeners().add(injector);
        getComponentInstantiationListeners().add(injector);
        getSessionListeners().add(injector);

        super.init();
    }
}
