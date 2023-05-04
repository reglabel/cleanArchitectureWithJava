import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {
    @Test
    void shouldntCreateEmailWIthInvalidAddress(){
        assertThrows(IllegalArgumentException.class,
                new Executable() {
                    public void execute() throws Throwable {
                        new Email(null);
                    }
                });
        assertThrows(IllegalArgumentException.class,
                new Executable() {
                    public void execute() throws Throwable {
                        new Email("");
                    }
                });
        assertThrows(IllegalArgumentException.class,
                new Executable() {
                    public void execute() throws Throwable {
                        new Email("invalidemail");
                    }
                });

    }

    @Test
    void shouldCreateEmailWithValidAddress(){
        Email email = new Email("user@mail.com");
        assertEquals("user@mail.com", email.getAddress());
    }

    @Test
    void shouldReturnCorrectAddress() {
        Email email = new Email("user@mail.com");
        assertEquals("user@mail.com", email.getAddress());
    }
}