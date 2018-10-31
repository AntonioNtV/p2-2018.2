package saga.Produto;

import java.util.Comparator;

public class ComparadorPeloToStringProduto implements Comparator<Produto> {
    @Override
    public int compare(Produto produto, Produto produto2) {
        return produto.toString().toLowerCase().compareTo(produto2.toString().toLowerCase());
    }
}
