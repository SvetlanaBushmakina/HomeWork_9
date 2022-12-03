package testSteps;

import api.RestRequest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import junit.framework.Assert;

public class BookingApiPositiveSteps {
    Response response;
    String token;
    @Given("^Получить токен$")
    public void getToken() {
       String authBody = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        response = RestRequest.auth(authBody);
        token = response.jsonPath().get("token");


    }
    @Then("^Вывести токен в консоль$")
    public void outputTokenToConsole() {
        Assert.assertEquals(200, response.statusCode());
        Assert.assertNotNull(token);
        System.out.println("Токен авторизации: " + token);
    }
}
