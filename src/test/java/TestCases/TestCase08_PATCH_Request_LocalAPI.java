package TestCases;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestCase08_PATCH_Request_LocalAPI {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost:3000";
    }

    @Test
    public void patch_request() {
        String patch_endpoint = "/users/1";

        JSONObject requestPayload = new JSONObject();
        requestPayload.put("last_name", "Rock");

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(requestPayload.toJSONString()).
        when().
                patch(patch_endpoint).
        then().
                assertThat().
                statusCode(200).
                log().body();
    }

}
