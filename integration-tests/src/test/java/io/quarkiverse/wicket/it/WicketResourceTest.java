package io.quarkiverse.wicket.it;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class WicketResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/wicket")
                .then()
                .statusCode(200)
                .body(is("Hello wicket"));
    }
}
