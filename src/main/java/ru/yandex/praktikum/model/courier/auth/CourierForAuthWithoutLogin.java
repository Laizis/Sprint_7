package ru.yandex.praktikum.model.courier.auth;

import lombok.*;
import ru.yandex.praktikum.model.courier.Courier;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CourierForAuthWithoutLogin {
    private String password;

    public CourierForAuthWithoutLogin(Courier courier) {
        this.password = courier.getPassword();
    }
}