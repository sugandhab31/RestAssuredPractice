package UnitTest.Auth;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class PostAuth {

    @BeforeClass
    public void setup(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
        RestAssured.basePath = "auth";
    }

    @Test
    public void GetAuthToken_Method_1(){
        Auth_GetterSetter auth = new Auth_GetterSetter();
        auth.setUsername("admin");
        auth.setPassword("password123");

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(auth);

        Response response = requestSpecification.post();
        System.out.println(response.asPrettyString());
        Assert.assertNotNull(response.then().extract().path("token"));

    }
    
    @Test
    public void GetAuthToken_Method_2(){
        Auth_BuilderMethod.AuthBuilder authBuilder = new Auth_BuilderMethod.AuthBuilder();
        Auth_BuilderMethod auth = authBuilder.withUsername("admin").withPassword("password123").build();

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(auth);

        Response response = requestSpecification.post();
        System.out.println(response.asPrettyString());
        Assert.assertNotNull(response.then().extract().path("token"));
    }

    @Test
    public void GetAuthToken_Method_3(){
        //Map<String, Object> payload = new HashMap<>(); ---- will give random order
        Map<String,Object> payload = new LinkedHashMap<>();
        payload.put("username","admin");
        payload.put("password","password123");

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);

        Response response = requestSpecification.post();
        System.out.println(response.asPrettyString());
        Assert.assertNotNull(response.then().extract().path("token"));
    }
}
