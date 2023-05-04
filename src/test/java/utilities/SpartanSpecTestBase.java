package utilities;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.specification.*;

public class SpartanSpecTestBase {

    public RequestSpecification reqSpec = RestAssured.given().accept(ContentType.JSON)
            .pathParam("id",107);


    public ResponseSpecification resSpec = reqSpec.expect().statusCode(200);


}
