package io.quarkiverse.wicket.deployment;

import jakarta.inject.Inject;

import io.quarkiverse.wicket.runtime.config.WicketConfiguration;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;

class WicketProcessor {
    private static final String FEATURE = "wicket";

    @Inject
    WicketConfiguration config;

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }
}
