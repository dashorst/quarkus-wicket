package org.acme;

import jakarta.inject.Singleton;
import io.quarkiverse.wicket.runtime.QuarkusWicketApplication;

@Singleton
public class MyApplication extends QuarkusWicketApplication {
    @Override
    protected void init() {
        super.init();

        // Add your configuration here
    }

    @Override
    public Class<? extends org.apache.wicket.Page> getHomePage() {
        return MyPage.class;
    }
}
