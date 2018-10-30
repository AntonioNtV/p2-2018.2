package saga.distribuidor;

public class FornecedorBase extends FornecedorAbstract {
    public FornecedorBase(String nome, String email, String numero) {
        super(nome, email, numero);
    }

    @Override
    public void editorFornecedor(String atributo, String atributoNovo) {
        switch (atributo) {
            case "EMAIL":
                this.email = atributoNovo;
                break;

            case "NUMERO":
                this.numero = atributoNovo;
                break;
        }
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return this.numero + " - "  + this.email + " - " + this.numero;
    }
}