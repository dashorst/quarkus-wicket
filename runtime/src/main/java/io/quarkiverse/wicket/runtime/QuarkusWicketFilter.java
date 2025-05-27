package io.quarkiverse.wicket.runtime;

import jakarta.inject.Inject;

import org.apache.wicket.protocol.http.WicketFilter;

public class QuarkusWicketFilter extends WicketFilter {
    @Inject
    public QuarkusWicketFilter(QuarkusWicketApplication application) {
        super(application);
        setFilterPath("/*");
    }
}
