package TestCases;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestCase07_POST_Request_LocalAPI {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost:3000";
    }

    @Test
    public void post_request() {
        String post_endpoint = "/users";

        JSONObject requestPayload = new JSONObject();
        requestPayload.put("id", 5);
        requestPayload.put("first_name", "Jan");
        requestPayload.put("last_name", "Kowal");

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(requestPayload.toJSONString()).
        when().
                post(post_endpoint).
        then().
                assertThat().
                statusCode(201).
                log().body();
    }

}
