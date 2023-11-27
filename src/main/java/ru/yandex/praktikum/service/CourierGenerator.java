package ru.yandex.praktikum.service;

import org.apache.commons.lang3.RandomStringUtils;
import ru.yandex.praktikum.model.courier.Courier;
import ru.yandex.praktikum.model.courier.CourierWithoutLogin;
import ru.yandex.praktikum.model.courier.CourierWithoutPassword;
import ru.yandex.praktikum.model.courier.auth.CourierForAuth;
import ru.yandex.praktikum.model.courier.auth.CourierForAuthWithoutLogin;
import ru.yandex.praktikum.model.courier.auth.CourierForAuthWithoutPassword;

public class CourierGenerator {
    private final String password = "password";
    private final String firstName = "name";

    public Courier getCourier() {
        return Courier.builder()
                .login(RandomStringUtils.randomAlphanumeric(10))
                .password(password)
                .firstName(firstName)
                .build();
    }

    public CourierWithoutPassword getCourierWithoutPassword() {
        return new CourierWithoutPassword(RandomStringUtils.randomAlphanumeric(10));
    }

    public Courier getCourierWithPasswordNull() {
        return Courier.builder()
                .login(RandomStringUtils.randomAlphanumeric(10))
                .build();
    }

    public CourierWithoutLogin getCourierWithoutLogin() {
        return new CourierWithoutLogin(password);
    }

    public Courier getCourierWithLoginNull() {
        return Courier.builder()
                .password(password)
                .build();
    }

    public CourierForAuth getCourierForAuth(Courier courier) {
        return CourierForAuth.builder()
                .login(courier.getLogin())
                .password(courier.getPassword())
                .build();
    }

    public CourierForAuthWithoutLogin getCourierForAuthWithoutLogin(Courier courier) {
        return new CourierForAuthWithoutLogin(courier);
    }

    public CourierForAuthWithoutPassword getCourierForAuthWithoutPassword(Courier courier) {
        return new CourierForAuthWithoutPassword(courier);
    }

    public CourierForAuth getCourierForAuthWithLoginNull(Courier courier) {
        return CourierForAuth.builder()
                .password(courier.getPassword())
                .build();
    }

    public CourierForAuth getCourierForAuthWithPasswordNull(Courier courier) {
        return CourierForAuth.builder()
                .login(courier.getLogin())
                .build();
    }
}