package TestCases;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestCase09_DELETE_Request_LocalAPI {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost:3000";
    }

    @Test
    public void delete_request() {
        String delete_endpoint = "/users/4";

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
        when().
                delete(delete_endpoint).
        then().
                assertThat().
                statusCode(200).
                log().all();
    }

}
