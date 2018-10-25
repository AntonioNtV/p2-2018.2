package saga.distribuidor;

public class DistribuidorBase implements Distribuidor {
    protected String nome;
    protected String email;
    protected String numero;

    public DistribuidorBase(String nome, String email, String numero) {
        this.nome = nome;
        this.email = email;
        this.numero = numero;
    }

    @Override
    public void editorDistribuidor(String atributo, String atributoNovo) {
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
    public String toString() {
        return this.numero + " - " + this.email + " - " + this.numero;
    }
}
