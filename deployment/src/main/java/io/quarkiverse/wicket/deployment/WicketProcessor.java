package io.quarkiverse.wicket.deployment;

import java.io.IOException;

import io.quarkiverse.wicket.runtime.config.WicketConfiguration;
import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import io.quarkus.deployment.builditem.GeneratedResourceBuildItem;
import io.quarkus.vertx.http.deployment.spi.GeneratedStaticResourceBuildItem;
import jakarta.inject.Inject;

class WicketProcessor {

    private static final String FEATURE = "wicket";

    @Inject
    WicketConfiguration config;

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @BuildStep
    void generateApplicationClass(BuildProducer<GeneratedStaticResourceBuildItem> generatedStaticResourceProducer,
    BuildProducer<GeneratedResourceBuildItem> generatedResourceProducer) throws IOException{
        generatedResourceProducer.produce(new GeneratedResourceBuildItem());;
    }
}
