package testSteps;

import api.RestRequest;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import io.restassured.response.Response;
import junit.framework.Assert;

public class BookingApiPositiveSteps {
    Response response;
    String token;
    Integer bookingId;
    String updateBookingBody;

    @Дано("^Получить токен$")
    public void getToken() {
        String authBody = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        response = RestRequest.auth(authBody);
        token = response.jsonPath().get("token");
        System.out.println("Получили токен: " + token);
    }

    @Тогда("^Вывести токен в консоль$")
    public void outputTokenToConsole() {
        Assert.assertEquals(200, response.statusCode());
        Assert.assertNotNull(token);
        System.out.println("Токен авторизации: " + token);
    }

    @Дано("^Создать бронирование$")
    public void createBooking() {
        String createBookingBody = "{\n" +
                "    \"firstname\" : \"Svetlana\",\n" +
                "    \"lastname\" : \"Bushmakina\",\n" +
                "    \"totalprice\" : 1000,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2022-12-01\",\n" +
                "        \"checkout\" : \"2023-01-01\"\n" +
                "    }\n" +
                "}";
        response = RestRequest.createBooking(createBookingBody);
        bookingId = response.jsonPath().get("bookingid");
        Assert.assertEquals(200, response.statusCode());
        Assert.assertNotNull(bookingId);
        System.out.println("Создали бронирование: " + bookingId);
    }

    @Тогда("^Проверить бронирование$")
    public void getBooking() {
        response = RestRequest.getBooking(bookingId);
        Assert.assertEquals(200, response.statusCode());
        System.out.println("Получили бронирование: " + bookingId);
    }

    @Когда("^Обновить бронирование$")
    public void updateBooking() {
        updateBookingBody = "{\n" +
                "    \"firstname\" : \"Svetlana\",\n" +
                "    \"lastname\" : \"Bushmakina\",\n" +
                "    \"totalprice\" : 1000,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2022-12-01\",\n" +
                "        \"checkout\" : \"2023-01-02\"\n" +
                "    }\n" +
                "}";
        response = RestRequest.updateBooking(updateBookingBody, bookingId, token);
        Assert.assertEquals(200, response.statusCode());
        System.out.println("Обновлено бронирование: " + bookingId);
    }

    @Когда("^Удалить бронирование$")
    public void deleteBooking() {
        response = RestRequest.deleteBooking(bookingId, token);
        Assert.assertEquals(201, response.statusCode());
        System.out.println("Удалено бронирование: " + bookingId);
    }

    @Тогда("^Проверить, что бронирование удалено$")
    public void getBookingAfterDelete() {
        response = RestRequest.getBooking(bookingId);
        Assert.assertEquals(404, response.statusCode());
        Assert.assertNotNull(bookingId);
        System.out.println("Бронирование с ID " + bookingId + " не существует");

    }
}
