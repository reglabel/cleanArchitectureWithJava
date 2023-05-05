package br.com.rbcl.domain.aluno;

import br.com.rbcl.domain.aluno.CPF;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class CPFTest {
    @Test
    void shouldntCreateCPFWIthInvalidNumber(){
        assertThrows(IllegalArgumentException.class,
                new Executable() {
                    public void execute() throws Throwable {
                        new CPF(null);
                    }
                });
        assertThrows(IllegalArgumentException.class,
                new Executable() {
                    public void execute() throws Throwable {
                        new CPF("");
                    }
                });
        assertThrows(IllegalArgumentException.class,
                new Executable() {
                    public void execute() throws Throwable {
                        new CPF("09878767676676867868768768");
                    }
                });

    }

    @Test
    void shouldCreateCPFWithValidNumber(){
        CPF cpf = new CPF("083.863.753-10");
        assertEquals("083.863.753-10", cpf.getNumber());
    }

    @Test
    void shouldReturnCorrectNumber(){
        CPF cpf = new CPF("083.863.753-10");
        assertEquals("083.863.753-10", cpf.getNumber());
    }
}