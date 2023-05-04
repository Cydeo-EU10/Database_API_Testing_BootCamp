package APITesting;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import utilities.*;

import java.util.*;

public class Junit5CSVFileSourceTest extends SpartanTestBase {

    @ParameterizedTest
    @CsvFileSource(resources = "/SpartanDataPOST.csv",numLinesToSkip = 1)
    public void addSpartanTest(String name, String gender, Long phone){

        Map<String,Object> spartanMap = new HashMap<>();
        spartanMap.put("name", name);
        spartanMap.put("gender", gender);
        spartanMap.put("phone", phone);

        Response response = RestAssured.given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(spartanMap)
                .when().post("/api/spartans")
                .then().statusCode(201)
                .extract().response();

        Assertions.assertEquals("A Spartan is Born!",response.path("success"));


    }

}
