package LitaPark;

import Util.Util;

import java.time.LocalTime;

public class Sistema {
    private Vaga vagas[];
    private double caixa;

    public Sistema() {
        this.vagas = new Vaga[50];
        this.caixa = 0.0;

        for (int i = 0; i < this.vagas.length; i++) {
            if (this.vagas[i] == null) {
                this.vagas[i] = new Vaga(i,"A");
            }
        }
    }

    public Sistema(int qtdVagas) {
        this.vagas = new Vaga[qtdVagas];
        this.caixa = 0.0;

        for (int i = 0; i < this.vagas.length; i++) {
            if (this.vagas[i] == null) {
                this.vagas[i] = new Vaga(i,"A");
            }
        }
    }

    public void estacionaCarro(String placaCarro, LocalTime horaEntrada) {
        for (Vaga vaga : this.vagas) {
            if (vaga.getStatus()) {
                vaga.estacionaCarro(placaCarro, horaEntrada);
                break;
            }
        }
    }

    public double retiraCarro(String placaCarro) {
        double totalPagar = 0.0;

        for (Vaga vaga : this.vagas) {
            if (!vaga.getStatus() && vaga.getPlacaCarro().equals(placaCarro)) {
                LocalTime horaEntrada = vaga.getHoraEntrada();
                LocalTime horaSaida = LocalTime.now();
                int diferencaHoras = horaSaida.getHour() - horaEntrada.getHour();
                int diferencaMinutos = horaSaida.getMinute() - horaEntrada.getMinute();
                vaga.retiraCarro();
                System.out.println(diferencaHoras);
                System.out.println(diferencaMinutos);

                if (diferencaHoras < 2) {
                    totalPagar += 5.00;
                } else if (diferencaHoras == 2 && diferencaMinutos == 0) {
                    totalPagar += 5.00;
                } else {
                    if (diferencaHoras == 2 && diferencaMinutos > 0) {
                        totalPagar += 5.00 + 1.00;
                    } else {
                        totalPagar += 5.00 + (diferencaHoras - 2) * 1.00;
                    }
                }
            }
        }
        this.caixa += totalPagar;
        return totalPagar;
    }

    public double lucro() {
        return this.caixa;
    }

    public String exibirPainel() {
        String painel = "";

        for (Vaga vaga : this.vagas) {
            if (vaga != null && vaga.getStatus()) {
                painel += vaga.posicao() + Util.pulaLinhas();
            }
        }
        return painel;
    }

    public String localizaCarro(String placa) {
        String localizacao = "";

        for (Vaga vaga : this.vagas) {
            if (!vaga.getStatus() && vaga.getPlacaCarro().equals(placa)) {
                localizacao += vaga.posicao();
            }
        }
        return localizacao;
    }

    public Vaga[] getVagas() {
        return this.vagas;
    }

}
