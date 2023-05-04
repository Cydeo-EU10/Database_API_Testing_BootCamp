package APITesting;

import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.baseURI;

public class TestBase {

    @BeforeAll
    public static void init(){
        //save baseurl inside this variable so that we dont need to type each http method.
        baseURI = "http://3.216.30.92:8000";
    }
}
