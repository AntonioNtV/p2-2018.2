package saga.cliente;

import java.util.Comparator;

public class ComparadorPeloNomeDoCliente implements Comparator<Cliente> {
    @Override
    public int compare(Cliente cliente, Cliente cliente2) {
        return cliente.getNome().toLowerCase().compareTo(cliente2.getNome().toLowerCase());
    }
}
