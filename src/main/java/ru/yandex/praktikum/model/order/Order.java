package ru.yandex.praktikum.model.courier.order;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = "deliveryDate")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String firstName;
    private String lastName;
    private String address;
    private String metroStation;
    private String phone;
    private Integer rentTime;
    private String deliveryDate;
    private String comment;
    private String[] color;
}