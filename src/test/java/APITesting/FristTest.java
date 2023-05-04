package APITesting;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.path.json.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;

public class FristTest {

    @Test
    public void test1(){
        Response response = given().accept(ContentType.JSON)
                .when().get("http://3.216.30.92:8000/api/spartans/4");

        response.prettyPrint();


        // check for status code and headers
        Assertions.assertEquals(200,response.statusCode());
        Assertions.assertEquals("application/json",response.header("Content-Type").toString());

        // 1st way to get value from body
        String gender = response.path("gender").toString();

        // 2nd way  --> creat jsonpath object
        JsonPath jsonPath = response.jsonPath();
        String name = jsonPath.getString("name");

    }

    @Test
    public void test2(){
        Response response = given().accept(ContentType.JSON)
                .when().get("http://3.216.30.92:8000/api/spartans");

        JsonPath jsonPath = response.jsonPath();
        int id = jsonPath.getInt("[0].id");

        String name = jsonPath.getString("[1].name");
        System.out.println(name);

        Assertions.assertEquals("Rodolfo",jsonPath.getString("[2].name"));

    }
}
