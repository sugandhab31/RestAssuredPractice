package UnitTest.UpdateBooking;
import UnitTest.PostBooking.BookingDates;
import UnitTest.PostBooking.Booking_BuilderMethod;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.Date;

public class UpdateBooking {
    @BeforeClass
    public void setup(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
        RestAssured.basePath = "/booking/{id}";
    }

    @Test
    public void UpdateBookingPutRequest(){
        Faker faker = new Faker();
        BookingDates bookingDates = new BookingDates();

        bookingDates.setCheckIn(new Date(22-5-2024));
        bookingDates.setCheckOut(new Date(25-5-2024));

        Booking_BuilderMethod.BookingBuilder bookingBuilder = new Booking_BuilderMethod.BookingBuilder();
        Booking_BuilderMethod bookingBuilderMethod = bookingBuilder.withFirstName(faker.name().firstName())
                .withLastName(faker.name().lastName())
                .withDepositPaid(true)
                .withTotalPrice(faker.number().numberBetween(1000,2500))
                .withBookingDates(bookingDates)
                .withAdditionalNeeds("Breakfast")
                .build();

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(bookingBuilderMethod);
        Response response = requestSpecification.pathParams(Collections.singletonMap("id","1")).put();

        System.out.println(response.asPrettyString());
    }

}
