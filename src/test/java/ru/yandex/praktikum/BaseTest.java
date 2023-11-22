package ru.yandex.praktikum;

import org.junit.After;
import ru.yandex.praktikum.model.courier.Courier;

public class BaseTest {
    protected Courier courier;
    private final UtilMethods util = new UtilMethods();

    @After
    public void deleteCourier() {
        if (courier != null) {
            util.deleteCourier(courier);
        }
    }
}