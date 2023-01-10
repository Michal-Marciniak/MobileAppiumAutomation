package TestCases;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestCase03_PUT_Request {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @Test
    public void put_request() {
        String put_endpoint = "/api/users/2";

        JSONObject requestPayload = new JSONObject();
        requestPayload.put("name", "Michal");
        requestPayload.put("job", "Test Automation Engineer");

        given().
            header(new Header("Content-Type", "application/json")).
            accept(ContentType.JSON).
            body(requestPayload.toJSONString()).
        when().
            put(put_endpoint).
        then().
            statusCode(200).
            log().body();

    }

}
