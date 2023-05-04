package APITesting;

import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;

public class Authentication extends TestBase{


    @Test
    public void test1(){
        Response response = given().accept(ContentType.JSON)
                .and().auth().basic("admin","admin")
                .when().get("http://3.216.30.92:7000/api/spartans");
    }
}
