package saga.Produto;

import java.util.Objects;

public class ProdutoID {
    private String nome;
    private String descricao;

    public ProdutoID(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoID produtoID = (ProdutoID) o;
        return Objects.equals(nome, produtoID.nome) &&
                Objects.equals(descricao, produtoID.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao);
    }
}
