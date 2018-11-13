package prova2.facade;

import prova2._controllers.CaixaPersonalizadaController;

public class Facade {
    CaixaPersonalizadaController caixas;

    public Facade() {
        this.caixas = new CaixaPersonalizadaController();
    }


}
