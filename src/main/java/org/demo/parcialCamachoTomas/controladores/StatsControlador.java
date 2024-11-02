package org.demo.parcialCamachoTomas.controladores;

import org.demo.parcialCamachoTomas.dto.StatsResponse;
import org.demo.parcialCamachoTomas.servicios.StatsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatsControlador {

    private final StatsService statsService;

    public StatsControlador(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping
    public StatsResponse getStats() {
        return statsService.obtenerStats();
    }
}