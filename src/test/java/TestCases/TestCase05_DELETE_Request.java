package TestCases;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class TestCase05_DELETE_Request {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @Test
    public void delete_request() {
        String delete_endpoint = "/api/users/2";

        when().
            delete(delete_endpoint).
        then().
            statusCode(204).
            log().all();

    }

}
