package novoEu._controllers;

public class Facade {
    private NovoEuController novoEuController;

    public Facade() {
        this.novoEuController = new NovoEuController();
    }

    public int adicionaUsuario(int id, String nome) {
        return this.novoEuController.adicionaUsuario(id, nome);
    }

    public void cadastraNovaDieta(String nomeDieta, String alimentos) {
        this.novoEuController.cadastraDieta(nomeDieta, alimentos);
    }

    public String listaUsuario() {
        return this.novoEuController.listaUsuarios();
    }

    public void setDietaUsuario(int idUsuario, String nomeDiente) {
        this.novoEuController.setDietaUsuario(idUsuario, nomeDiente);
    }

    public int comeAlimento(int idUsuario, String alimento) {
        return this.novoEuController.comeAlimento(idUsuario, alimento);
    }

    public String finalizaSistema() {
        this.novoEuController.finalizaSistema();
        return "SISTEMA FINALIZANDO";
    }

    public String inicializaSistema() {
        this.novoEuController.inicializaSistema();
        return "SISTEMA INICIALIZANDO";
    }
}
