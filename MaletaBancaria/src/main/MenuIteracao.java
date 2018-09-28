package main;

import maletaBancaria.MaletaBancaria;
import util.*;

public class MenuIteracao {
	
	public static void exibirMenu() {
		MaletaBancaria maleta = new MaletaBancaria();
		String opcaoMenu = "(C)adastra dinheiro" + Util.pulaLinhas(1) 
								+ "0 para sair" + Util.pulaLinhas(1);
		
		for (int i = 0; i < 100; i ++) {
			System.out.println(opcaoMenu);
			String opcao = Util.input("Opção > ").toUpperCase();
			
			switch (opcao) {
			
				case "C":
					String valor = Util.input("Digite quanto quer depositar > ");
					maleta.cadastraConta(Integer.parseInt(valor));
					break;
				
			}
			
			if (opcao.equals("0")) {
				break;
			}
		
		}
		
		System.out.println(maleta.toString());
		
	}

}
