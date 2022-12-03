package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestRequest {
    public static final String baseUri = "https://restful-booker.herokuapp.com";

    public static Response auth(String body) {

        return RestAssured.given()
                .baseUri(baseUri)
                .basePath("/auth")
                .body(body)
                .log()
                .body()
                .contentType(ContentType.JSON)
                .post()
                .then()
                .log()
                .body()
                .extract()
                .response();
    }

    public static Response createBooking(String body) {

        return RestAssured.given()
                .baseUri(baseUri)
                .basePath("/booking")
                .body(body)
                .log()
                .body()
                .contentType(ContentType.JSON)
                .post()
                .then()
                .log()
                .body()
                .extract()
                .response();
    }

    public static Response createBookingNegative (String body) {

         return RestAssured.given()
                .baseUri(baseUri)
                .basePath("/booking")
                .body(body)
                .log()
                .body()
                .contentType(ContentType.JSON)
                .post()
                .then()
                .log()
                .body()
                .extract()
                .response();
    }

    public static Response getBooking(Integer bookingId) {

        return RestAssured.given()
                .baseUri(baseUri)
                .basePath("/booking/" + bookingId)
                .contentType(ContentType.JSON)
                .get()
                .then()
                .log()
                .body()
                .extract()
                .response();
    }

    public static Response updateBooking(String body, Integer bookingId, String token) {
        return RestAssured.given()
                .baseUri(baseUri)
                .basePath("/booking/" + bookingId)
                .body(body)
                .log()
                .body()
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + token)
                .put()
                .then()
                .log()
                .body()
                .extract()
                .response();
    }

    public static Response deleteBooking(Integer bookingId, String token) {

        return RestAssured.given()
                .baseUri(baseUri)
                .basePath("/booking/" + bookingId)
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + token)
                .delete()
                .then()
                .log()
                .body()
                .extract()
                .response();
    }
}

