package cardapioVirtual;

import java.util.Arrays;

import util.Util;

public class CardapioVirtual {
    private String nomeEstabelecimento;
    private Item[] cardapio;

    public CardapioVirtual(String nome) {
        this.nomeEstabelecimento = nome;
        this.cardapio = new Item[5];
    }

    public CardapioVirtual(String nome, int qtdItens) {
        this.nomeEstabelecimento = nome;
        this.cardapio = new Item[qtdItens];
    }

    public void adicionaItem(Item item) {
        for (int i = 0; i < this.cardapio.length; i++) {
            if (this.cardapio[i] == null) {
                this.cardapio[i] = item;
                break;
            }
        }
    }

    public String listaCardapio() {
        String lista = "";

        for (int i = 0; i < this.cardapio.length; i++) {
            if (this.cardapio[i] != null) {
                lista += (i + 1) +  "- " + this.cardapio[i].toString() + Util.pulaLinhas(1);
            }
        }
        return lista;
    }

    public int calcularCaloriasRefeicao(String[] refeicao,	String tamanhoRefeicao) {
        String[] refeicoesArray = {"arroz branco", "arroz a grega", "macarrao", "feijoada", "feijao verde", "frango assado", "bife", "vinagrete"};
        int valor = defineValorRefeicao(tamanhoRefeicao);
        int valorTotal = 0;

        for (int i = 0; i < refeicao.length; i++) {

            String nomeRefeicao = refeicao[i];

            if (!Arrays.asList(refeicoesArray).contains(nomeRefeicao)) {
                throw new IllegalArgumentException("");
            }

            for (int j = 0; j < this.cardapio.length; j ++) {
                if (this.cardapio[i] != null && this.cardapio[j].getNome().equals(nomeRefeicao)) {
                    valorTotal += this.cardapio[j].getCalorias();
                    break;
                }
            }
        }
        return valorTotal * valor;
    }

    public String getNome() {
        return this.nomeEstabelecimento;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(cardapio);
        result = prime * result + ((nomeEstabelecimento == null) ? 0 : nomeEstabelecimento.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CardapioVirtual other = (CardapioVirtual) obj;
        if (!Arrays.equals(cardapio, other.cardapio))
            return false;
        if (nomeEstabelecimento == null) {
            if (other.nomeEstabelecimento != null)
                return false;
        } else if (!nomeEstabelecimento.equals(other.nomeEstabelecimento))
            return false;
        return true;
    }

    private int defineValorRefeicao(String tamanho) {
        int valor = 0;

        if (tamanho.equals("padrão")) {
            valor = 1;

        } else if (tamanho.equals("grande")) {
            valor = 2;

        } else {
            valor = 3;
        }

        return valor;
    }

}