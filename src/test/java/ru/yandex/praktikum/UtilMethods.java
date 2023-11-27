package ru.yandex.praktikum;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import ru.yandex.praktikum.client.courier.CourierClient;
import ru.yandex.praktikum.client.order.OrderClient;
import ru.yandex.praktikum.model.courier.Courier;
import ru.yandex.praktikum.model.courier.auth.CourierForAuth;
import ru.yandex.praktikum.service.CourierGenerator;

import static org.hamcrest.CoreMatchers.equalTo;

@Slf4j
public class UtilMethods {
    public static final String FIELD_ID = "id";
    private static final String FIELD_OK = "ok";
    private static final String RESPONSE = "Получен ответ от сервера: {}";
    private final CourierClient courierClient = new CourierClient();
    private final OrderClient orderClient = new OrderClient();
    private final CourierGenerator generator = new CourierGenerator();

    public Integer getCourierId(ru.yandex.praktikum.model.courier.Courier courier) {
        CourierForAuth courierForAuth = generator.getCourierForAuth(courier);
        log.info("Авторизация курьера \"{}\" с паролем \"{}\" на сервере",
                courierForAuth.getLogin(), courierForAuth.getPassword());

        Response response = courierClient.login(courierForAuth);
        log.info(RESPONSE, response.body().asString());
        Integer courierId = response.body().path(FIELD_ID);
        log.info("Курьер с id = {} авторизован", courierId);
        return courierId;
    }

    public void deleteCourier(Courier courier) {
        int courierId = getCourierId(courier);
        log.info("Удаление созданного ранее курьера по id = {}", courierId);
        Response response = courierClient.deleteCourier(courierId);
        log.info(RESPONSE, response.body().asString());

        response.then().assertThat().body(FIELD_OK, equalTo(true))
                .and().statusCode(HttpStatus.SC_OK);
        log.info("Удаление курьера с id = {} произошло корректно\n", courierId);
    }

    public void cancelOrder(Integer id) {
        Response response = orderClient.cancelOrder(id);

        response.then().assertThat().body(FIELD_OK, equalTo(true))
                .and().statusCode(HttpStatus.SC_OK);
        log.info("Заказ {} завершен\n", id);
    }
}