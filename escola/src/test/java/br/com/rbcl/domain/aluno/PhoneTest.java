package br.com.rbcl.domain.aluno;

import br.com.rbcl.domain.aluno.Phone;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class PhoneTest {
    @Test
    void shouldntCreatePhoneWIthInvalidNumber(){
        assertThrows(IllegalArgumentException.class,
                new Executable() {
                    public void execute() throws Throwable {
                        new Phone(null);
                    }
                });
        assertThrows(IllegalArgumentException.class,
                new Executable() {
                    public void execute() throws Throwable {
                        new Phone("");
                    }
                });
        assertThrows(IllegalArgumentException.class,
                new Executable() {
                    public void execute() throws Throwable {
                        new Phone("09878767676676867868768768");
                    }
                });

    }

    @Test
    void shouldCreateCPFWithValidNumber(){
        Phone phoneWithPontuation = new Phone("(86) 99844-1481");
        Phone phoneWithoutPontuation = new Phone("86998441481");

        assertEquals("(86) 99844-1481", phoneWithPontuation.getNumber());
        assertEquals("86998441481", phoneWithoutPontuation.getNumber());
    }
    
    @Test
    void shouldReturnCorrectNumber() {
        Phone phone = new Phone("(86) 99844-1481");
        assertEquals("(86) 99844-1481", phone.getNumber());
    }
}