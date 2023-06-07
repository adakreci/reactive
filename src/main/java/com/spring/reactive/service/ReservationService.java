package com.spring.reactive.service;

import com.spring.reactive.dto.ReservationDto;
import com.spring.reactive.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.spring.reactive.mapper.ReservationMapper.toReservationDto;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository repository) {
        this.reservationRepository = repository;
    }

    public Flux<ReservationDto> findAll() {
        return reservationRepository.findAll().map(toReservationDto());
    }

    public Mono<ReservationDto> findById( Integer id) {
        return reservationRepository.findById(id).map(toReservationDto());
    }
}
