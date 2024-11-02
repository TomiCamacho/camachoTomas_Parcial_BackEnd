package org.demo.parcialCamachoTomas.servicios;

import org.demo.parcialCamachoTomas.dto.StatsResponse;
import org.demo.parcialCamachoTomas.repositorios.AdnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsService {

    private final AdnRepository adnRepository;

    @Autowired
    public StatsService(AdnRepository adnRepository) {
        this.adnRepository = adnRepository;
    }

    public StatsResponse obtenerStats() {

        long contadorMutante = adnRepository.countByIsMutant(true);
        long contadorHumano = adnRepository.countByIsMutant(false);

        double ratio = contadorHumano == 0 ? 0 : (double) contadorHumano / contadorMutante;

        return new StatsResponse(contadorMutante, contadorHumano, ratio);

    }
}