import org.jetbrains.annotations.Contract;

import java.util.Arrays;
/**
 * Representação de uma Disciplina na UFCG.
 * Toda Disciplina possui um nome, 4 notas de avaliação, e horas Necessárias de estudo.

 * @author Antonio Bertino de Vasconcelos Cabral Neto

 */
public class Disciplina {
    /**
     *  Nome da Disciplina.
     */
    private String nomeDisciplina;
    /**
     *  Horas trabalhadas pelo Aluno.
     */
    private int horasTrabalhadas;
    /**
     *  Notas de um aluno, o qual possui 4 notas. As mesmas foram armazenadas em um array de 4 espaços.
     */
    private double[] Notas = new double[4];
    /**
     * Constroi Disciplina.
     * Horas necessárias e as Notas possuem um valor padrão 0.
     * E notas possuem um valor padrão 0.
     * @param nomeDisciplina No formato String.
     */
    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasTrabalhadas = 0;
        for (int i = 0; i < 4; i++) {
            this.Notas[i] = 0;
        }
    }
    /**
     * Criado Calcular a nota do Aluno.
     * usado apenas dentro dessa classe.

     * @returns void.
     */
    private double media() {
        return ((this.Notas[0] + this.Notas[1] + this.Notas[2] + this.Notas[3])/ 4 );
    }
    /**
     * Criado para modificar o nome da Disciplina.
     * @param novaDisciplina No formato String.

     * @returns void.
     */
    public void setNomeDisciplina(String novaDisciplina) {
        this.nomeDisciplina = novaDisciplina;
    }
    /**
     * Criado para retornar o nome da Disciplina

     * @returns String com o nome da Disciplina.
     */
    public String getNomeDisciplina(){
        return this.nomeDisciplina;
    }
    /**
     * Criado para retornar as Horas Trabalhadas pelo Aluno.

     * @returns int com quantidade de horas trabalhadas.
     */
    public int getHorasTrabalhadas() {
        return this.horasTrabalhadas;
    }
    /**
     * Criado para retornar alguma nota do aluno.
     * @param nota a qual se refere a nota desejado (1,2,3 ou 4).

     * @returns double com nota desejada.
     */
    public double getNota(int nota) {
        return this.Notas[nota -1];
    }
    /**
     * Criado para adicionar horas trabalhadas ao aluno.
     * @param horas no formato int.

     * @returns void.
     */
    public void cadastraHoras(int horas) {
        this.horasTrabalhadas += horas;
    }
    /**
     * Criado para cadastrar nota do aluno.
     * @param nota para identificar qual das 4 notas serão cadastradas.
     * @param valorNota sendo a mesma a nota á ser cadastrada.

     * @returns void.
     */
    public void cadastraNota(int nota, double valorNota) {
        this.Notas[nota - 1] = valorNota;
    }

    @Override
    public int hashCode() {
            return super.hashCode();
    }

    @Contract(value = "null -> false", pure = true)
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    /**
     * Criado para identificar se o aluno foi aprovado, ou não.

     * @returns boolean com o estado de aprovação do aluno. true para aprovado e false para não aprovado.
     */
    public boolean aprovado() {
        if (media() >= 7.0) {
            return true;
        }
        return false;
    }
    /**
     * Retorna a String que a disciplina. A representação segue o
     * formato “'Nome da Disciplina' 'Horas trabalhadas' 'media' ['nota1', 'nota2', 'nota3', 'nota4']”.

     *
     * @return a representação em String de um aluno.
     */
    public String toString() {
        return this.nomeDisciplina + " " + this.horasTrabalhadas + " " + media() + " " + "[" + this.Notas[0] + ", " + this.Notas[1] + ", " + this.Notas[2] + ", " + this.Notas[3] + "]";
    }
}