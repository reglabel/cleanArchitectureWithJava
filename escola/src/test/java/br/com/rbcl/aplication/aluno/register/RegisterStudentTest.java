package br.com.rbcl.aplication.aluno.register;

import br.com.rbcl.domain.aluno.CPF;
import br.com.rbcl.domain.aluno.Student;
import br.com.rbcl.infra.aluno.RepositoryOsStudentsInMemory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterStudentTest {

    @Test
    void studentShouldBePreserved() {
        // MOCK -> Mockito
        RepositoryOsStudentsInMemory repository = new RepositoryOsStudentsInMemory();
        RegisterStudent useCase = new RegisterStudent(repository);

        RegisterStudentDTO data = new RegisterStudentDTO("Fulano", "123.456.789-00", "fulano@email.com");

        useCase.execute(data);

        try {
            Student found = repository.searchByCPF(new CPF("123.456.789-00"));

            assertEquals("Fulano", found.getName());
            assertEquals("123.456.789-00", found.getCpf());
            assertEquals("fulano@email.com", found.getEmail());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}