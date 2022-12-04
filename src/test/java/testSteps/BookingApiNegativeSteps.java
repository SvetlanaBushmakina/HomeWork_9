package testSteps;

import api.RestRequest;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Тогда;
import io.restassured.response.Response;
import org.junit.Assert;

public class BookingApiNegativeSteps {
    Response response;
    String token;
    Integer bookingId = 1;

    @Дано("^Ввести неверные логин и пароль$")
    public void getToken() {
        String authBody = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"qwerty123\"\n" +
                "}";
        response = RestRequest.auth(authBody);
        token = response.jsonPath().get("token");
    }

    @Тогда("^Получить сообщение об ошибке$")
    public void getErrorMessageAuth() {
        String reason = response.jsonPath().get("reason");
        Assert.assertEquals(200, response.statusCode());
        Assert.assertNotNull(reason);
        System.out.println("Не удалось авторизоваться по причине: " + reason);
    }

    @Дано("^Создать бронирование с неверным телом$")
    public void createBookingInvalidBody() {
        String createBookingBody = "{\n" +
                "    \"name\" : \"Svetlana\",\n" +
                "    \"lastname\" : \"Bushmakina\",\n" +
                "    \"totalprice\" : 1000,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2022-12-01\",\n" +
                "        \"checkout\" : \"2023-01-01\"\n" +
                "    }\n" +
                "}";
        response = RestRequest.createBooking(createBookingBody);
    }

    @Тогда("^Получить сообщение о некорректном запросе$")
    public void getErrorMessageCreate() {
        Assert.assertEquals(500, response.statusCode());
        System.out.println("Некорректный запрос");
    }

    @Дано("^Проверить бронирование с несуществющим ID$")
    public void getBooking() {
        response = RestRequest.getBooking(bookingId);
        Assert.assertEquals(404, response.statusCode());
        System.out.println("Бронирование с ID: " + bookingId + " не найдено");
    }

    @Дано("^Удалить бронирование с несуществующим ID$")
    public void deleteBooking() {
        String authBody = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        response = RestRequest.auth(authBody);
        token = response.jsonPath().get("token");
        response = RestRequest.deleteBooking(bookingId, token);
        Assert.assertEquals(405, response.statusCode());
        System.out.println("Невозможно удалить бронирование с ID: " + bookingId);
    }
}
