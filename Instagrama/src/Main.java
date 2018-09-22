public class Main {
    public static void main(String[] args) {
        Instagrama teste = new Instagrama();
        teste.cadastraUsuarios("antonio.bertino.neto@ccc.ufcg.edu.br", "Antonio Neto");
        System.out.println(teste.qtdCadastrados());
        System.out.println(teste.listarUsarios());
        System.out.println(teste.listaFotos("antonio.bertino.neto@ccc.ufcg.edu.br"));
        teste.cadastraFoto("antonio.bertino.neto@ccc.ufcg.edu.br","plantinhaa","foto legal <3");
    }
}
