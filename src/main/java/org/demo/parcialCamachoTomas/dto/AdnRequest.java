package org.demo.parcialCamachoTomas.dto;

import lombok.Getter;
import lombok.Setter;
import org.demo.parcialCamachoTomas.validadores.ValidacionAdn;

@Getter
@Setter
public class AdnRequest {

    @ValidacionAdn
    private String[] adn;

}
