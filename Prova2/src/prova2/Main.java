package prova2;

import prova2._controllers.CaixaPersonalizadaController;

public class Main {
    public static void main(String[] args) {
        CaixaPersonalizadaController caixas = new CaixaPersonalizadaController();

        System.out.println(caixas.cadastraCaixaRetangular("Caixa retangular linda","Caixa rosa",10,10));
        System.out.println(caixas.cadastraCaixaCircular("Caixa redondinha","Caixa preta",10));
        System.out.println(caixas.cadastraCaixaCircular("Caixa PRETOLA","Caixa preta",10));
        System.out.println(caixas.redimentosTotais());
        System.out.println(caixas.caixasFormato("Circular"));

    }
}
