package Test;

import controleAlunos.Controlador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Util;

import static org.junit.jupiter.api.Assertions.*;

class ControladorTest {
    private Controlador controlador;

    @BeforeEach
    void ConntraladorTest() {
        this.controlador = new Controlador();
    }

    @Test
    void cadastraAluno() {
        assertEquals("CADASTRO REALIZADO!", this.controlador.cadastraAluno("123","Neto","Ciência da Computação"));
        assertEquals("MATRÍCULA JÁ CADASTRADA!", this.controlador.cadastraAluno("123","PÃO","Engenharia de Alimentos"));
        assertThrows(IllegalArgumentException.class, () -> this.controlador.cadastraAluno(null,null,null));
        assertThrows(IllegalArgumentException.class, () -> this.controlador.cadastraAluno("","",""));
    }

    @Test
    void consultaAlunos() {
        this.controlador.cadastraAluno("123","Neto","Ciência da Computação");
        assertEquals("123 - Neto - Ciência da Computação", this.controlador.consultaAlunos("123"));
        assertEquals("Aluno não cadastrado.",this.controlador.consultaAlunos("1333"));
        assertThrows(IllegalArgumentException.class, () -> this.controlador.consultaAlunos(null));
        assertThrows(IllegalArgumentException.class, () -> this.controlador.consultaAlunos(""));
    }

    @Test
    void cadastraGrupo() {
        assertEquals("CADASTRO REALIZADO!",this.controlador.cadastraGrupo("Java"));
        assertEquals("GRUPO JÁ CADASTRADO!", this.controlador.cadastraGrupo("jAvA"));
        assertThrows(IllegalArgumentException.class, () -> this.controlador.cadastraGrupo(null));
        assertThrows(IllegalArgumentException.class, () -> this.controlador.cadastraGrupo(""));
    }

    @Test
    void alocarAluno() {
        this.controlador.cadastraAluno("123","Neto","Ciência da Computação");
        assertEquals("CADASTRO REALIZADO!",this.controlador.cadastraGrupo("Java"));
        assertEquals("ALUNO ALOCADO!",this.controlador.alocarAluno("Java","123"));
        assertEquals("ALUNO ALOCADO!",this.controlador.alocarAluno("jAvA","123"));
        assertEquals("Grupo não cadastrado!",this.controlador.alocarAluno("Python","123"));
        assertEquals("Aluno não cadastrado!", this.controlador.alocarAluno("Java","11111"));
        assertEquals("Grupo não cadastrado!" + Util.pulaLinha() + "Aluno não cadastrado!", this.controlador.alocarAluno("Python","111111"));
        assertThrows(IllegalArgumentException.class, () -> this.controlador.alocarAluno(null,null));
        assertThrows(IllegalArgumentException.class, () -> this.controlador.alocarAluno("",""));
    }

    @Test
    void imprimeGrupo() {
        this.controlador.cadastraAluno("123","Neto","Ciência da Computação");
        this.controlador.cadastraAluno("321","Pão", "Engenharia de Alimentos");
        this.controlador.cadastraGrupo("Java");
        this.controlador.cadastraGrupo("JavaScript");
        this.controlador.alocarAluno("Java","123");
        this.controlador.alocarAluno("Java","321");

        String saida = Util.pulaLinha() + "Alunos do grupo Java:" + Util.pulaLinha()
                    + "* 123 - Neto - Ciência da Computação" + Util.pulaLinha()
                    + "* 321 - Pão - Engenharia de Alimentos" + Util.pulaLinha();

        assertEquals(saida,this.controlador.imprimeGrupo("Java"));
        assertEquals(saida,this.controlador.imprimeGrupo("jAvA"));
        assertEquals("Grupo não cadastrado.",this.controlador.imprimeGrupo("Python"));
        assertEquals(Util.pulaLinha() + "Alunos do grupo JavaScript:" + Util.pulaLinha(), this.controlador.imprimeGrupo("JavaScript"));
        assertThrows(IllegalArgumentException.class, () -> this.controlador.imprimeGrupo(null));
        assertThrows(IllegalArgumentException.class, () -> this.controlador.imprimeGrupo(""));
    }

    @Test
    void cadastraAlunoQuestao() {
        this.controlador.cadastraAluno("123","Neto","Ciência da Computação");
        assertEquals("ALUNO REGISTRADO!",this.controlador.cadastraAlunoQuestao("123"));
        assertEquals("Aluno não cadastrado.", this.controlador.cadastraAlunoQuestao("321"));
        assertEquals("ALUNO REGISTRADO!",this.controlador.cadastraAlunoQuestao("123"));
        assertThrows(IllegalArgumentException.class, () -> this.controlador.cadastraAlunoQuestao(null));
        assertThrows(IllegalArgumentException.class, () -> this.controlador.cadastraAlunoQuestao(""));

    }

    @Test
    void imprimeAlunosQuestoes() {
        assertEquals("Alunos:" + Util.pulaLinha(), this.controlador.imprimeAlunosQuestoes());

        this.controlador.cadastraAluno("123","Neto","Ciência da Computação");
        this.controlador.cadastraAluno("321","Pão","Engenharia de Alimentos");
        this.controlador.cadastraAlunoQuestao("123");
        this.controlador.cadastraAlunoQuestao("321");
        this.controlador.cadastraAlunoQuestao("123");
        String saida = "Alunos:" + Util.pulaLinha()
                    + "1. 123 - Neto - Ciência da Computação" + Util.pulaLinha()
                    + "2. 321 - Pão - Engenharia de Alimentos" + Util.pulaLinha()
                    + "3. 123 - Neto - Ciência da Computação" + Util.pulaLinha();

        assertEquals(saida,this.controlador.imprimeAlunosQuestoes());
    }
}