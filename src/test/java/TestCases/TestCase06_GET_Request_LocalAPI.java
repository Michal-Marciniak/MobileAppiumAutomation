package TestCases;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class TestCase06_GET_Request_LocalAPI {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost:3000";
    }

    @Test
    public void get_request() {
        String get_endpoint = "/users";

        given().
                param("first_name", "Michal").
        when().
                get(get_endpoint).
        then().
                assertThat().
                statusCode(200).
                log().body();
    }

}
