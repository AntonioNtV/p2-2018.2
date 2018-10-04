package Test;

import controleAlunos.Aluno;
import controleAlunos.Grupo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Util;

import static org.junit.jupiter.api.Assertions.*;

class GrupoTest {
    private Grupo grupoTest;
    private Aluno alunoTest;
    private Aluno alunoTest2;


    @BeforeEach
    void GrupoTest() {
        this.grupoTest = new Grupo("Java");
        this.alunoTest = new Aluno("123","Neto", "Ciência da Computação");
        this.alunoTest2 = new Aluno("444","Neto clone", "Ciência da Computação");
    }

    @Test
    void alocaAluno() {
        assertEquals("ALUNO ALOCADO!",this.grupoTest.alocaAluno(this.alunoTest));
        assertThrows(IllegalArgumentException.class, () -> this.grupoTest.alocaAluno(null));
    }

    @Test
    void getTema() {
        assertEquals("Java",this.grupoTest.getTema());
    }

    @Test
    void imprimeAlunos() {
        assertEquals("", this.grupoTest.imprimeAlunos());

        this.grupoTest.alocaAluno(this.alunoTest);
        this.grupoTest.alocaAluno(this.alunoTest2);

        String saida = "* 123 - Neto - Ciência da Computação" + Util.pulaLinha()
                    + "* 444 - Neto clone - Ciência da Computação" + Util.pulaLinha();

        assertEquals(saida, this.grupoTest.imprimeAlunos());
    }

    @Test
    void equalsTest() {
        this.grupoTest.alocaAluno(this.alunoTest);
        this.grupoTest.alocaAluno(this.alunoTest2);
        Grupo grupoTest2 = new Grupo("Java");
        Grupo grupoTest3 = new Grupo("Python");
        Grupo grupoTest4 = new Grupo("Java");
        grupoTest2.alocaAluno(this.alunoTest);
        grupoTest2.alocaAluno(this.alunoTest2);
        grupoTest4.alocaAluno(this.alunoTest);

        assertEquals(true, this.grupoTest.equals(grupoTest2));
        assertEquals(false, this.grupoTest.equals(grupoTest3));
        assertEquals(false, this.grupoTest.equals(grupoTest4));
    }

    @Test
    void hashCodeTest() {
        this.grupoTest.alocaAluno(this.alunoTest);
        this.grupoTest.alocaAluno(this.alunoTest2);
        Grupo grupoTest2 = new Grupo("Java");
        Grupo grupoTest3 = new Grupo("Python");
        Grupo grupoTest4 = new Grupo("Java");
        grupoTest2.alocaAluno(this.alunoTest);
        grupoTest2.alocaAluno(this.alunoTest2);
        grupoTest4.alocaAluno(this.alunoTest);

        assertEquals(this.grupoTest.hashCode(), grupoTest2.hashCode());
        assertNotEquals(this.grupoTest.hashCode(), grupoTest3.hashCode());
        assertNotEquals(this.grupoTest.hashCode(), grupoTest4.hashCode());

    }
}