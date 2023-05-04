package utilities;

import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;

public abstract class SpartanTestBase {

    @BeforeAll
    public static void init(){
        //save baseurl inside this variable so that we dont need to type each http method.
        baseURI = "http://3.87.65.105:8000";

        String dbUrl = "jdbc:oracle:thin:@3.87.65.105:1521:xe";
        String dbUsername = "SP";
        String dbPassword = "SP";

        //DBUtils.createConnection(dbUrl,dbUsername,dbPassword);
    }

    @AfterAll
    public static void teardown(){

        //DBUtils.destroy();
    }



}
