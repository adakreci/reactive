package com.spring.reactive.controller.web;

import com.spring.reactive.controller.ReservationController;
import com.spring.reactive.dto.ReservationDto;
import com.spring.reactive.service.ReservationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import static org.hamcrest.Matchers.is;

import static org.mockito.BDDMockito.given;

@WebFluxTest( ReservationController.class)
class ReservationControllerTests {

    @MockBean
    private ReservationService reservationService;

    @Autowired
    private WebTestClient webClient;

    private final ReservationDto reservationDto = new ReservationDto(1, "Maria");

    @Test
    void upAndRunning() {
        given(this.reservationService.findById(1)).willReturn(Mono.just(reservationDto));

        this.webClient.get().uri("/reservations/1")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id")
                .value(is(reservationDto.id()))
                .jsonPath("$.name")
                .value(is(reservationDto.name()));
    }
}
