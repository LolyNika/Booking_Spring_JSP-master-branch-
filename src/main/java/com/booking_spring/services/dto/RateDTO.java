package com.booking_spring.services.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Setter
@Getter
public class RateDTO {
    private int rateId;
    private int date;
    private String name;
    private int price;
}
