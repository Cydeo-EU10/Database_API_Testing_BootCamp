package APITesting;

import io.restassured.http.*;
import io.restassured.module.jsv.*;
import org.junit.jupiter.api.*;
import utilities.*;

import java.io.*;

import static io.restassured.RestAssured.*;

public class SchemaValidation extends TestBase {

    //if schema file is in resources, use class path method
    // if it's in other place, use match json schema and new file

    @DisplayName("Single spartan schema validation")
    @Test
    public void test1(){
        given().accept(ContentType.JSON)
                .when().get("/api/spartans/2")
                .then()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\Zulpikar\\IdeaProjects\\Eu9_API_Preparation\\src\\test\\java\\week4\\allSpartanSchema.json")));

    }

    @DisplayName("All spartan schema validation")
    @Test
    public void test2(){
        given().accept(ContentType.JSON)
                .when().get("/api/spartans")
                .then()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("allSpartanSchema.json"));

    }

    @DisplayName("post spartan schema validation")
    @Test
    public void test3(){

        String newSpartan = "{\n" +
                "  \"gender\": \"Male\",\n" +
                "  \"name\": \"Jack\",\n" +
                "  \"phone\": 5269852147\n" +
                "}";
        given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .body(newSpartan)
                .when()
                .post("/api/spartans")
                .then().statusCode(201)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("postSpartanSchema.json"));

    }
}
