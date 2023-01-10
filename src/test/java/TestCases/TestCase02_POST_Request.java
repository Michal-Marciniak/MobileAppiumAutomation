package TestCases;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestCase02_POST_Request {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @Test
    public void post_request() {
        String post_endpoint = "/api/users";

        JSONObject requestPayload = new JSONObject();
        requestPayload.put("name", "Michael");
        requestPayload.put("job", "Test Automation Engineer");

        given().
            header(new Header("Content-Type", "application/json")).
            accept(ContentType.JSON).
            body(requestPayload.toJSONString()).
        when().
            post(post_endpoint).
        then().
            statusCode(201).
            log().body();

    }

}
