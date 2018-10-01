package CardapioVirtualTest;

import cardapioVirtual.CardapioVirtual;
import cardapioVirtual.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Util;

import static org.junit.jupiter.api.Assertions.*;

class CardapioVirtualTest {
    private CardapioVirtual cardapioTest;
    private Item item;
    private Item item2;
    private Item item3;
    private Item item4;
    private Item item5;
    private Item item6;
    private Item item7;
    private Item item8;;
    private Item[] listaItens;

    @BeforeEach
    void CardapioVirtualTest() {
        this.cardapioTest = new CardapioVirtual("Restaurante Test",8);
        this.item = new Item("arroz branco", 100);
        this.item2 = new Item("arroz a grega", 200);
        this.item3 = new Item("macarrao", 200);
        this.item4 = new Item("feijoada", 150);
        this.item5 = new Item("feijao verde", 90);
        this.item6 = new Item("frango assado", 90);
        this.item7 = new Item("bife", 100);
        this.item8 = new Item("vinagrete", 0);
        this.listaItens = new Item[8];
        this.listaItens[0] = this.item;
        this.listaItens[1] = this.item2;
        this.listaItens[2] = this.item3;
        this.listaItens[3] = this.item4;
        this.listaItens[4] = this.item5;
        this.listaItens[5] = this.item6;
        this.listaItens[6] = this.item7;
        this.listaItens[7] = this.item8;



        for (int i = 0; i < this.listaItens.length; i++) {
            this.cardapioTest.adicionaItem(this.listaItens[i]);
        }

    }

    @Test
    void testeNome() {
        assertEquals("Restaurante Test",cardapioTest.getNome());
    }

    @Test
    void testCalculaCalorias() {
        String[] refeicoes = {"arroz branco", "feijoada", "vinagrete"};
        String[] refeicoes2 = {"arroz preto", "feijoada", "vinagrete"};

        assertEquals(500,this.cardapioTest.calcularCaloriasRefeicao(refeicoes,"grande"));
        assertThrows(IllegalArgumentException.class, () -> { this.cardapioTest.calcularCaloriasRefeicao(refeicoes2, "grande");}); }

    @Test
    void testListaCardapio() {
        String lista = "1- arroz branco - 100" + Util.pulaLinhas(1)
                     + "2- arroz a grega - 200" + Util.pulaLinhas(1)
                     + "3- macarrao - 200" + Util.pulaLinhas(1)
                     + "4- feijoada - 150" + Util.pulaLinhas(1)
                     + "5- feijao verde - 90" + Util.pulaLinhas(1)
                     + "6- frango assado - 90" + Util.pulaLinhas(1)
                     + "7- bife - 100" + Util.pulaLinhas(1)
                     + "8- vinagrete - 0" + Util.pulaLinhas(1);

        assertEquals(lista,this.cardapioTest.listaCardapio());
    }
}
