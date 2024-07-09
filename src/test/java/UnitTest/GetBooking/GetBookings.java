package UnitTest.GetBooking;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;

public class GetBookings {

    @BeforeClass
    public void setup(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
    }

    @Test
    public void GetAllBookings(){
        RestAssured.basePath = "booking";

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        Response response = requestSpecification.get();

        System.out.println(response.asPrettyString());

        Assert.assertNotNull(response.then());
    }

    @Test
    public void GetBookingByID(){
        RestAssured.basePath = "booking/{id}";

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        Response response = requestSpecification.pathParams(Collections.singletonMap("id", "1")).get();

        System.out.println(response.asPrettyString());

        Assert.assertNotNull(response.then());
    }
}
