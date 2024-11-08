package org.demo.parcialCamachoTomas.controladores;

import org.demo.parcialCamachoTomas.dto.AdnRequest;
import org.demo.parcialCamachoTomas.dto.AdnResponse;
import org.demo.parcialCamachoTomas.servicios.AdnService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/mutant")
public class AdnControlador {

    private final AdnService adnService;

    public AdnControlador(AdnService adnService) {
        this.adnService = adnService;
    }

    @PostMapping
    public ResponseEntity<AdnResponse> checkMutant(@Valid @RequestBody AdnRequest adnRequest) {
        boolean esMutante = adnService.guardarAdn(adnRequest.getAdn());
        AdnResponse adnResponse = new AdnResponse(esMutante);
        if (esMutante) {
            return ResponseEntity.ok(adnResponse);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(adnResponse);
        }
    }

}
