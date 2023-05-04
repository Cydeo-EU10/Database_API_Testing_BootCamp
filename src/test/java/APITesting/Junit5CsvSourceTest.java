package APITesting;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import utilities.*;

public class Junit5CsvSourceTest extends SpartanTestBase {


    @ParameterizedTest
    @CsvSource({"1,2,1",
            "3,4,81",
            "2,4,16"})
    public void sum(double a, double b, double result) {

        Assertions.assertEquals(Math.pow(a,b), result);
    }

    @ParameterizedTest
    @CsvSource({"20,Lothario",
            "21, Mark",
            "22, Koenraad"})
    public void nameId(String id, String name){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .pathParam("id",id)
                .when().get("/api/spartans/{id}");

        Assertions.assertEquals(name, response.path("name"));
    }
}
