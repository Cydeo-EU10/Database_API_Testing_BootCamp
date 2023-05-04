package APITesting;

import io.restassured.http.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import utilities.*;

import static io.restassured.RestAssured.*;

public class Junit5ValueSourceTest extends TestBase {

    // value source
    // with number
    @ParameterizedTest
    @ValueSource(ints = {10,20,30,40,50}) // we have to use ints, not num or else
    public void test1( int num){
        System.out.println("num = " + num);
    }

    // with string
    @ParameterizedTest
    @ValueSource(strings = {"paris","london","lizbon"}) //
    public void test2( String cityName){
        System.out.println("cityName = " + cityName);
    }

    //spartan test
    @ParameterizedTest
    @ValueSource(ints ={1,2,3,4,5,6,7,8})
    public void test3(int id){
        System.out.println(given().accept(ContentType.JSON)
                .and()
                .pathParam("id", id)
                .when().get("/api/spartans/{id}")
                .then()
                .statusCode(200)
                .extract().response().path("name").toString());
    }
}
