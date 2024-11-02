package org.demo.parcialCamachoTomas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class StatsResponse {

    @JsonProperty("contador_humano")
    private long contadorHumano;

    @JsonProperty("contador_mutante")
    private long contadorMutante;

    private double ratio;

}
