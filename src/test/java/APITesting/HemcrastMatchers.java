package APITesting;

import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class HemcrastMatchers extends TestBase {

    @Test
    public void test1(){
        given().accept(ContentType.JSON)
                .when().get("/api/spartans/4")
                .then().statusCode(200)
                .and().body("name",is("Paige"),
                        "id",equalTo(4),
                        "gender",is(not("Male")));



    }

    @Test
    public void test2(){
        List<String> names = given().accept(ContentType.JSON)
                .when().get("/api/spartans")
                .then().statusCode(200)
                .extract().jsonPath().getList("name");


        assertThat(names,hasSize(greaterThan(10)));

    }
}
