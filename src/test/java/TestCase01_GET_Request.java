import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.when;

public class TestCase01_GET_Request {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @Test
    public void get_request() {
        String get_endpoint = "/api/users?page=2";

        when().
                get(get_endpoint).
        then().
                assertThat().
                statusCode(200).
                body("data[0].id", equalTo(7));
    }

}
