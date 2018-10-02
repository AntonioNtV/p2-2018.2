package LitaPark.Tests;

import LitaPark.Sistema;
import Util.Util;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class SistemaTest {
    private Sistema litapark;
    private Sistema litapark2;

    @BeforeEach
    void inicilizacaoSistemas () {
        this.litapark = new Sistema();
        this.litapark2 = new Sistema(2);
    }

    @Test
    void testTamanhoVagasPadrao() {
        assertEquals(50,litapark.getVagas().length);
    }

    @Test
    void testTamanhoVagasPassandoAtributo() {
        assertEquals(2, litapark2.getVagas().length);
    }

    @Test
    void testLucroInicial() {
        assertEquals(0.0,litapark.lucro());
    }

    @Test
    void testLocalizaCarro() {
        litapark.estacionaCarro("MOM-123", LocalTime.now());
        assertEquals("0A",litapark.localizaCarro("MOM-123"));
    }

    @Test
    void testRetiraCarro() {
        litapark.estacionaCarro("MOM-123", LocalTime.of(LocalTime.now().getHour() - 1, LocalTime.now().getMinute() - 1));
        assertEquals(5,litapark.retiraCarro("MOM-123"));
        litapark.estacionaCarro("AAA-123", LocalTime.of(LocalTime.now().getHour() - 2, LocalTime.now().getMinute()));
        assertEquals(5,litapark.retiraCarro("AAA-123"));
        litapark.estacionaCarro("BBB-123", LocalTime.of((LocalTime.now().getHour() - 2), (LocalTime.now().getMinute() - 1)));
        assertEquals(6,litapark.retiraCarro("BBB-123"));
        litapark.estacionaCarro("CCC-123", LocalTime.of((LocalTime.now().getHour() - 4), (LocalTime.now().getMinute() - 1)));
        assertEquals(7,litapark.retiraCarro("CCC-123"));
    }
    @Test
    void testLucro() {
            litapark.estacionaCarro("MOM-123",LocalTime.now());
            litapark.retiraCarro("MOM-123");
            assertEquals(5,litapark.lucro());
    }

    @Test
    void testPainel() {
        String saida = "0A" + Util.pulaLinhas() + "1A" + Util.pulaLinhas();
        assertEquals(saida,litapark2.exibirPainel());
    }

}