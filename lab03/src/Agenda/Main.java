package Agenda;

public class Main {
    public static void main(String[] args) {
        Agenda teste = new Agenda();
        teste.cadastraContato("Antonio","Neto","98277948",2);
        teste.cadastraContato("Arthur","Silva","33333333",3);
        System.out.println(teste.listarContatos());
        System.out.println(teste.exibirContato(3));
        System.out.println(teste.exibirContato(2));
        System.out.println(teste.exibirContato(4));
    }
}
