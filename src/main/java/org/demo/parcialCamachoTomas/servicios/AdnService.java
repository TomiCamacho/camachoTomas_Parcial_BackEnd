package org.demo.parcialCamachoTomas.servicios;

import org.demo.parcialCamachoTomas.entidades.Adn;
import org.demo.parcialCamachoTomas.repositorios.AdnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AdnService {

    private final AdnRepository adnRepository;
    private static final int LONGITUD = 4;

    @Autowired
    public AdnService(AdnRepository adnRepository) {
        this.adnRepository = adnRepository;
    }

    public boolean guardarAdn(String[] adn) {
        String secuenciaADN = String.join(",", adn);
        Optional<Adn> existingDna = adnRepository.findByAdn(secuenciaADN);
        if (existingDna.isPresent()) {
            return existingDna.get().isMutant();
        }
        boolean comprobarMutante = comprobarMutante(adn);
        Adn nuevoAdn = Adn.builder()
                .adn(secuenciaADN)
                .isMutant(comprobarMutante)
                .build();
        adnRepository.save(nuevoAdn);
        return comprobarMutante(adn);
    }

//    public static boolean isMutant(String[] dna) {
//
//        int n = dna.length;
//        int contador = 0;
//
//        contador = contador + revisarFilas(dna, n);
//        if (contador > 1) return true;
//
//        contador = contador + revisarColumnas(dna, n);
//        if (contador > 1) return true;
//
//        contador = contador + revisarDiagonales(dna, n);
//        return contador > 1;
//
//    }

    public static boolean comprobarMutante(String[] adn) {
        int longitud = adn.length;
        int contador = contarSecuencias(adn, longitud);
        return contador > 1;
    }

    private static int contarSecuencias(String[] adn, int longitud) {
        int totalSecuencias = 0;
//        totalSecuencias += contarFilas(adn, n);
//        if (totalSecuencias > 1) return totalSecuencias;
//        totalSecuencias += contarColumnas(adn, n);
//        if (totalSecuencias > 1) return totalSecuencias;
//        totalSecuencias += contarDiagonales(adn, n);
//        return totalSecuencias;

        totalSecuencias = totalSecuencias + contarFilas(adn,longitud) + contarColumnas(adn,longitud) + contarDiagonales(adn, longitud);
        if (totalSecuencias > 1) return totalSecuencias;
        return totalSecuencias;
    }

//    private static int revisarFilas(String[] adn, int n) {
//        int secuencias = 0;
//
//        for (int i = 0; i < n; i++) {
//            int cuenta = 1;
//            for (int j = 1; j < n; j++) {
//                if (adn[i].charAt(j) == adn[i].charAt(j - 1)) {
//                    cuenta++;
//                    if (cuenta == LONGITUD) {
//                        secuencias++;
//                        if (secuencias > 1) return secuencias;
//                    }
//                } else {
//                    cuenta = 1;
//                }
//            }
//        }
//        return secuencias;
//    }

//    private static int contarFilas(String[] adn, int longitud) {
//        int secuencias = 0;
//        for (int columna = 0; columna < longitud; columna++) {
//            char letraActual = adn[columna].charAt(0);
//            int cuenta = 1;
//            for (int fila = 1; fila < longitud; fila++) {
//                if (adn[columna].charAt(fila) == letraActual) {
//                    cuenta++;
//                    if (cuenta == LONGITUD) {
//                        secuencias++;
//                        if (secuencias > 1) return secuencias;
//                    }
//                } else {
//                    letraActual = adn[columna].charAt(fila);
//                    cuenta = 1;
//                }
//            }
//        }
//        return secuencias;
//    }


    private static int contarFilas(String[] adn, int longitud) {
        int secuencias = 0;
        for (int fila = 0; fila < longitud; fila++) {
            char letraActual = adn[fila].charAt(0);
            int cuenta = 1;
            for (int columna = 1; columna < longitud; columna++) {
                cuenta = (adn[fila].charAt(columna) == letraActual) ? cuenta + 1 : 1;
                letraActual = (adn[fila].charAt(columna) == letraActual) ? letraActual : adn[fila].charAt(columna);
                if (cuenta == LONGITUD) {
                    secuencias++;
                    if (secuencias > 1) return secuencias;
                }
            }
        }
        return secuencias;
    }


//    private static int revisarColumnas(String[] adn, int n) {
//        int secuencias = 0;
//
//        for (int j = 0; j < n; j++) {
//            int cuenta = 1;
//            for (int i = 1; i < n; i++) {
//                if (adn[i].charAt(j) == adn[i - 1].charAt(j)) {
//                    cuenta++;
//                    if (cuenta == LONGITUD) {
//                        secuencias++;
//                        if (secuencias > 1) return secuencias;
//                    }
//                } else {
//                    cuenta = 1;
//                }
//            }
//        }
//        return secuencias;
//    }

//    private static int contarColumnas(String[] adn, int n) {
//        int secuencias = 0;
//        for (int j = 0; j < n; j++) {
//            char baseActual = adn[0].charAt(j);
//            int cuenta = 1;
//            for (int i = 1; i < n; i++) {
//                if (adn[i].charAt(j) == baseActual) {
//                    cuenta++;
//                    if (cuenta == LONGITUD) {
//                        secuencias++;
//                        if (secuencias > 1) return secuencias;
//                    }
//                } else {
//                    baseActual = adn[i].charAt(j);
//                    cuenta = 1;
//                }
//            }
//        }
//        return secuencias;
//    }

    private static int contarColumnas(String[] adn, int n) {
        int secuencias = 0;
        for (int columna = 0; columna < n; columna++) {
            char baseActual = adn[0].charAt(columna);
            int cuenta = 1;
            for (int fila = 1; fila < n; fila++) {
                cuenta = (adn[fila].charAt(columna) == baseActual) ? cuenta + 1 : 1;
                baseActual = (adn[fila].charAt(columna) == baseActual) ? baseActual : adn[fila].charAt(columna);
                if (cuenta == LONGITUD) {
                    secuencias++;
                    if (secuencias > 1) return secuencias;
                }
            }
        }
        return secuencias;
    }


//    private static int revisarDiagonales(String[] adn, int n) {
//        int secuencias = 0;
//
//        for (int i = 0; i <= n - LONGITUD; i++) {
//            for (int j = 0; j <= n - LONGITUD; j++) {
//                if (revisarDiagonal(adn, i, j, 1, 1, n)) {
//                    secuencias++;
//                    if (secuencias > 1) return secuencias;
//                }
//            }
//        }
//
//        for (int i = 0; i <= n - LONGITUD; i++) {
//            for (int j = LONGITUD - 1; j < n; j++) {
//                if (revisarDiagonal(adn, i, j, 1, -1, n)) {
//                    secuencias++;
//                    if (secuencias > 1) return secuencias;
//                }
//            }
//        }
//        return secuencias;
//    }
//
//    private static boolean revisarDiagonal(String[] adn, int x, int y, int dx, int dy, int n) {
//        char primero = adn[x].charAt(y);
//        for (int i = 1; i < LONGITUD; i++) {
//            if (x + i * dx >= n || y + i * dy >= n || y + i * dy < 0 || adn[x + i * dx].charAt(y + i * dy) != primero) {
//                return false;
//            }
//        }
//        return true;
//    }

//    private static int contarDiagonales(String[] adn, int n) {
//        int secuencias = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (esDiagonalValida(adn, n, i, j, 1, 1)) {
//                    secuencias++;
//                    if (secuencias > 1) return secuencias;
//                }
//                if (esDiagonalValida(adn, n, i, j, 1, -1)) {
//                    secuencias++;
//                    if (secuencias > 1) return secuencias;
//                }
//            }
//        }
//        return secuencias;
//    }
//
//    private static boolean esDiagonalValida(String[] adn, int n, int fila, int col, int incFila, int incCol) {
//        int cuenta = 1;
//        char letraInicial = adn[fila].charAt(col);
//        int i = fila + incFila;
//        int j = col + incCol;
//
//        while (i < n && j >= 0 && j < n) {
//            if (adn[i].charAt(j) == letraInicial) {
//                cuenta++;
//                if (cuenta == LONGITUD) {
//                    return true;
//                }
//            } else {
//                break;
//            }
//            i += incFila;
//            j += incCol;
//        }
//        return false;
//    }

    private static int contarDiagonales(String[] adn, int longitud) {
        int secuencias = 0;
        for (int fila = 0; fila < longitud; fila++) {
            for (int columna = 0; columna < longitud; columna++) {
                secuencias += esDiagonalValida(adn, longitud, fila, columna, 1, 1) ? 1 : 0;
                if (secuencias > 1) return secuencias;
                secuencias += esDiagonalValida(adn, longitud, fila, columna, 1, -1) ? 1 : 0;
                if (secuencias > 1) return secuencias;
            }
        }
        return secuencias;
    }

    private static boolean esDiagonalValida(String[] adn, int longitud, int fila, int col, int incFila, int incCol) {
        int cuenta = 1;
        char letraInicial = adn[fila].charAt(col);
        int dfila = fila + incFila;
        int dcol = col + incCol;

        while (dfila < longitud && dcol >= 0 && dcol < longitud) {
            if (adn[dfila].charAt(dcol) == letraInicial) {
                cuenta++;
                if (cuenta == LONGITUD) {
                    return true;
                }
            } else {
                break;
            }
            dfila += incFila;
            dcol += incCol;
        }
        return false;
    }



}
