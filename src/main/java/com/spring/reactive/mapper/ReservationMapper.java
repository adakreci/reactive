package com.spring.reactive.mapper;

import com.spring.reactive.dto.ReservationDto;
import com.spring.reactive.entity.Reservation;

import java.util.function.Function;

public class ReservationMapper {

    private ReservationMapper() {
    }

    public static Function<Reservation, ReservationDto> toReservationDto() {
        return reservation -> new ReservationDto(reservation.getId(), reservation.getName());
    }

}
