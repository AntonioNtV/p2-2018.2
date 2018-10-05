package Agenda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AgendaTest {
	private Agenda agenda;
	private Contato contato1;
	private Contato contato2;
	@BeforeEach
	void agendaTest () {	
		agenda = new Agenda();
		contato1 = new Contato("Antonio", "Neto", "83718312", "u482748213","ASDASD", "ASDSADAS", 5 );
		contato2 = new Contato("Antonio", "Neto", "83718312", "23871837218","ASDASD", "ASDSADAS", 2 );

	}
	

	@Test
	void testCadastro() {
		assertEquals("Posição inválida", agenda.cadastraContato("Blee", "bleeee", "55", "73", "djashdjsahdaj", "asjdhsajd", 5, 101));
	}
	
	@Test
	void testEqualsContato() {
		assertEquals(contato1, contato2);
	}

}
