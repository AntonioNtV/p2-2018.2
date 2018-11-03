package saga.fornecedor;

import saga.Produto.ProdutoID;

import java.util.*;

/**
 * Criado para ser o controlador de fornecedores.
 *
 * @author Antonio Bertino de Vasconcelos Cabral Neto
 */
public class FornecedorController {
    /**
     * Conjunto de fornecedores. Com nome do fornecedor como chave do mapa.
     */
    private Map<String, Fornecedor> fornecedores;

    /**
     * Criado para inicializar o controlador de fornecedores.
     */
    public FornecedorController() {
        this.fornecedores = new HashMap<>();
    }

    /**
     * Criado para adicionar um Fornecedor ao Sistema.
     *
     * @param nome String com nome do fornecedor.
     * @param email String com email do fornecedor.
     * @param numero String com o número do fornecedor.
     * @return String com o nome do fornecedor.
     */
    public String adicionaFornecedor(String nome, String email, String numero) {
        if (nome == null || nome.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
        } else if (email == null || email.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
        } else if (numero == null || numero.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: numero nao pode ser vazio ou nulo.");
        } else if (this.fornecedores.containsKey(nome.toLowerCase())){
            throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
        }

        this.fornecedores.put(nome.toLowerCase(), new Fornecedor(nome,email,numero));
        return this.fornecedores.get(nome.toLowerCase()).getNome();

    }

    /**
     * Criado para retornar String com a representação textual de algum fornecedor espeficio.
     * @param nome do fornecedor o qual se quer a representação textual.
     * @return String com a representação textual de algum fornecedor específico.
     */
    public String exibeFornecedor(String nome) {
        if (!this.fornecedores.containsKey(nome.toLowerCase())) {
            throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
        }

        return this.fornecedores.get(nome.toLowerCase()).toString();
    }

    /**
     * Criado para retornar a representação de todos os fornecedores cadastrados no Sistema.
     *
     * @return String com todos os fornecedores cadastrados no sistema, ordenados por ordem afalbética.
     */
    public String exibeFornecedores() {
        String fornecedores = "";

        List<Fornecedor> fornecedoresLista = this.ordenaFornecedorPeloNome();

        for (Fornecedor fornecedor : fornecedoresLista) {
            fornecedores += fornecedor.toString() + " | ";
        }

        return fornecedores.substring(0, fornecedores.length()- 3);
    }

    /**
     * Criado para editar os atributos de algum fornecedor.
     *
     * @param nome String com o nome do fornecedor que vai ser editado.
     * @param atributo String com o atributo que se deseja ser editado.
     * @param novoValor String com o novo valor a ser editado.
     */
    public void editaFornecedor(String nome, String atributo, String novoValor) {
        final String[] atributosValidos = {"email", "telefone"};
        final List<String> atributosValidosList = Arrays.asList(atributosValidos);

        if (atributo.equals("nome")) {
            throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
        } else if (novoValor == null || novoValor.equals("")) {
            throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
        } else if (atributo == null || atributo.equals("")) {
            throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
        } else if (!atributosValidosList.contains(atributo)) {
            throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
        } else if (!this.fornecedores.containsKey(nome.toLowerCase())){
            throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
        }

        this.fornecedores.get(nome.toLowerCase()).editaFornecedor(atributo, novoValor);
    }

    /**
     * Criado para remover um Fornecedor do Sistema.
     *
     * @param nome String com o nome do fornecedor que será removido.
     */
    public void removeFornecedor(String nome) {
        if (!this.fornecedores.containsKey(nome.toLowerCase())) {
            throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
        } else if (!this.fornecedores.containsKey(nome.toLowerCase())) {
            throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");

        }

        this.fornecedores.remove(nome.toLowerCase());
    }

    /**
     * Criado para adicionar algum produto a algum fornecedor
     *
     * @param fornecedor String com nome do fornecedor.
     * @param nome String com o nome do produto.
     * @param descricao String com a descrição do produto.
     * @param preco double com o preço do produto.
     */
    public void adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
        ProdutoID produto = new ProdutoID(nome.toLowerCase(), descricao.toLowerCase());


        if (fornecedor == null || fornecedor.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
        } else if (nome == null || nome.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
        } else if (descricao == null || descricao.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
        } else if (!this.fornecedores.containsKey(fornecedor.toLowerCase())) {
            throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
        } else if (this.fornecedores.get(fornecedor.toLowerCase()).possuiProduto(produto)) {
            throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
        } else if (preco < 0) {
            throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
        }

        this.fornecedores.get(fornecedor.toLowerCase()).adicionaProduto(nome,descricao,preco);


    }

    /**
     * Criado para retornar a representação textual de algum produto em específico.
     *
     * @param nome String com o nome do produto.
     * @param descricao String com a descrição do produto.
     * @param fornecedor String com o fornecedor do produto.
     * @return
     */
    public String exibeProduto(String nome, String descricao, String fornecedor) {
        ProdutoID produto = new ProdutoID(nome.toLowerCase(), descricao.toLowerCase());

        if (nome == null || nome.equals("")) {
            throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
        } else if (fornecedor == null || fornecedor.equals("")) {
            throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
        } else if (descricao == null || descricao.equals("")) {
            throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
        } else if (!this.fornecedores.containsKey(fornecedor.toLowerCase())) {
            throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
        } else if (!this.fornecedores.get(fornecedor.toLowerCase()).possuiProduto(produto)) {
            throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
        }

        return this.fornecedores.get(fornecedor.toLowerCase()).exibeProduto(nome, descricao);

    }

    /**
     * Criado para retornar a representação textual de todos os produtos cadastrados no sistema.
     *
     * @return String com todos os produtos cadastrados no sistema, em ordem alfabética.
     */
    public String exibeProdutos() {
        String produtos = "";
        List<Fornecedor> fornecedorList = this.ordenaFornecedorPeloNome();

        for (Fornecedor fornecedor : fornecedorList) {
            produtos += fornecedor.exibeProdutos();
        }

        return produtos.substring(0, produtos.length() - 3);
    }

    /**
     * Criado para retornar a representação de todos os produtos de um determinado Fornecedor.
     *
     * @param fornecedor String com o nome do fornecedor.
     * @return String com todos os produtos de um determinado fornecedor.
     */
    public String exibeProdutosFornecedor(String fornecedor) {
        String produtos = "";

        if (fornecedor == null || fornecedor.equals("")) {
            throw new IllegalArgumentException("Erro na exibicao dos produtos: fornecedor nao pode ser vazio ou nulo.");
        } else if (!this.fornecedores.containsKey(fornecedor.toLowerCase())) {
            throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
        }

        produtos += this.fornecedores.get(fornecedor.toLowerCase()).exibeProdutos();
        return produtos.substring(0, produtos.length() - 3);
    }

    /**
     * Criado para ordenar uma lista de fornecedores com base no nome dos fornecedores.
     * @return List do tipo fornecedor ordenada pelo nome do fornecedor.
     */
    private List<Fornecedor> ordenaFornecedorPeloNome() {
        List<Fornecedor> fornecedorList = new ArrayList<>(this.fornecedores.values());
        Collections.sort(fornecedorList);

        return fornecedorList;
    }

    /**
     * Criado para editar o preço de um determinado produto de um determinado fornecedor.
     *
     * @param nome String com nome do produto a ser editado.
     * @param descricao String com a descrição do produto a ser editado.
     * @param fornecedor String com nome do fornecedor que possui o produto.
     * @param novoPreco double com novo preço do prdduto.
     */
    public void editaProduto(String nome, String descricao, String fornecedor, double novoPreco) {
        ProdutoID produto = new ProdutoID(nome.toLowerCase(), descricao.toLowerCase());

        if (fornecedor == null || fornecedor.equals("")) {
            throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
        } else if (nome == null || nome.equals("")) {
            throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
        } else if (descricao == null || descricao.equals("")) {
            throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
        } else if (novoPreco < 0) {
            throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
        } else if (!this.fornecedores.containsKey(fornecedor.toLowerCase())) {
            throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
        } else if (!this.fornecedores.get(fornecedor.toLowerCase()).possuiProduto(produto)) {
            throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe");
        }

        this.fornecedores.get(fornecedor.toLowerCase()).editaProduto(nome, descricao, novoPreco);
    }

    /**
     * Criado para Remover algum produto de algum determinado fornecedor
     *
     * @param nome String com o nome do produto a ser removido.
     * @param descricao String com descrição do produto a ser removido.
     * @param fornecedor String com nome do fornecedor que possui o produto a ser removido.
     */
    public void removeProduto(String nome, String descricao, String fornecedor) {
        ProdutoID produto = new ProdutoID(nome.toLowerCase(), descricao.toLowerCase());

        if (fornecedor == null || fornecedor.equals("")) {
            throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
        } else if (descricao == null || descricao.equals("")) {
            throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
        } else if (nome == null || nome.equals("")) {
            throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
        } else if (!this.fornecedores.containsKey(fornecedor.toLowerCase())) {
            throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
        } else if (!this.fornecedores.get(fornecedor.toLowerCase()).possuiProduto(produto)) {
            throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
        }

        this.fornecedores.get(fornecedor.toLowerCase()).removeProduto(nome, descricao);
    }
}
