/**
 * Representação de uma conta um aluno em um laborátorio na UFCG.
 * Toda conta de laboratório possui um Laboratório, um espaço ocupado e um cota de consumo que por padrão é de 2000MB  (ou aproximadamente 2GB)
 *
 *

 * @author Antonio Bertino de Vasconcelos Cabral Neto

 */
public class ContaLaboratorio {
    /**
     *  Nome do Laboratório, que pode ser representado por alguma sigla.
     *  Como LCCX. Onde LCC significa Laboratório de Ciência da Computação e X é o Número do Laboratório.
     */
    private String nomeLaboratorio;
    /**
     * Cota do Laboratório que por padrão é 2000 MB
     */
    private int cotaLaboratorio;
    /**
     * Espaço Ocupado pelo dono da conta do Laboratório. Representado por um valor de XXXX <= cota
     */
    private int espacoOcupado;
    /**
     * Constroi uma conta de um Laboratório

     * @param nomeLaboratorio No formato String
     */
    public ContaLaboratorio (String nomeLaboratorio) {
        this.nomeLaboratorio = nomeLaboratorio;
        this.cotaLaboratorio = 2000;
        this.espacoOcupado = 0;
    }
    /**
     * Constroi uma conta de um Laboratório

     * @param nomeLaboratorio No formato String
     * @param cotaLaboratorio como um número inteiro, representando a cota em mbytes
     */
    public ContaLaboratorio(String nomeLaboratorio, int cotaLaboratorio) {
        this.nomeLaboratorio = nomeLaboratorio;
        this.cotaLaboratorio = cotaLaboratorio;
        this.espacoOcupado = 0;
    }
    /**
     * Criado para modificar o nome do Laboratório
     * @param novoNomeLaboratorio No formato String

     * @returns void.
     */
    public void setNomeLaboratorio(String novoNomeLaboratorio) {
        this.nomeLaboratorio = novoNomeLaboratorio;
    }
    /**
     * Criado para modificar o tamanho da cota

     * @returns void.
     */
    public void setCota(int novaCota) {
        this.cotaLaboratorio = novaCota;
    }
    /**
     * Criado retornar o nome do Laboratório

     * @returns String com nome do laboratório.
     */
    public String getNomeLaboratorio() {
        return this.nomeLaboratorio;
    }
    /**
     * Criado para retornar o Espaço ocupado pela conta

     * @returns inteiro com X Mbytes de Espaço Ocupado
     */
    public int getEspacoOcupado() {
        return this.espacoOcupado;
    }
    /**
     * Criado para retornar o tamanho da cota do Laboratório

     * @returns void.
     */
    public int getCota() {
        return this.cotaLaboratorio;
    }
    /**
     * Criado para adicionar um número de mbytes adicionado da conta do LCC

     * @returns void.
     */
    public void consomeEspaco(int mbytes) {
        this.espacoOcupado += mbytes;
    }
    /**
     * Criado para liberar um número de mbytes adicionado da conta do LCC

     * @returns void.
     */
    public void liberaEspaco(int mbytes) {
        this.espacoOcupado -= mbytes;
    }
    /**
     * Criado para verificar se foi o total de espaço ocupado pelo Usuário atingiu a cota de armazenamento.

     * @returns um booleano com true para atingiu e false para não atingiu.
     */
    public boolean atingiuCota() {
        if (this.espacoOcupado >= this.cotaLaboratorio) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Retorna a String que representa a Conta do Laboratório. A representação segue o
     * formato “Nome Laboratorio Espaço Ocupado/Cota do laboratório.
     *
     * @returns a representação em String de uma conta em um Laboratório.
     */
    public String toString() {
        return this.nomeLaboratorio + " " + this.espacoOcupado + "/" + this.cotaLaboratorio;
}

}
