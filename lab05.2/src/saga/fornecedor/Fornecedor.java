package saga.fornecedor;

import saga.calculadores.CalculoCombo;
import saga.calculadores.CalculoComum;
import saga.calculadores.TipoDeCalculo;
import saga.produto.Combo;
import saga.produto.Produto;
import saga.produto.ProdutoAbstract;
import saga.identifiers.ID;
import saga.identifiers.ProdutoID;

import java.util.*;

/**
 * Criado para Represetar um Fornecedor do SAGA.
 * Um fornedor possui um Nome, Email, Numero e um Conjunto de produtos. O fornecedor é identificado unicamente pelo Nome.
 * @author Antonio Bertino de Vasconcelos Cabral Neto - UFCG - 2018.
 */
public class Fornecedor implements Comparable<Fornecedor>{
    /**
     * Representação do Nome do Fornecedor (Identificador Unico)
     */
    private String nome;
    /**
     * Representação do email do Fornecedor,
     */
    private String email;
    /**
     * Representação do número do Fornecedor.
     */
    private String numero;
    /**
     * Representação dos produtos cadastrados pelo Fornecedor. Possui como chave o ProdutoID q é uma classe que cria uma identifcação única com base no nome e descrição do produto.
     */
    private Map<ID, ProdutoAbstract> produtosCadastrados;

    /**
     * Constroi um Fornecedor
     *
     * @param nome Representação do nome do Fornecedor
     * @param email Representação do email do Fornecedor
     * @param numero Representação do númer do Fornecedor
     */
    public Fornecedor(String nome, String email, String numero) {
        if (nome == null || nome.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
        } else if (email == null || email.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
        } else if (numero == null || numero.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: numero nao pode ser vazio ou nulo.");
        }

        this.nome = nome;
        this.email = email;
        this.numero = numero;
        this.produtosCadastrados = new HashMap<>();
    }

    /**
     * Criado para retornar o nome do Fornecedor.
     * @return String com o nome do fornecedor
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Criado para editar algum atributo do Fornecedor. Os únicos atributos que podem ser editados são o Email e o telefone.
     * @param atributo Qual atributo será editado. Poderá ser email ou o telefone.
     * @param novoValor Representação do valor que substituira o valor que o atributo indicara.
     */
    public void editaFornecedor(String atributo, String novoValor) {
        final String[] atributosValidos = {"email", "telefone"};
        final List<String> atributosValidosList = Arrays.asList(atributosValidos);

        if (atributo.equals("nome")) {
            throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
        } else if (novoValor == null || atributo.equals("")) {
            throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
        } else if (atributo == null || atributo.equals("")) {
            throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
        } else if (!atributosValidosList.contains(atributo)) {
            throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
        }

        switch (atributo) {
            case "email":
                this.email = novoValor;
                break;

            case "telefone":
                this.numero = novoValor;
                break;
        }
    }

    /**
     * Criado para verificar a existência de algum produto cadastrado.
     * @param produto Representação da identificação de um produto.
     * @return Boolean com true para existe e false para não existe.
     */
    public boolean possuiProduto(ID produto) {
        if (this.produtosCadastrados.containsKey(produto)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Criado para adicionar um produto no Conjunto de produto do Fornecedor.
     *
     * @param nome Nome do produto
     * @param descricao Descrição do produto
     * @param preco Preço do produto
     */
    public void adicionaProduto(String nome, String descricao, double preco) {
        ID produtoID = new ProdutoID(nome.toLowerCase(), descricao.toLowerCase());

        if (nome == null || nome.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
        } else if (descricao == null || descricao.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
        } else if (this.possuiProduto(produtoID)) {
            throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
        } else if (preco < 0) {
            throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
        }

        TipoDeCalculo tipoDeCalculoSimples = new CalculoComum(preco);
        this.produtosCadastrados.put(produtoID, new Produto(nome, descricao, true, tipoDeCalculoSimples));

    }

    public void adicionaCombo(String nome, String descricao, double fator, String produtos) {
        ProdutoID comboId = new ProdutoID(nome.toLowerCase(), descricao.toLowerCase());
        String[] produtosEDescricao = this.listaProdutosString(produtos);

        if (nome == null || nome.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
        } else if (descricao == null || descricao.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
        } else if (fator <= 0 || fator >= 1) {
            throw new IllegalArgumentException("Erro no cadastro de combo: fator invalido.");
        } else if (this.possuiProduto(comboId)) {
            throw new IllegalArgumentException("Erro no cadastro de combo: combo ja existe.");
        } else if (produtos == null || produtos.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro de combo: combo deve ter produtos.");
        }

        Set<ProdutoAbstract> produtoParaCombo = new HashSet<>();
        for (int i = 0; i < produtosEDescricao.length; i += 2) {
            String nomeProduto = produtosEDescricao[i].toLowerCase().trim();
            String descricaoProduto = produtosEDescricao[i + 1].toLowerCase().trim();
            ID produto = new ProdutoID(nomeProduto, descricaoProduto);

            if (!this.possuiProduto(produto)) {
                throw new IllegalArgumentException("Erro no cadastro de combo: produto nao existe.");
            } else if (!this.getProduto(produto).isCombavel()) {
                throw new IllegalArgumentException("Erro no cadastro de combo: um combo nao pode possuir combos na lista de produtos.");
            }

            produtoParaCombo.add(this.produtosCadastrados.get(produto));
        }

        TipoDeCalculo tipoDeCalculoCombo = new CalculoCombo(fator, produtoParaCombo);
        this.produtosCadastrados.put(comboId, new Combo(nome, descricao, false, tipoDeCalculoCombo));

    }

    public void editaCombo(String nome, String descricao, double novoFator) {
        ID comboID = new ProdutoID(nome.toLowerCase(), descricao.toLowerCase());

        if (nome == null || nome.equals("")) {
            throw new IllegalArgumentException("Erro na edicao de combo: nome nao pode ser vazio ou nulo.");
        } else if (descricao == null || descricao.equals("")) {
            throw new IllegalArgumentException("Erro na edicao de combo: descricao nao pode ser vazia ou nula.");
        } else if (novoFator <= 0 || novoFator >= 1) {
            throw new IllegalArgumentException("Erro na edicao de combo: fator invalido.");
        } else if (!this.possuiProduto(comboID)) {
            throw new IllegalArgumentException("Erro na edicao de combo: produto nao existe.");
        }

        this.produtosCadastrados.get(comboID).alteraValor(novoFator);
    }

    private String[] listaProdutosString(String produtos) {
        String[] listaProdutos = produtos.replace(", "," - ").split(" - ");
        return listaProdutos;
    }

    /**
     * Criado para retornar a representação de um produto especifico
     *
     * @param nome - nome de produto
     * @param descricao - descricao do produto
     * @return uma String com a representação de um produto
     */
    public String exibeProduto(String nome, String descricao) {
        ID produto = new ProdutoID(nome.toLowerCase(), descricao.toLowerCase());

        if (nome == null || nome.equals("")) {
            throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
        } else if (descricao == null || descricao.equals("")) {
            throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
        } else if (!this.possuiProduto(produto)){
            throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
        }

        return this.produtosCadastrados.get(produto).toString();
    }

    /**
     * Criado para retornar a representação de todos os produtos do fornecedor
     *
     * @return String com todos os produtos do fornecedor.
     */
    public String exibeProdutos() {
        String produtos = "";

        List<ProdutoAbstract> produtosList = new ArrayList<>(this.produtosCadastrados.values());
        Collections.sort(produtosList);

        for (ProdutoAbstract produto : produtosList) {
            produtos += this.nome + " - " + produto.toString() + " | ";
        }

        return produtos;
    }

    public ProdutoAbstract getProduto(ID produto) {
        return this.produtosCadastrados.get(produto);
    }

    /**
     * Criado para modificar o preço de um determinado produto
     *
     * @param nome - String com nome do produto
     * @param descricao - String com a descriçao do produto.
     * @param novoPreco - Double com o preço do produto.
     */
    public void editaProduto(String nome, String descricao, double novoPreco) {
        ID produto = new ProdutoID(nome.toLowerCase(), descricao.toLowerCase());

        if (nome == null || nome.equals("")) {
            throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
        } else if (descricao == null || descricao.equals("")) {
            throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
        } else if (novoPreco < 0) {
            throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
        } else if (!this.possuiProduto(produto)) {
            throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");
        }

        this.produtosCadastrados.get(produto).alteraValor(novoPreco);

    }

    /**
     * Criado para remover um determinado produto
     *
     * @param nome String com nome do produto
     * @param descricao String com a pdescrição do produto
     */
    public void removeProduto(String nome, String descricao) {
        ProdutoID produto = new ProdutoID(nome.toLowerCase(), descricao.toLowerCase());

        if (descricao == null || descricao.equals("")) {
            throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
        } else if (nome == null || nome.equals("")) {
            throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
        } else if (!this.possuiProduto(produto)) {
            throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
        }

        this.produtosCadastrados.remove(produto);
    }

    /**
     * Equals Baseado no Nome do fornecedor
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fornecedor that = (Fornecedor) o;
        return Objects.equals(nome, that.nome);
    }

    /**
     * Hashcode baseado no nome do Fornecedor.
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    /**
     * Representação textual do Fornecedor.
     * @return String no formato "nome - email - numero"
     */
    @Override
    public String toString() {
        return this.nome + " - " + this.email + " - " + this.numero;
    }

    /**
     * Comparador baseado no nome do Fornecedor
     */
    @Override
    public int compareTo(Fornecedor fornecedor) {
        return this.nome.toLowerCase().compareTo(fornecedor.nome.toLowerCase());
    }
}
