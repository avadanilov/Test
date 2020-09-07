package org.testAPI;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SomeTests {
    @BeforeTest
    public static void setup(){
        RestAssured.baseURI = "https://reqres.in/";
    }

    @Test
    public void getTest() {
        given()
                .when()
                .get("api/users?page=2")
                .then()
                .statusCode(200);
    }

    @Test
    public void postTest() {
        Map<String,String> jsonAsMap = new HashMap<String, String>();
        String job = "leader";
        jsonAsMap.put("name","morpheus");
        jsonAsMap.put( "job", job);

        given()
                .contentType(ContentType.JSON)
                .body(jsonAsMap)
                .when()
                .post("api/users")
                .then()
                .body("job", equalTo(job))
                .statusCode(201);
    }

    @Test
    public void putTest() {
        String job = "zion resident";
        Map<String,String> jsonAsMap = new HashMap<String, String>();
        jsonAsMap.put("name","morpheus");
        jsonAsMap.put( "job", job);

        given()
                .contentType(ContentType.JSON)
                .body(jsonAsMap)
                .when()
                .put("api/users/2")
                .then()
                .body("job", equalTo(job))
                .statusCode(200);
    }

    @Test
    public void deleteTest() {

        given()
                .contentType(ContentType.JSON)
                .body("")
                .when()
                .delete("api/users/2")
                .then()
                .statusCode(204);
    }
}