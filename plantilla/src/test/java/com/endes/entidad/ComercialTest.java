package com.endes.entidad;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;

class ComercialTest {

        private Comercial comercial;

        @BeforeEach

        void setUp() throws Exception {

                comercial = new Comercial("11111111H", "Ana", "Pruebas", 1000.0, 100.0);

        }

        @Test

        @DisplayName("Debe devolver correctamente el número de ventas")

        void testGetVentas() {

                double ventasEsperada = 2000.0;

                comercial.setVentas(2000.0);

                assertEquals(ventasEsperada, comercial.getVentas(), "No coincide las ventas esperadas");

        }

        @Test

        @DisplayName("Debe permitir establecer un valor válido de ventas")

        void testSetVentasValorValido() {

                String mensajeEsperado = "Las ventas no pueden ser negativas";

                IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> comercial.setVentas(-500.0));

                assertEquals(mensajeEsperado, ex.getMessage());

        }

        @Test

        @DisplayName("Debe calcular correctamente el extra del sueldo basado en ventas")

        void testCalcularExtra() {

                comercial.setVentas(500.0);

                double extraEsperado = 500.0 * 0.10;

                assertEquals(extraEsperado, comercial.calcularExtra(), "El cálculo del extra no es correcto");

        }

        @Test

        @DisplayName("Debe calcular correctamente el sueldo total con ventas = 0")

        void testGetSueldoSinVentas() {

                comercial.setVentas(0.0);

                assertEquals(1000.0, comercial.getSueldo(),

                                "El sueldo debe ser igual al sueldo base cuando las ventas son cero");

        }

        @Test

        @DisplayName("Debe calcular correctamente el sueldo total con ventas positivas")

        void testGetSueldoConVentas() {

                comercial.setVentas(200.0);

                double sueldoEsperado = 1000.0 + (0.10 * 200.0);

                assertEquals(sueldoEsperado, comercial.getSueldo(), "El sueldo total no se calcula correctamente");

        }

}



