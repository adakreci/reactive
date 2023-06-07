package com.spring.reactive.repository;

import com.spring.reactive.entity.Reservation;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends ReactiveCrudRepository<Reservation, Integer> {

}
