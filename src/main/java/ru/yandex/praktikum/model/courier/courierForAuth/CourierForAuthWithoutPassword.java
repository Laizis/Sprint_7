package ru.yandex.praktikum.model.courier.courierForAuth;

import lombok.*;
import ru.yandex.praktikum.model.courier.Courier;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class CourierForAuthWithoutPassword {
    private String login;

    public CourierForAuthWithoutPassword(Courier courier) {
        this.login = courier.getLogin();
    }
}