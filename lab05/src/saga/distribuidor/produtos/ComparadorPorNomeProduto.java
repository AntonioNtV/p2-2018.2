package saga.distribuidor.produtos;

import java.util.Comparator;

public class ComparadorPorNomeProduto implements Comparator<Produto> {

    @Override
    public int compare(Produto produto, Produto produto2) {
        return produto.getNome().toLowerCase().compareTo(produto2.getNome().toLowerCase());
    }
}
