package org.acme;

import org.apache.wicket.markup.html.WebPage;

import com.google.inject.Inject;

public class MyPage extends WebPage {
    private static final long serialVersionUID = 1L;

    @Inject
    MyService myService;

    public MyPage() {
        myService.greet();
    }
}
