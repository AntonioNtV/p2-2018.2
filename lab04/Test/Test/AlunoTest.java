package Test;

import controleAlunos.Aluno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de teste da classe Aluno
 * @author Antonio Bertino de Vasconcelos Cabral Neto - UFCG - 2018 ©s
 */
class AlunoTest {
    private Aluno alunoTest;

    /**
     * Adição de um BeforeEach para iniciar um objeto aluno
     */
    @BeforeEach
    void AlunoTest(){
        this.alunoTest = new Aluno("123","Neto", "Ciência da Computação");
    }

    /**
     * Teste do método equals
     */
    @Test
    void equals() {
        Aluno aluno2 = new Aluno("123","Neto 2", "Ciência da Amputação");
        Aluno aluno3 = new Aluno("133","Meu deus, outro neto","Ciência das clonagens");

        assertEquals(true,this.alunoTest.equals(aluno2));
        assertEquals(false,this.alunoTest.equals(aluno3));
    }


    /**
     * Teste do método hashCode
     */
    @Test
    void hashCodeTest() {
        Aluno aluno2 = new Aluno("123","Neto 2", "Ciência da Amputação");
        Aluno aluno3 = new Aluno("133","Meu deus, outro neto","Ciência das clonagens");

        assertEquals(this.alunoTest.hashCode(), aluno2.hashCode());
        assertNotEquals(this.alunoTest.hashCode(),aluno3.hashCode());

    }

    /**
     * Teste do método toString
     */
    @Test
    void toStringTest() {
        assertEquals("123 - Neto - Ciência da Computação",this.alunoTest.toString());
    }
}