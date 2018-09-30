package cardapioVirtual;

public class Main {
    public static void main(String[] args) {
        CardapioVirtual cardapioTest = new CardapioVirtual("Restaurante Test", 8);
        Item item = new Item("arroz branco", 100);
        Item item2 = new Item("arroz a grega", 200);
        Item item3 = new Item("macarrao", 200);
        Item item4 = new Item("feijoada", 150);
        Item item5 = new Item("feijao verde", 90);
        Item item6 = new Item("frango assado", 90);
        Item item7 = new Item("bife", 100);
        Item item8 = new Item("vinagrete", 0);
        Item[] listaItens = {item, item2, item3, item4, item5, item6, item7, item8};

        for (int i = 0; i < listaItens.length; i++) {
            cardapioTest.adicionaItem(listaItens[i]);
        }

        String[] refeicoes = {"arroz branco", "feijoada", "vinagrete"};
        System.out.println(cardapioTest.calcularCaloriasRefeicao(refeicoes, "grande"));
        System.out.println(cardapioTest.listaCardapio());

    }

}



