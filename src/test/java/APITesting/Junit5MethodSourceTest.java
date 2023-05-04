package APITesting;

import io.restassured.http.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import utilities.*;

import java.util.*;

import static io.restassured.RestAssured.*;

public class Junit5MethodSourceTest extends SpartanTestBase {

    @ParameterizedTest
    @MethodSource("getNames")
    public void carBarands(String brands){
        System.out.println("My car is " + brands);
    }

    public static List<String> getNames(){
        List<String> names = Arrays.asList("Honda", "Toyota", "Ford", "Tesla");

        return names;
    }


    public static List<Integer> randomNums(){
        Random random = new Random();
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            nums.add(random.nextInt(100));
        }
        return nums;
    }

    @ParameterizedTest
    @MethodSource("randomNums")
    public void test1(int id){
        given().accept(ContentType.JSON)
                .pathParam("id", id)
                .when().get("api/spartans/{id}")
                .then()
                .statusCode(200);
    }


}
