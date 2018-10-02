package LitaPark.Tests;

import LitaPark.Vaga;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class VagaTest {
    private Vaga vaga1;

    @BeforeEach
    void VagaTest1() {
        this.vaga1 = new Vaga(1,"B");

    }

    @Test
    void getPosicao() {
        assertEquals("1B",vaga1.posicao());
    }

    @Test
    void getPlaca() {
        vaga1.estacionaCarro("MOM-123", LocalTime.now());
        assertEquals("MOM-123", vaga1.getPlacaCarro());
    }

    @Test
    void estacionaCarro() {
        vaga1.estacionaCarro("MOM-123", LocalTime.now());
        assertEquals(LocalTime.now(),vaga1.getHoraEntrada());
        assertEquals("MOM-123",vaga1.getPlacaCarro());
        assertEquals(false,vaga1.getStatus());

    }

    @Test
    void retiraCarro() {
        vaga1.estacionaCarro("MOM-123", LocalTime.now());
        vaga1.retiraCarro();
        assertEquals(null,vaga1.getPlacaCarro());
        assertEquals(null,vaga1.getHoraEntrada());
        assertEquals(true,vaga1.getStatus());
    }

    @Test
    void testEqualsTrue() {
        Vaga vaga2 = new Vaga(1,"B");
        assertEquals(true, vaga1.equals(vaga2));
    }

    @Test
    void testEqualsFalse() {
        Vaga vaga2 = new Vaga(1,"C");
        assertEquals(false,vaga1.equals(vaga2));
    }

    @Test
    void testExecao() {
        Vaga vaga2;
        assertThrows(IllegalArgumentException.class, () -> new Vaga(-1,"C"));
    }

    @Test
    void testHash() {
        Vaga vaga2 = new Vaga(1, "B");
        assertEquals(vaga1.hashCode(),vaga2.hashCode());
    }



}