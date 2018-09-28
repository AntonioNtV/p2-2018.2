public class ContaCantina {
    private String nomeCantina;
    private int debitoConta;
    private int qtdLanches;
    private int qtdLanchesTotal;

    public void setNomeCantina(String nomeCantina) {
        this.nomeCantina = nomeCantina;
    }

    public ContaCantina(String contaCantina) {
        this.nomeCantina = contaCantina;
    }

    public void cadastraLanche(int qtdLanches, int valorCentavos) {
        this.debitoConta += valorCentavos;
        this.qtdLanches += qtdLanches;
        this.qtdLanchesTotal += qtdLanches;
    }

    public void pagaConta(int valorCentavos) {
        this.debitoConta -= valorCentavos;
    }

    public int getFaltaPagar() {
        return this.debitoConta;
    }

    public String toString() {
        return this.nomeCantina + " " + this.qtdLanchesTotal + " " + debitoConta;
    }
}
