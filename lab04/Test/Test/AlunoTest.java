package Test;

import controleAlunos.Aluno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {
    private Aluno alunoTest;

    @BeforeEach
    void AlunoTest(){
        this.alunoTest = new Aluno("123","Neto", "Ciência da Computação");
    }

    @Test
    void equals() {
        Aluno aluno2 = new Aluno("123","Neto 2", "Ciência da Amputação");
        Aluno aluno3 = new Aluno("133","Meu deus, outro neto","Ciência das clonagens");

        assertEquals(true,this.alunoTest.equals(aluno2));
        assertEquals(false,this.alunoTest.equals(aluno3));
    }


    @Test
    void hashCodeTest() {
        Aluno aluno2 = new Aluno("123","Neto 2", "Ciência da Amputação");
        Aluno aluno3 = new Aluno("133","Meu deus, outro neto","Ciência das clonagens");

        assertEquals(this.alunoTest.hashCode(), aluno2.hashCode());
        assertNotEquals(this.alunoTest.hashCode(),aluno3.hashCode());

    }

    @Test
    void toStringTest() {
        assertEquals("123 - Neto - Ciência da Computação",this.alunoTest.toString());
    }
}