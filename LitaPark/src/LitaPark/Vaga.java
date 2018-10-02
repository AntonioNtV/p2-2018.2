package LitaPark;

import java.time.LocalTime;
import java.util.Objects;

public class Vaga {
    private int posicao;
    private String setor;
    private LocalTime horaEntrada;
    private String placaCarro;
    private boolean status;

    public Vaga(int posicao, String setor) {
        if (posicao < 0) {
            throw new IllegalArgumentException("");
        }
        this.posicao = posicao;
        this.setor = setor;
        this.horaEntrada = null;
        this.placaCarro = null;
        this.status = true;
    }

    public void estacionaCarro (String placaCarro, LocalTime horaEntrada) {
        this.placaCarro = placaCarro;
        this.status = false;
        this.horaEntrada = horaEntrada;
    }

    public void retiraCarro() {
        this.placaCarro = null;
        this.status = true;
        this.horaEntrada = null;
    }

    public String posicao() {
        return this.posicao + this.setor;
    }

    public LocalTime getHoraEntrada() {
        return this.horaEntrada;
    }

    public String getPlacaCarro()  {
        return this.placaCarro;
    }

    public boolean getStatus() {
        return this.status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vaga vaga = (Vaga) o;
        return posicao == vaga.posicao &&
                Objects.equals(setor, vaga.setor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(posicao, setor);
    }
}
