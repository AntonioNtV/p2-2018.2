package prova2._caixaPersonalizada;

import prova2._caixaPersonalizada.formato.Formato;

import java.util.Objects;

public class CaixaPersonalizada implements Comparable<CaixaPersonalizada>{
    private String descricao;
    private String personalizacao;
    private Formato formato;

    public CaixaPersonalizada(String descricao, String personalizacao, Formato formato) {
        if (descricao == null || descricao.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro de caixa Retangular: Descrição não pode ser nula ou vazia");
        } else if (personalizacao == null || personalizacao.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro de caixa Retangular: Personalização não pode ser nula ou vazia");
        }

        this.descricao = descricao;
        this.personalizacao = personalizacao;
        this.formato = formato;
    }

    public double getPreco() {
        return this.formato.getArea() * 0.1;
    }

    public String getFormato() {
        return this.formato.getFormato();
    }

    public void setPersonalizacao(String novaPersonalizacao) {
        this.personalizacao = novaPersonalizacao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getPersonalizacao() {
        return this.personalizacao;
    }

    public String getDimensoes() {
        return this.formato.getDimensoes();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaixaPersonalizada that = (CaixaPersonalizada) o;
        return Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricao);
    }

    @Override
    public String toString() {
        return "Caixa com " + this.personalizacao + " custa R$ " + String.format("%.2f",this.getPreco())+ ". Formato " + this.getFormato();
    }

    @Override
    public int compareTo(CaixaPersonalizada caixaPersonalizada) {
        return this.descricao.toLowerCase().trim().compareTo(caixaPersonalizada.descricao.toLowerCase().trim());
    }
}
