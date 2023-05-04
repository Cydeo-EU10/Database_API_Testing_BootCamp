package APITesting;

import APITesting.POJO.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static io.restassured.RestAssured.given;

public class Deserilization extends TestBase {

    /*
    map
    list
    or custom class objects
     */

    @Test
    public void test1() {

        // map
        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans/4");

        Map<String, Object> responseMap = response.as(Map.class);
        System.out.println(responseMap);
        System.out.println(responseMap.get("name"));
    }

    @Test
    public void test2() {
        // list
        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans");

        List<Map<String, Object>> responseList = response.as(List.class);

        for (Map<String, Object> map : responseList) {
            System.out.println(map);

        }



    }

    @Test
    public void test3(){
        // custom class object

        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans/7");

        Spartan spartan = response.as(Spartan.class);
        System.out.println(spartan);
    }

    @Test
    public void test4(){
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("gender","Female")
                .when().get("/api/spartans/search");

        System.out.println(response.statusCode());

        Search spartanFemale = response.as(Search.class);
        System.out.println(spartanFemale);
    }


}
