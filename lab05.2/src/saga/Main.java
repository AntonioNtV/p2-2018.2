package saga;

import saga.fornecedor.FornecedorController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        FornecedorController fc = new FornecedorController();
        fc.adicionaFornecedor("Seu Olavo","olavo@....","00 0000-0000");
        fc.adicionaProduto("Seu Olavo","Suco", "Suco de maracuja (copo)",1.50);
        fc.adicionaProduto("Seu Olavo","X-burguer", "Hamburguer de carne com queijo e calabresa",4.50);
        fc.adicionaCombo("Seu Olavo", "X-burguer + suco", "X-burguer com suco de maracuja", 0.20, "X-burguer - Hamburguer de carne com queijo e calabresa, Suco - Suco de maracuja (copo)");
        System.out.println(fc.exibeProduto("X-burguer + suco", "X-burguer com suco de maracuja", "Seu olavo"));
        System.out.println(fc.exibeProdutos());

        ArrayList lisTeste = new ArrayList<String>();
        lisTeste.add("Seu Olavo - X-burguer + suco - X-burguer com suco de maracuja");
        lisTeste.add("Seu Olavo - X-burguer - Hamburguer de carne com queijo e calabresa");
        Collections.sort(lisTeste);
        System.out.println(lisTeste);



    }
}
