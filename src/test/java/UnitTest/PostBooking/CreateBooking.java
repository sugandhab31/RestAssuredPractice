package UnitTest.PostBooking;

import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class CreateBooking {

    @BeforeClass
    public void setup(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
        RestAssured.basePath = "booking";
    }

    @Test
    public void CreateNewBooking(){
        Faker faker = new Faker();

        Booking booking = new Booking();
        BookingDates bookingDates = new BookingDates();
        booking.setFirstName(faker.name().firstName());
        booking.setLastName(faker.name().lastName());
        booking.setTotalPrice(faker.number().numberBetween(1000,2500));
        booking.setDepositPaid(faker.bool().bool());
        bookingDates.setCheckIn(new Date(22-5-2024));
        bookingDates.setCheckOut(new Date(25-5-2024));
        booking.setBookingDates(bookingDates);
        booking.setAdditionalNeeds("Breakfast");

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(booking);
        Response response = requestSpecification.post();

        System.out.println(response.asPrettyString());
        int bookingId = response.then().extract().path("bookingid");
        System.out.println(bookingId);
        Assert.assertNotNull(response.then().extract().path("bookingid"));
    }

    @Test
    public void CreateNewBooking2(){
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
        Response response = requestSpecification.post();

        System.out.println(response.asPrettyString());
        int bookingId = response.then().extract().path("bookingid");
        System.out.println(bookingId);
        Assert.assertNotNull(response.then().extract().path("bookingid"));

    }

    @Test
    public void CreateNewBooking3(){
        Faker faker = new Faker();
        //BookingDates bookingDates = new BookingDates();

        //bookingDates.setCheckIn(new Date(22-5-2024));
        //bookingDates.setCheckOut(new Date(25-5-2024));

        Map<String,Object> bookingDates = new LinkedHashMap<>();
        bookingDates.put("checkin",new Date(22-5-2024));
        bookingDates.put("checkout",new Date(25-5-2024));

        Map<String,Object> payload = new LinkedHashMap<>();
        payload.put("firstname",faker.name().firstName());
        payload.put("lastname",faker.name().lastName());
        payload.put("totalprice",faker.number().numberBetween(1000,2500));
        payload.put("depositpaid",true);
        payload.put("bookingdates",bookingDates);
        payload.put("additionalneeds","Breakfast");

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);
        Response response = requestSpecification.post();

        System.out.println(response.asPrettyString());
        int bookingId = response.then().extract().path("bookingid");
        System.out.println(bookingId);
        Assert.assertNotNull(response.then().extract().path("bookingid"));

    }

}
