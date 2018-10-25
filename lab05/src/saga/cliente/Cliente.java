package saga.cliente;

public interface Cliente {
    public void editorNome(String nome);
    public void editorEmail(String email);
    public void editorlocalizacao(String localic);
    public String toString();
}
