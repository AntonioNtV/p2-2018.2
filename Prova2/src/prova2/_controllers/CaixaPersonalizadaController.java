package prova2._controllers;

import prova2._caixaPersonalizada.CaixaPersonalizada;
import prova2._caixaPersonalizada.formato.Circular;
import prova2._caixaPersonalizada.formato.Formato;
import prova2._caixaPersonalizada.formato.Pentagonal;
import prova2._caixaPersonalizada.formato.Retangular;

import java.util.*;

public class CaixaPersonalizadaController {
    private Map<String, CaixaPersonalizada> caixasCadastradas;

    public CaixaPersonalizadaController() {
        this.caixasCadastradas = new HashMap<>();
    }

    public String cadastraCaixaPentagonal(String descricao, String personalizacao, double lado) {

        if (descricao == null || descricao.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro de caixa Pentagonal: Descrição não pode ser nula ou vazia");
        } else if (personalizacao == null || personalizacao.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro de caixa Pentagonal: Personalização não pode ser nula ou vazia");
        } else if (lado <= 0) {
            throw new IllegalArgumentException("Erro no cadastro de caixa Pentagonal: Lado não um número negativo");
        } else if (this.caixasCadastradas.containsKey(descricao.toLowerCase().trim())) {
            throw new IllegalArgumentException("Erro no cadastro de caixa Pentagonal: Caixa já registrada");
        }

        Formato caixaPentagonal = new Pentagonal(lado);
        String identificador = descricao.toLowerCase().trim();

        CaixaPersonalizada caixaCadastrada = new CaixaPersonalizada(descricao,personalizacao, caixaPentagonal);
        this.caixasCadastradas.put(identificador, caixaCadastrada);

        return caixaCadastrada.getDescricao() + " - " + caixaCadastrada.getPersonalizacao() + " - " + caixaCadastrada.getPreco() + " - " + caixaCadastrada.getDimensoes();
    }

    public String cadastraCaixaCircular(String descricao, String personalizacao, double raio) {
        if (descricao == null || descricao.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro de caixa Circular: Descrição não pode ser nula ou vazia");
        } else if (personalizacao == null || personalizacao.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro de caixa Circular: Personalização não pode ser nula ou vazia");
        } else if (raio <= 0) {
            throw new IllegalArgumentException("Erro no cadastro de caixa Circular: raio não um número negativo");
        } else if (this.caixasCadastradas.containsKey(descricao.toLowerCase().trim())) {
            throw new IllegalArgumentException("Erro no cadastro de caixa Circular: Caixa já registrada");
        }

        Formato caixaCircular = new Circular(raio);
        String identificador = descricao.toLowerCase().trim();

        CaixaPersonalizada caixaCadastrada = new CaixaPersonalizada(descricao,personalizacao, caixaCircular);
        this.caixasCadastradas.put(identificador, caixaCadastrada);


        return caixaCadastrada.getDescricao() + " - " + caixaCadastrada.getPersonalizacao() + " - " + caixaCadastrada.getPreco() + " - " + caixaCadastrada.getDimensoes();
    }

    public String cadastraCaixaRetangular(String descricao, String personalizacao, double lado1, double lado2) {
        if (descricao == null || descricao.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro de caixa Retangular: Descrição não pode ser nula ou vazia");
        } else if (personalizacao == null || personalizacao.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro de caixa Retangular: Personalização não pode ser nula ou vazia");
        } else if (lado1 <= 0 || lado2 <= 0) {
            throw new IllegalArgumentException("Erro no cadastro de caixa Retangular: Lado não um número negativo");
        } else if (this.caixasCadastradas.containsKey(descricao.toLowerCase().trim())) {
            throw new IllegalArgumentException("Erro no cadastro de caixa Retangular: Caixa já registrada");
        }

        Formato caixaRetangular = new Retangular(lado1, lado2);
        String identificador = descricao.toLowerCase().trim();

        CaixaPersonalizada caixaCadastrada = new CaixaPersonalizada(descricao,personalizacao, caixaRetangular);
        this.caixasCadastradas.put(identificador, caixaCadastrada);

        return caixaCadastrada.getDescricao() + " - " + caixaCadastrada.getPersonalizacao() + " - " + caixaCadastrada.getPreco() + " - " + caixaCadastrada.getDimensoes();
    }

    public String editaDescricao(String descricao, String novaDescricao) {
        if (descricao == null || descricao.equals("")) {
            throw new IllegalArgumentException("Erro na edição de Caixa Personalizada: Descrição não pode ser nula ou vazia");
        } else if (!this.caixasCadastradas.containsKey(descricao.toLowerCase().trim())) {
            throw new IllegalArgumentException("Erro na edição de Caixa Personalizada: Caixa personalizada não existe");
        } else if (novaDescricao == null || novaDescricao.equals("")) {
            throw new IllegalArgumentException("Erro na edição de Caixa Personalizada: Nova descrição não pode ser nula ou vazia");
        }

        String identificador = descricao.toLowerCase().trim();
        this.caixasCadastradas.get(identificador).setPersonalizacao(novaDescricao);
        return this.caixasCadastradas.get(identificador).getPersonalizacao();
    }

    public boolean removeCaixa(String descricao) {
        if (this.caixasCadastradas.containsKey(descricao.toLowerCase().trim())) {
            this.caixasCadastradas.remove(descricao.toLowerCase().trim());
            return true;
        } else { return  false; }
    }


    public int qntCaixasCadastradas() {
        return this.caixasCadastradas.size();
    }

    public boolean possuiCaixaPersonalizacao(String personalizacao) {
        List<CaixaPersonalizada> caixas = this.listaCaixasOrdenadas();

        for (CaixaPersonalizada caixa : caixas) {
            if (caixa.getPersonalizacao().toLowerCase().trim().equals(personalizacao.toLowerCase().trim())) {
                return true;
            }
        }
        return false;
    }

    public String caixasFormato(String formato) {
        String saida = "";
        List<CaixaPersonalizada> caixas = this.listaCaixasOrdenadas();

        for (CaixaPersonalizada caixa : caixas) {
            if (caixa.getFormato().toLowerCase().trim().equals(formato.toLowerCase().trim())) {
                saida += caixa.toString() + System.lineSeparator();
            }
        }
        if (saida.equals("")) {
            return "Nenhuma caixa no formato cadastrada.";
        } else {
            return saida;
        }
    }

    public String caixasPersonalizacao(String personalizacao) {
        String saida = "";
        List<CaixaPersonalizada> caixas = this.listaCaixasOrdenadas();

        for (CaixaPersonalizada caixa : caixas) {
            if (caixa.getPersonalizacao().toLowerCase().trim().equals(personalizacao.toLowerCase().trim())) {
                saida += caixa.toString() + System.lineSeparator();
            }
        }
        if (saida.equals("")) {
            return "Nenhuma caixa no formato cadastrada.";
        } else {
            return saida;
        }
    }

    public double redimentosTotais() {
        double saida = 0.0;
        List<CaixaPersonalizada> caixas = this.listaCaixasOrdenadas();

        for (CaixaPersonalizada caixa : caixas) {
            saida += caixa.getPreco();
        }

        return saida;
    }

    private List<CaixaPersonalizada> listaCaixasOrdenadas() {
        List<CaixaPersonalizada> caixasCad = new ArrayList<>(this.caixasCadastradas.values());
        Collections.sort(caixasCad);
        return caixasCad;
    }
}
