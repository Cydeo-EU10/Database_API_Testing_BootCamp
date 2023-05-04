package APITesting;

import APITesting.POJO.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static io.restassured.RestAssured.given;

public class PostMethod extends TestBase{

    @Test
    public void test1(){

        /*
        3 ways provide spartan body
        1. string
        2. map
        3. pojo object
         */


        String spartanString = "{\n" +
                "  \"gender\": \"Male\",\n" +
                "  \"name\": \"Hamcrest\",\n" +
                "  \"phone\": 7896541235\n" +
                "}";

        Map<String,Object> spartanMap = new HashMap<>();
        spartanMap.put("gender","Male");
        spartanMap.put("name","Mike");
        spartanMap.put("phone",7896541235l);


        Spartan spartanObject = new Spartan();
        spartanObject.setGender("Female");
        spartanObject.setName("Harry");
        spartanObject.setPhone(7896541235l);

        Response response = given().accept(ContentType.JSON) // accept response as json format
                .and().contentType(ContentType.JSON) // sending spartan info as json format
                .and().body(spartanObject)
                .when().post("/api/spartans");

        Assertions.assertEquals(201,response.statusCode());
    }
}
