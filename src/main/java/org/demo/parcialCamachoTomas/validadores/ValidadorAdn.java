package org.demo.parcialCamachoTomas.validadores;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidadorAdn implements ConstraintValidator<ValidacionAdn, String[]> {

//    private static final String CARACTERES = "AGTC";
//
//    @Override
//    public void initialize(ValidacionAdn constraintAnnotation) {
//    }
//
//    @Override
//    public boolean isValid(String[] adn, ConstraintValidatorContext context) {
//        if (adn == null) {
//            return false;
//        }
//
//        int n = adn.length;
//        if (n == 0) {
//            return false;
//        }
//
//        for (String secuencia : adn) {
//            if (secuencia == null || secuencia.length() != n) {
//                return false;
//            }
//            for (char c : secuencia.toCharArray()) {
//                if (CARACTERES.indexOf(c) == -1) {
//                    return false;
//                }
//            }
//        }
//
//        return true;
//    }
//}

    private static final String BASES = "ATCG";

    @Override
    public void initialize(ValidacionAdn constraintAnnotation) {
    }

    @Override
    public boolean isValid(String[] secuencias, ConstraintValidatorContext context) {
        if (secuencias == null) {
            return false;
        }

        int longitud = secuencias.length;
        if (longitud == 0) {
            return false;
        }

        return verificarSecuencias(secuencias, longitud);
    }

    private boolean verificarSecuencias(String[] secuencias, int longitud) {
        for (String secuencia : secuencias) {
            if (secuencia == null || secuencia.length() != longitud) {
                return false;
            }
            if (!contieneCaracteresValidos(secuencia)) {
                return false;
            }
        }
        return true;
    }

    private boolean contieneCaracteresValidos(String secuencia) {
        for (char base : secuencia.toCharArray()) {
            if (BASES.indexOf(base) == -1) {
                return false;
            }
        }
        return true;
    }
}
