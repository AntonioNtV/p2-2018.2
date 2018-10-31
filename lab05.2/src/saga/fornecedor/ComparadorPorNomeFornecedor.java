package saga.fornecedor;

import java.util.Comparator;

public class ComparadorPorNomeFornecedor implements Comparator<Fornecedor> {

    @Override
    public int compare(Fornecedor fornecedor, Fornecedor fornecedor2) {
        return fornecedor.getNome().toLowerCase().compareTo(fornecedor2.getNome().toLowerCase());
    }
}
