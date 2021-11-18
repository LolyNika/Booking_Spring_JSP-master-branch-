package com.booking_spring.services.dto;

import lombok.*;
/**
 * Class with Rate variables (rateId; date; price; rooms)
 * The class is used for DTO
 * @author LolyNika
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Setter
@Getter
public class RateDTO {
    private int rateId;
    private int date;
    private int price;
}
