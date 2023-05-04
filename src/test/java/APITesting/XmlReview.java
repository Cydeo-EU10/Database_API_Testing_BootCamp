package APITesting;

import io.restassured.http.*;
import io.restassured.path.xml.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;

public class XmlReview extends TestBase{

    @Test
    public void test1(){
        Response response = given().accept(ContentType.XML)
                .when().get("http://3.216.30.92:8000/api/spartans");

        response.prettyPrint();

        XmlPath xmlPath = response.xmlPath();
        System.out.println(xmlPath.get("List.item[0].name").toString());
    }
}
