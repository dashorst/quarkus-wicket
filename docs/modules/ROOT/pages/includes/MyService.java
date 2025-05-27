package org.acme;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MyService {
    public String greet() {
        return "Hello from MyService!";
    }
}
