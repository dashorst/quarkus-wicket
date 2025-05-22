package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import io.quarkiverse.wicket.runtime.QuarkusWicketApplication;

@ApplicationScoped
public class MyApplication extends QuarkusWicketApplication {
    @Override
    public Class<? extends org.apache.wicket.Page> getHomePage() {
        return MyPage.class;
    }
}
