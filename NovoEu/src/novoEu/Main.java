package novoEu;

import novoEu._controllers.Facade;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Facade facadeNovoEu = new Facade();

        facadeNovoEu.inicializaSistema();
        facadeNovoEu.adicionaUsuario(1, "Antonio Neto");
        facadeNovoEu.adicionaUsuario(3, "Caroliny Valenca");
        facadeNovoEu.adicionaUsuario(5, "Dayvid Lindoca");

        facadeNovoEu.cadastraNovaDieta("Minha dieta querida","Feijao Arroz Macarrão");

        System.out.println(facadeNovoEu.finalizaSistema());
        System.out.println(facadeNovoEu.inicializaSistema());

        System.out.println(facadeNovoEu.listaUsuario());
        System.out.println(facadeNovoEu.finalizaSistema());

    }
}
