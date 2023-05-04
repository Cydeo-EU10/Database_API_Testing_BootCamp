package APITesting;

import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static io.restassured.RestAssured.given;

public class Deserilization extends TestBase{

    /*
    map
    list
    or custom class objects
     */

    @Test
    public void test1(){

        // map
        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans/4");

        Map<String, Object> responseMap = response.as(Map.class);
        System.out.println(responseMap);
        System.out.println(responseMap.get("name"));
    }

    @Test
    public void test2(){
        // list
    }
}
